package com.futou.cpad.userCenter.businessService.user.vo;

import java.io.Serializable;

public class UserSession
    extends CommonSession
    implements Serializable {

  private static final long serialVersionUID = -8201418765119663133L;

  /* QrCode info */
  private String url;/* 临时二维码url */
  private String ticket;/* 临时二维码ticket */
  private long ticketExpired;/* ticket有效期 */
  private String scene;/* 二维码场景数据 */
  private boolean scanStatus;/* 二维码扫描状态 */
  private String redirectUrl;/* 扫码登录成功后的跳转uri */

  public UserSession() {}

  public UserSession(
      String sessionId,
      String ticket,
      long ticketExpired
  ) {
    this.setSessionId(sessionId);
    this.ticket = ticket;
    this.ticketExpired = ticketExpired;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public long getTicketExpired() {
    return ticketExpired;
  }

  public void setTicketExpired(long ticketExpired) {
    this.ticketExpired = ticketExpired;
  }

  public String getScene() {
    return scene;
  }

  public void setScene(String scene) {
    this.scene = scene;
  }

  public boolean isScanStatus() {
    return scanStatus;
  }

  public void setScanStatus(boolean scanStatus) {
    this.scanStatus = scanStatus;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }
}
