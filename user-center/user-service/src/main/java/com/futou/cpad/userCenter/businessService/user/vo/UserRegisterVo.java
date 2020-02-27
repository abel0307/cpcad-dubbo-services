package com.futou.cpad.userCenter.businessService.user.vo;

import java.io.Serializable;

public class UserRegisterVo implements Serializable {
  private static final long serialVersionUID = -6255958827897139675L;

  private String mobile;
  /**
   * 图形验证码
   */
  private String code;
  /**
   * 图形id
   */
  private String pngId;
  /**
   * 短信验证码
   */
  private String text;
  private String password;
  /**
   * 分类: pc - pc端; wechat - 微信端
   */
  private String category;
  /**
   * 渠道码: text - 短信验证码登录; password - 账号密码注册; qrCode - 微信扫码注册
   */
  private String channel;
  private String openid;

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPngId() {
    return pngId;
  }

  public void setPngId(String pngId) {
    this.pngId = pngId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }
}
