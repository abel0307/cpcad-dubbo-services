package com.futou.cpad.userCenter.constant;

/**
 * 枚举常量
 *
 * @author Rtfsc8 2019-09-11 23:19
 */
public enum ConstantEnum {

  STATUS_INVALID(0, "无效"),
  STATUS_VALID(1, "有效"),

  SEX_UNKNOWN(0, "未知"),
  SEX_MALE(1, "男性"),
  SEX_FEMALE(2, "女性"),

  SUBSCRIBE_OFF(0, "未关注"),
  SUBSCRIBE_ON(1, "已关注");

  private int value;
  private String desc;

  ConstantEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public int getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
