package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpad.userCenter.businessService.UserLinkService;
import com.futou.cpad.userCenter.businessService.UserMobileService;
import com.futou.cpad.userCenter.businessService.UserWxService;
import com.futou.cpcad.core.util.ResponseData;
import com.futou.cpcad.userCenter.db.domain.UserLink;
import com.futou.cpcad.userCenter.db.domain.UserMobile;
import com.futou.cpcad.userCenter.db.domain.UserWx;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.common.utils.regex.RegexUtil.isMobileExact;
import static com.futou.cpcad.core.util.ResponseData.fail;
import static com.futou.cpcad.core.util.ResponseData.ok;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Transactional
@Service
public class UserInfoService {

  private final Logger logger = getLogger(getClass());

  @Resource
  private UserMobileService userMobileService;

  @Resource
  private UserWxService userWxService;

  @Resource
  private UserLinkService userLinkService;

  public ResponseData<UserMobile> findMobileByUid(String uid) {
    if (isBlank(uid)) {
      return fail(10000100, "uid必需");
    }

    UserMobile mobile = userMobileService.findAuthUserByUid(uid, null);
    if (mobile == null) {
      logger.error("{} uid={}",
          "Found invalid uid:",
          uid);
      return fail(10000200, "无效uid");
    }

    return ok(mobile);
  }

  public ResponseData<UserLink> findLinkByUid(String uid) {
    if (isBlank(uid)) {
      return fail(10000101, "uid必需");
    }

    UserLink link = userLinkService.findByUid(uid);
    if (link == null) {
      return fail(10000201, "未绑定微信号");
    }

    return ok(link);
  }

  public ResponseData<UserLink> findLinkByOpenid(String openid) {
    if (isBlank(openid)) {
      return fail(10000102, "openid必需");
    }

    UserLink link = userLinkService.findByOpenid(openid);
    if (link == null) {
      return fail(10000202, "未关联密码账号");
    }

    return ok(link);
  }

  public ResponseData<UserWx> findWeChatByOpenid(String openid) {
    if (isBlank(openid)) {
      return fail(10000103, "openid必需");
    }

    UserWx wx = userWxService.findUserWxByOpenid(openid);
    if (wx == null) {
      logger.error("{} openid={}",
          "Found invalid openid:",
          openid);
      return fail(10000203, "无效openid");
    }

    return ok(wx);
  }

  public ResponseData<UserWx> findWeChatByUid(String uid) {
    UserLink link = userLinkService.findByUid(uid);
    if (link == null) {
      return fail(10003000, "当前用户未绑定微信号");
    }

    UserWx wx = userWxService.findUserWxByOpenid(link.getOpenid());
    if (wx == null) {
      return fail(10003001, "查询数据异常");
    }

    return ok(wx);
  }

  public ResponseData<UserMobile> findMobileByMobile(String mobile) {
    if (isBlank(mobile)) {
      return fail(10000104, "手机号必需");
    }

    if (!isMobileExact(mobile)) {
      return fail(10000105, "暂不支持此手机号");
    }

    UserMobile user = userMobileService.findAuthUserMobile(mobile, null);
    if (user == null) {
      return fail(10000204, "此手机号尚未注册");
    }

    return ok();
  }

}
