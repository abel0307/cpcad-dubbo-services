package com.futou.cpad.userCenter.businessService.vo;

public class QueryBillLogVo extends BaseParam {

    private String uid;

    private Byte transactionType;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Byte getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Byte transactionType) {
        this.transactionType = transactionType;
    }
}
