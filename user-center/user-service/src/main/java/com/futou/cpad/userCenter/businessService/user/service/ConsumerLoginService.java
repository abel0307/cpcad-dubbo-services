package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpcad.core.util.ResponseData;
import com.futou.cpcad.db.domain.UserLink;
import com.futou.cpcad.db.domain.UserMobile;
import com.futou.cpcad.db.domain.UserWx;
import com.futou.cpcad.service.mp.service.MpAuthTokenService;
import com.futou.cpcad.service.mp.service.MpUserService;
import com.futou.cpcad.service.mp.service.TemplateMsg4BusinessService;
import com.futou.cpcad.service.user.vo.CommonSession;
import com.futou.cpcad.service.user.vo.UserRegisterVo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.common.utils.crypt.JwtTokenUtil.createToken;
import static com.futou.cpcad.common.utils.crypt.JwtTokenUtil.getUidFromToken;
import static com.futou.cpcad.common.utils.datetime.DateTimeUtil.getDateTimeAsString;
import static com.futou.cpcad.constant.CommonConstant.*;
import static com.futou.cpcad.core.util.JacksonUtil.toJSONString;
import static com.futou.cpcad.core.util.ResponseData.*;
import static com.futou.cpcad.util.UserCheckUtil.*;
import static java.util.concurrent.TimeUnit.DAYS;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Service
@Transactional
@SuppressWarnings({"unchecked"})
public class ConsumerLoginService {

  private final Logger logger = getLogger(getClass());

  @Resource
  private UserRegisterService userRegisterService;

  @Resource
  private UserInfoService userInfoService;

  @Resource
  private UserAuthService userAuthService;

  @Resource
  private UserSessionService userSessionService;

  @Resource
  private ValidationCodeService validationCodeService;

  @Resource
  private MpUserService mpUserService;

  @Resource
  private MpAuthTokenService mpAuthTokenService;

  @Resource
  private TemplateMsg4BusinessService templateMsg4BusinessService;

  public ResponseData<String> login(
      String ip,
      String userType,
      String sessionId,
      UserRegisterVo vo
  ) {
    /* 基础参数校验 */
    ResponseData check = checkUserCommon(
        userType,
        vo.getCategory(),
        vo.getChannel()
    );
    if (!check.isOk()) {
      return check;
    }

    if (!CHANNEL_QR_CODE.equals(vo.getChannel())) {
      check = checkMobile(vo.getMobile());
      if (!check.isOk()) {
        return check;
      }
    }

    /* 业务参数校验 */
    /* 更新Redis */
    ResponseData<String> tokenData;
    switch (vo.getCategory()) {
      case CATEGORY_PC:
        switch (vo.getChannel()) {
          case CHANNEL_PASSWORD:
            tokenData = loginByPasswordFromPc(sessionId, userType, vo);
            break;
          case CHANNEL_QR_CODE:
            tokenData = loginByQrCodeFromPc(sessionId, userType, vo);
            break;
          default:
            return fail(10109999, "Unsupported channel: " + vo.getChannel());
        }
        break;
      case CATEGORY_WE_CHAT:
        switch (vo.getChannel()) {
          case CHANNEL_TEXT:
            tokenData = loginByTextFromWeChat(sessionId, userType, vo);
            break;
          case CHANNEL_PASSWORD:
            tokenData = loginByPasswordFromWeChat(sessionId, userType, vo);
            break;
          case CHANNEL_QR_CODE:
            tokenData = loginByQrCodeFromWeChat(sessionId, userType, vo);
            break;
          default:
            return fail(10209999, "Unsupported channel: " + vo.getChannel());
        }
        break;
      default:
        return fail(10009999, "Unsupported category: " + vo.getCategory());
    }

    /* 更新登录时间戳、ip信息 */
    if (tokenData.isOk()) {
      String token = tokenData.getData();
      String uid = getUidFromToken(token);

      boolean saveAuth = userSessionService
          .setAuthToken(uid, vo.getCategory(), token);
      if (!saveAuth) {
        logger.warn("{} uid={} token={}",
            "Save auth token failed:",
            uid,
            token);
      }

      updateLoginInfo(uid, ip);
    }

    return tokenData;
  }

  private void updateLoginInfo(String uid, String ip) {
    UserMobile mobile = new UserMobile();
    mobile.setId(uid);
    if (isNotBlank(ip)) {
      mobile.setLastLoginIp(ip);
    }
    userAuthService.updateLoginInfo(mobile);
  }

  /**
   * 更新密码用户和/或微信用户信息到Redis
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param category  pc - pc端; wechat - 微信公众号端
   * @param channel text - 手机号+短信验证码登录; password - 手机号+密码登录; qrCode - pc端扫码登录/公众号端自动登录
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param userMobile  密码账户信息
   * @return  会话jwt串
   */
  private ResponseData<String> updateSession(
      String sessionId,
      String category,
      String channel,
      String userType,
      UserMobile userMobile
  ) {
    String token = createToken(userMobile.getId(), 1L, DAYS);

    switch (category) {
      case CATEGORY_PC:
        ResponseData<UserWx> data = userInfoService
            .findWeChatByUid(userMobile.getId());
        /* fix: 无论是否绑定微信均更新会话session */
        boolean save = userSessionService.savePcSession(
            sessionId, channel, userType, userMobile, data.getData());
        if (!save) {
          logger.error("{} sid={} uid={} channel={} userType={}",
              "Save pc session failed:",
              sessionId,
              userMobile.getId(),
              channel,
              userType);
        }
        break;
      case CATEGORY_WE_CHAT:
        UserWx wx = mpAuthTokenService.getWxInfo(sessionId);
        mpAuthTokenService.saveMpSession(
            sessionId, channel, userType, userMobile, wx);
        break;
      default:
        return fail(10009999, "Unknown category: " + category);
    }

    CommonSession session = userSessionService.getSession(sessionId, CommonSession.class);
    if (isNotBlank(session.getOpenid())) {
      templateMsg4BusinessService.loginSuccess(
          session.getOpenid(),
          session.getMobile(),
          getDateTimeAsString(null)
      );
    }

    return ok(token);
  }

  /**
   * 密码账号未绑定微信时，传入openid登录则自动绑定，然后更新Redis
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @param userMobile 密码账户信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginRefreshSession(
      String sessionId,
      String userType,
      UserRegisterVo vo,
      UserMobile userMobile
  ) {
    if (isNotBlank(vo.getOpenid())) {
      ResponseData bind = mpUserService
          .bindMobile(vo.getOpenid(), vo.getMobile());
      if (!bind.isOk()) {
        return bind;
      }
    }

    return updateSession(sessionId, vo.getCategory(), vo.getChannel(), userType, userMobile);
  }

  /**
   * 密码用户通过手机号和密码登录。
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByPassword(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    ResponseData<UserMobile> data = userAuthService
        .loginByPassword(vo.getMobile(), vo.getPassword());
    if (!data.isOk()) {
      return convert(data);
    }

    return loginRefreshSession(sessionId, userType, vo, data.getData());
  }

  /**
   * 密码用户通过手机号和短信验证码登录。
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByText(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    UserMobile mobile;
    ResponseData<UserMobile> data = userAuthService
        .loginByText(vo.getMobile(), vo.getText());
    if (!data.isOk()) {
      if (data.getErrno() == 10000101) {
        /* auto register */
        ResponseData<UserMobile> register = userRegisterService
            .savePasswordRegister(vo.getMobile(), DEFAULT_PASSWORD);
        if (register.isOk()) {
          mobile = register.getData();
        } else {
          return convert(register);
        }
      } else {
        return convert(data);
      }
    } else {
      mobile = data.getData();
    }

    return loginRefreshSession(sessionId, userType, vo, mobile);
  }

  /**
   * PC页面手机号+密码登录。
   * <pre>
   * sessionId- 随机串
   *
   * vo:
   *  category - pc
   *  channel  - password
   *  userType - advertiser / media_owner
   *  mobile   - 注册手机号
   *  password - 明文密码
   *  code     - 图形验证码
   *  pngId    - 验证码图片随机id
   *  openid   - 不为空则尝试绑定
   * </pre>
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByPasswordFromPc(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    ResponseData check = checkPassword(vo.getPassword());
    if (!check.isOk()) {
      return check;
    }

    check = validationCodeService
        .isCorrectImageCode(vo.getPngId(), vo.getCode());
    if (!check.isOk()) {
      return check;
    }

    return loginByPassword(sessionId, userType, vo);
  }

  /**
   * PC页面微信扫码登录。
   * <pre>
   * sessionId- 随机串
   *
   * vo:
   *  category - pc
   *  channel  - qrCode
   *  userType - media_owner
   *  openid   - openid
   * </pre>
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByQrCodeFromPc(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    ResponseData check = checkOpenid(vo.getOpenid());
    if (!check.isOk()) {
      return check;
    }

    ResponseData<UserWx> weChatData = userInfoService
        .findWeChatByOpenid(vo.getOpenid());
    if (!weChatData.isOk()) {
      /* redirect to /showtime/register */
      return fail(10000404, "/showtime/register");
    }

    UserLink link = mpUserService.hasBind(vo.getOpenid());
    if (link == null) {
      /* redirect to /showtime/login */
      return fail(10000401, "/showtime/login");
    }

    ResponseData<UserMobile> mobileData = userInfoService
        .findMobileByUid(link.getUid());
    if (!mobileData.isOk()) {
      logger.error("{} sid={} openid={} uid={} error={}",
          "Query mobile info failed:",
          sessionId,
          link.getOpenid(),
          link.getUid(),
          toJSONString(mobileData));
      return fail(10000404, "密码账户数据异常");
    }

    return updateSession(sessionId, vo.getCategory(), vo.getChannel(), userType, mobileData.getData());
  }

  /**
   * 微信公众号页面手机号+短信验证码登录。
   * <pre>
   * sessionId- openid
   *
   * vo:
   *  category - wechat
   *  channel  - text
   *  userType - media_owner
   *  mobile   - 注册手机号
   *  text     - 短信验证码
   *  openid   - 不为空则尝试绑定
   * </pre>
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByTextFromWeChat(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    if (isBlank(vo.getText())) {
      return fail(10001108, "短信验证码必输");
    }

    ResponseData check = checkOpenid(vo.getOpenid());
    if (!check.isOk()) {
      return check;
    }

    return loginByText(sessionId, userType, vo);
  }

  /**
   * 微信公众号页面手机号+密码登录。
   * <pre>
   * sessionId- openid
   *
   * vo:
   *  category - wechat
   *  channel  - password
   *  userType - media_owner
   *  mobile   - 注册手机号
   *  password - 明文密码
   *  openid   - 不为空则尝试绑定
   * </pre>
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByPasswordFromWeChat(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    ResponseData check = checkOpenid(vo.getOpenid());
    if (!check.isOk()) {
      return check;
    }

    return loginByPassword(sessionId, userType, vo);
  }

  /**
   * 微信公众号页面自动登录。
   * <pre>
   * sessionId- openid
   *
   * vo:
   *  category - wechat
   *  channel  - qrCode
   *  userType - media_owner
   *  openid   - 不为空则尝试绑定
   * </pre>
   *
   * @param sessionId 会话id(pc - 随机串; wechat - openid)
   * @param userType  advertiser - 广告主; media_owner - 媒体主
   * @param vo 登录元信息
   * @return  会话jwt串
   */
  private ResponseData<String> loginByQrCodeFromWeChat(
      String sessionId,
      String userType,
      UserRegisterVo vo
  ) {
    ResponseData<UserLink> link = userInfoService
        .findLinkByOpenid(sessionId);
    if (!link.isOk()) {
      return convert(link);
    }

    ResponseData<UserMobile> mobileData = userInfoService
        .findMobileByUid(link.getData().getUid());
    if (!mobileData.isOk()) {
      return convert(mobileData);
    }

    UserMobile mobile = mobileData.getData();
    return updateSession(sessionId, vo.getCategory(), vo.getChannel(), userType, mobile);
  }

}
