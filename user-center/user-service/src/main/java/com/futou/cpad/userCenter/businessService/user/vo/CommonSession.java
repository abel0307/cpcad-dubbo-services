package com.futou.cpad.userCenter.businessService.user.vo;

import java.io.Serializable;

public class CommonSession implements Serializable {

  private static final long serialVersionUID = 4165788292798966941L;

  /* session */
  private String sessionId;
  private String token;

  /* login info */
  private String channel;
  private String userType;

  /* mobile info */
  private String uid;
  private String mobile;
  private String latestTime;

  /* WeChat info */
  private String openid;
  private String nickname;
  private String avatar;

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getLatestTime() {
    return latestTime;
  }

  public void setLatestTime(String latestTime) {
    this.latestTime = latestTime;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

}
