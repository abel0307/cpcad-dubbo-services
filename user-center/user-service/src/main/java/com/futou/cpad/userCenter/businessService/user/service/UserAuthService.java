package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpad.userCenter.businessService.UserMobileService;
import com.futou.cpcad.common.utils.crypt.BCryptPasswordEncoder;
import com.futou.cpcad.core.util.ResponseData;

import com.futou.cpcad.service.message.sms.service.SmsVerificationCodeService;
import com.futou.cpcad.service.redis.util.RedisUtil;
import com.futou.cpcad.userCenter.db.domain.UserMobile;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.common.utils.regex.RegexUtil.isMobileExact;

import static com.futou.cpcad.core.util.ResponseData.*;
import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Transactional
@Service
@SuppressWarnings({"unchecked"})
public class UserAuthService {

  private final Logger logger = getLogger(getClass());

  @Resource
  private UserMobileService userMobileService;

  @Resource
  private SmsVerificationCodeService smsVerificationCodeService;

  @Resource
  private RedisUtil redisUtil;

  public ResponseData<UserMobile> loginByPassword(
      String mobile,
      String password
  ) {
    ResponseData<UserMobile> data = validationMobile(mobile);
    if (!data.isOk()) {
      return data;
    }

    UserMobile userMobile = data.getData();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    if (!encoder.matches(password, userMobile.getPassword())) {
      return fail(10000103, "手机号或密码不正确");
    }

    return ok(userMobile);
  }

  public ResponseData<UserMobile> loginByText(
      String mobile,
      String text
  ) {
    ResponseData textResponse = smsVerificationCodeService
        .validateVerificationCode(mobile, text);
    if (!textResponse.isOk()) {
      return convert(textResponse);
    }

    ResponseData<UserMobile> data = validationMobile(mobile);
    if (!data.isOk()) {
      return convert(data);
    }

    return data;
  }

  public void updateLoginInfo(UserMobile user) {
    UserMobile mobile = new UserMobile();
    mobile.setId(user.getId());
    mobile.setLastLoginIp(user.getLastLoginIp());
    mobile.setLastLoginTime(now());

    try {
      int updateResult = userMobileService.updateByPrimaryKeySelective(mobile);
      logger.info("{} result={} uid={} ts={}",
          "Update user info success:",
          updateResult,
          mobile.getId(),
          mobile.getLastLoginTime());
    } catch (Exception e) {
      logger.error("{} uid={} ts={} exception: ",
          "Update user info failed:",
          mobile.getId(),
          mobile.getLastLoginTime(),
          e);
    }
  }

  public ResponseData logout(String sessionId, String uid) {
    redisUtil.hdel(uid, CATEGORY_PC);
    redisUtil.hdel(sessionId, SESSION_DTO_FIELDS);

    return ok();
  }

  public ResponseData<UserMobile> validationMobile(
      String mobile
  ) {
    if (isBlank(mobile) || !isMobileExact(mobile)) {
      return fail(10000100, "手机号未传或手机号不正确");
    }

    long mobileTotal = userMobileService.countByMobile(mobile);
    if (mobileTotal == 0) {
      return fail(10000101, "该手机号未注册");
    }

    UserMobile userMobile = userMobileService.findAuthUserMobile(mobile, STATUS_VALID.getValue());
    if (userMobile == null) {
      return fail(10000102, "该手机号已注销");
    }

    return ok(userMobile);
  }

  public ResponseData resetPassword(
      String mobile,
      String password
  ) {
    ResponseData authResponseData = validationMobile(mobile);
    if (!authResponseData.isOk()) {
      return authResponseData;
    }

    UserMobile validUserMobile = userMobileService.findAuthUserMobile(mobile, null);
    if (validUserMobile == null) {
      return fail(10000000, "此手机号尚未注册");
    }
    if (STATUS_VALID.getValue() != validUserMobile.getStatus()) {
      return fail(10000000, "此手机号已注销");
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    UserMobile existUserMobile = (UserMobile) authResponseData.getData();
    UserMobile userMobile = new UserMobile();
    userMobile.setId(existUserMobile.getId());
    userMobile.setPassword(encoder.encode(password));

    int updateResult = userMobileService.updateByPrimaryKeySelective(userMobile);
    if (updateResult == 0) {
      return fail(10000000, "更新密码失败");
    }

    return ok();
  }

  public ResponseData modifyPassword(
      String uid,
      String oldPassword,
      String newPassword
  ) {
    UserMobile userMobile = userMobileService.findAuthUserByUid(uid, null);
    if (userMobile == null) {
      return fail(10000000, "账号不存在");
    }
    if (STATUS_VALID.getValue() != userMobile.getStatus()) {
      return fail(10000000, "无效用户，无法进行操作");
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    if (!encoder.matches(oldPassword, userMobile.getPassword())) {
      return fail(10000000, "旧密码不正确");
    }

    UserMobile user = new UserMobile();
    user.setId(uid);
    user.setPassword(encoder.encode(newPassword));

    int updateResult = userMobileService.updateByPrimaryKeySelective(user);
    if (updateResult != 1) {
      logger.error("{} result={} uid={}",
          "Modify password failed:",
          updateResult,
          uid);
      return fail(10000000, "修改密码失败，请稍后再试");
    }

    return ok();
  }
}
