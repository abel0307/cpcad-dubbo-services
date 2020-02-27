package com.futou.cpad.userCenter.businessService.userProperty.constant;

public enum TransactionTypeEnum {

    FREEZE((byte)-1, "冻结"),

    UNFREEZE((byte)1, "解冻"),

    INCOME((byte)2, "收入"),

    DISBURSE((byte)-2, "支出");

    private Byte code;
    private String name;

    TransactionTypeEnum(Byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


