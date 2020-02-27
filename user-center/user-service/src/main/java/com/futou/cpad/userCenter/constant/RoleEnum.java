package com.futou.cpad.userCenter.constant;

public enum RoleEnum {
    BOSS("boss"),
    AGENT("agent"),
    STAFF("staff"),
    CLIENT("client"),
    OPERATION("operation");


    private String keyValue;

    RoleEnum(String keyValue) {
        this.keyValue=keyValue;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}
