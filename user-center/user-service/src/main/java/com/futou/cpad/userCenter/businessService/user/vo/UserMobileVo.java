package com.futou.cpad.userCenter.businessService.user.vo;

import com.futou.cpad.userCenter.businessService.vo.BaseParam;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserMobileVo
    extends BaseParam
    implements Serializable {
  private static final long serialVersionUID = -3640024015887558115L;

  private String id;
  private String mobile;
  private Integer status;
  private LocalDateTime startAddTime;
  private LocalDateTime endAddTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public LocalDateTime getStartAddTime() {
    return startAddTime;
  }

  public void setStartAddTime(LocalDateTime startAddTime) {
    this.startAddTime = startAddTime;
  }

  public LocalDateTime getEndAddTime() {
    return endAddTime;
  }

  public void setEndAddTime(LocalDateTime endAddTime) {
    this.endAddTime = endAddTime;
  }
}
