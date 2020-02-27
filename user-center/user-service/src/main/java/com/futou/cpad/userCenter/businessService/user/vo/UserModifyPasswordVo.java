package com.futou.cpad.userCenter.businessService.user.vo;

import java.io.Serializable;

public class UserModifyPasswordVo implements Serializable {
  private static final long serialVersionUID = 5591604867122836286L;

  private String uid;
  private String oldPassword;
  private String password;

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
