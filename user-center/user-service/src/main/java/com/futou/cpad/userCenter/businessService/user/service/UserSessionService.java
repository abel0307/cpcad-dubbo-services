package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpcad.constant.SceneEnum;
import com.futou.cpcad.core.util.JacksonUtil;
import com.futou.cpcad.db.domain.UserMobile;
import com.futou.cpcad.db.domain.UserWx;
import com.futou.cpcad.service.redis.util.RedisUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.futou.cpcad.common.utils.datetime.DateTimeUtil.getDateTimeAsString;
import static com.futou.cpcad.constant.CommonConstant.*;
import static com.futou.cpcad.core.util.JacksonUtil.toJSONString;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.slf4j.LoggerFactory.getLogger;

@Transactional
@Service
public class UserSessionService {

  private final Logger logger = getLogger(getClass());

  @Resource
  private RedisUtil redisUtil;

  public <T> T getSession(String scene, Class<T> clazz) {
    String sessionId = SceneEnum.parseValue(scene);
    Map<Object, Object> sessionMap = redisUtil.hgets(sessionId);

    if (sessionMap.size() == 0) {
      return null;
    }

    return JacksonUtil.parseObject(sessionMap, clazz);
  }

  public boolean setAuthToken(String uid, String field, String token) {
    return redisUtil.hset(uid, field, token);
  }

  public static void put(
      Map<Object, Object> map,
      String key,
      Object value
  ) {
    if (value != null) {
      map.put(key, value);
    }
  }

  public static void putMobile(
      Map<Object, Object> map,
      UserMobile mobile
  ) {
    put(map, FIELD_UID, mobile.getId());
    put(map, FIELD_MOBILE, mobile.getMobile());
    put(map, FIELD_LATEST_TIME, getDateTimeAsString(mobile.getLastLoginTime()));
  }

  public static void putWeChat(
      Map<Object, Object> map,
      UserWx weChat
  ) {
    boolean isNull = weChat == null;
    put(map, FIELD_OPENID, isNull ? "" : weChat.getOpenid());
    put(map, FIELD_NICKNAME, isNull ? "---" : weChat.getNickname());
    put(map, FIELD_AVATAR, isNull ? "" : weChat.getHeadImgUrl());
  }

  public boolean saveSession(
      String sessionId,
      Map<Object, Object> session,
      Long seconds
  ) {
    boolean result = false;

    if (seconds == null) {
      seconds = PC_SESSION_EXPIRE_SECONDS;
    }

    try {
      result = redisUtil.hsets(sessionId, session, seconds, SECONDS);
    } catch (Exception e) {
      logger.error("{} sid={} session={} exception: ",
          "Save session failed:",
          sessionId,
          toJSONString(session),
          e);
    }

    return result;
  }

  public static Map<Object, Object> initSession(
      String sessionId,
      String channel,
      String userType,
      UserMobile mobile,
      UserWx weChat
  ) {
    Map<Object, Object> session = new HashMap<>(16);

    put(session, FIELD_SESSION_ID, sessionId);
    put(session, FIELD_USER_CHANNEL, channel);
    put(session, FIELD_USER_TYPE, userType);
    putMobile(session, mobile);
    putWeChat(session, weChat);

    return session;
  }

  public boolean savePcSession(
      String sessionId,
      String channel,
      String userType,
      UserMobile mobile,
      UserWx weChat
  ) {
    Map<Object, Object> session = initSession(sessionId, channel, userType, mobile, weChat);

    return saveSession(sessionId, session, null);
  }

}
