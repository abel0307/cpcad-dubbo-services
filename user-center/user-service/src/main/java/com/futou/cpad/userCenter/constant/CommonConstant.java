package com.futou.cpad.userCenter.constant;

import com.futou.cpcad.core.util.ResponseData;

import static com.futou.cpcad.core.util.ResponseData.fail;
import static com.futou.cpcad.core.util.ResponseData.ok;
import static java.util.concurrent.TimeUnit.DAYS;

public final class CommonConstant {

  public static final String DEFAULT_PASSWORD = "CpcAd123";

  public static final String CONSUMER_TOKEN_KEY = "authorization";

  /* For fe and Controller */
  public static final String CPC_AD_COOKIE = "cpc_ad";

  public static final int TICKET_EXPIRE_SECONDS = 60;
  /* PC端登录会话有效时长(秒数) */
  public static final long PC_SESSION_EXPIRE_SECONDS = DAYS.toSeconds(1);
  /* 微信端自动登录会话有效时长(秒数) */
  public static final long WX_SESSION_EXPIRE_SECONDS = DAYS.toSeconds(30);
  /* PC端cookie有效时长(秒数) */
  public static final long COOKIE_EXPIRE_SECONDS = DAYS.toSeconds(30);

  /* For be in Redis */
  public static final String FIELD_SESSION_ID = "sessionId";
  public static final String FIELD_TOKEN = "token";

  public static final String FIELD_USER_CHANNEL = "channel";
  public static final String FIELD_USER_TYPE = "userType";

  public static final String FIELD_UID = "uid";
  public static final String FIELD_MOBILE = "mobile";
  public static final String FIELD_LATEST_TIME = "latestTime";

  public static final String FIELD_OPENID = "openid";
  public static final String FIELD_NICKNAME = "nickname";
  public static final String FIELD_AVATAR = "avatar";

  /* pc qrCode - start */
  public static final String FIELD_URL = "url";
  public static final String FIELD_TICKET = "ticket";
  public static final String FIELD_TICKET_EXPIRED = "ticketExpired";
  public static final String FIELD_SCENE = "scene";
  public static final String FIELD_SCAN_STATUS = "scanStatus";
  public static final String FIELD_REDIRECT_URL = "redirectUrl";
  /*  - end */

  /* wechat - start */
  public static String FIELD_ACCESS_TOKEN = "accessToken";
  public static String FIELD_EXPIRES_IN = "expiresIn";
  public static String FIELD_REFRESH_TOKEN = "refreshToken";
  public static String FIELD_SCOPE = "scope";
  public static String FIELD_UNION_ID = "unionId";
  public static String FIELD_ACCESS_TOKEN_EXPIRED = "accessTokenExpired";
  /* wechat - end */

  public static final Object[] SESSION_DTO_FIELDS = {
      FIELD_SESSION_ID,
      FIELD_TOKEN,
      FIELD_USER_CHANNEL,
      FIELD_USER_TYPE,
      FIELD_UID,
      FIELD_MOBILE,
      FIELD_LATEST_TIME,
      FIELD_OPENID,
      FIELD_NICKNAME,
      FIELD_AVATAR,
      FIELD_URL,
      FIELD_TICKET,
      FIELD_TICKET_EXPIRED,
      FIELD_SCENE,
      FIELD_SCAN_STATUS,
      FIELD_REDIRECT_URL
  };

  public static final String USER_TYPE_AD = "advertiser";
  public static final String USER_TYPE_MEDIA = "media_owner";

  public static final String CATEGORY_PC = "pc";
  public static final String CATEGORY_WE_CHAT = "wechat";

  public static final String CHANNEL_TEXT = "text";
  public static final String CHANNEL_PASSWORD = "password";
  public static final String CHANNEL_QR_CODE = "qrCode";

  public static final String LEFT_MONEY = "money";
  public static final String LEFT_SCORE = "score";

  public static final String INFO_BIND = "account";
  public static final String INFO_PAYMENT = "payment";
  public static final String INFO_COMPANY = "company";

  private static boolean validateUserType(String userType) {
    return USER_TYPE_AD.equals(userType)
        || USER_TYPE_MEDIA.equals(userType);
  }

  private static boolean validateCategory(String category) {
    return CATEGORY_PC.equals(category)
        || CATEGORY_WE_CHAT.equals(category);
  }

  private static boolean validateChannel(String channel) {
    return CHANNEL_TEXT.equals(channel)
        || CHANNEL_PASSWORD.equals(channel)
        || CHANNEL_QR_CODE.equals(channel);
  }

  public static ResponseData checkUserCommon(
      String userType,
      String category,
      String channel
  ) {
    if (!validateUserType(userType)) {
      return fail(10001000, "非法请求");
    }

    if (!validateCategory(category)) {
      return fail(10001001, "非法请求");
    }

    if (!validateChannel(channel)) {
      return fail(10001002, "非法请求");
    }

    return ok();
  }

}
