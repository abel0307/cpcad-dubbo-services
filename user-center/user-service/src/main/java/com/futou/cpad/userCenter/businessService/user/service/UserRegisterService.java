package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpad.userCenter.businessService.UserLinkService;
import com.futou.cpad.userCenter.businessService.UserMobileService;
import com.futou.cpad.userCenter.businessService.userProperty.UserPropertyService;
import com.futou.cpcad.common.utils.crypt.BCryptPasswordEncoder;
import com.futou.cpcad.core.util.ResponseData;
import com.futou.cpcad.userCenter.db.domain.UserLink;
import com.futou.cpcad.userCenter.db.domain.UserMobile;
import com.futou.cpcad.userCenter.db.domain.UserProperty;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static com.futou.cpad.userCenter.constant.ConstantEnum.STATUS_VALID;
import static com.futou.cpcad.common.utils.id.UuidUtil.getSnowFlakeId;
import static com.futou.cpcad.core.util.ResponseData.fail;
import static com.futou.cpcad.core.util.ResponseData.ok;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Transactional
@Service
public class UserRegisterService {

  private final Logger logger = getLogger(getClass());

  @Resource
  private UserMobileService userMobileService;

  @Resource
  private UserLinkService userLinkService;

  @Resource
  private UserPropertyService userPropertyService;

  public ResponseData savePasswordRegister(
      String mobile,
      String password
  ) {
    UserMobile userMobile = userMobileService.findAuthUserMobile(mobile, null);
    if (userMobile != null) {
      return fail(10000000, "该手机号已注册，请直接登录");
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    userMobile = new UserMobile();
    userMobile.setId(getSnowFlakeId());
    userMobile.setMobile(mobile);
    userMobile.setPassword(encoder.encode(password));
    userMobile.setStatus(STATUS_VALID.getValue());
    int addResult = userMobileService.add(userMobile);

    if (addResult == -1) {
      return fail(10000000, "该手机号已注册，请直接登录");
    }
    if (addResult != 1) {
      logger.error("{} result={} mobile={}",
          "Password register user failed:",
          addResult,
          mobile);
      return fail(10000000, "注册失败");
    }

    //初始化用户的资产信息
    UserProperty userProperty=new UserProperty();
    userProperty.setId(getSnowFlakeId());
    userProperty.setUserId(userMobile.getId());
    userProperty.setAvailableBalance(BigDecimal.ZERO);
    userProperty.setFreezeBalance(BigDecimal.ZERO);

    userProperty.setIntegral(0);
    userProperty.setCouponAmount(0);
    int userPropertyResult=userPropertyService.add(userProperty);
    if (userPropertyResult != 1) {
      logger.error("{} result={} mobile={}",
          "Password register user failed:",
          userPropertyResult,
          mobile);
      return fail(10000000, "注册失败");
    }

    return ok(userMobile);
  }

  /* 已关注公众号且尚未注册的微信用户进行注册 */
  public ResponseData saveWxRegister(
      String openid,
      String mobile,
      String password
  ) {
    if (isBlank(openid)) {
      return savePasswordRegister(mobile, password);
    }

    UserLink userLink = userLinkService.findByOpenid(openid);
    if (userLink != null) {
      return fail(10000000, "此微信号已绑定账号，无法再次绑定");
    }

    ResponseData responseData = savePasswordRegister(mobile, password);
    if (!responseData.isOk()) {
      return responseData;
    }

    UserMobile record = (UserMobile) responseData.getData();
    userLink = new UserLink();
    userLink.setId(getSnowFlakeId());
    userLink.setUid(record.getId());
    userLink.setOpenid(openid);

    int addUserLinkStatus = userLinkService.add(userLink);
    if (addUserLinkStatus == -1) {
      return fail(10000100, "已绑定，无需重复绑定微信");
    }
    if (addUserLinkStatus == 0) {
      return fail(10000100, "绑定微信号失败");
    }

    return ok();
  }

}
