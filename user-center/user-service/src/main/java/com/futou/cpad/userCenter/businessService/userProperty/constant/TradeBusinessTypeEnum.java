package com.futou.cpad.userCenter.businessService.userProperty.constant;

public enum TradeBusinessTypeEnum {

    CHARGE((byte)0, "支付宝充值","adOwner",TransactionTypeEnum.INCOME,"支付宝充值"),

    CREATE_ACTIVITY((byte)1, "创建推广活动，冻结预估推广金额","adOwner",TransactionTypeEnum.FREEZE,"推广活动id:%s"),

    ADOWNER_ORDER_SETTLEMENT((byte)2, "推广活动的订单结算，广告消费完成","adOwner",TransactionTypeEnum.DISBURSE,"推广活动id:%s,结算订单id:%s"),

    MEDIA_ORDER_SETTLEMENT((byte)3, "接单推广订单结算，广告收入到账","media",TransactionTypeEnum.INCOME,"推广活动id:%s,结算订单id:%s"),

    ACTIVITY_OVER((byte)4, "推广活动结束，解冻-冻结的推广金额","adOwner",TransactionTypeEnum.UNFREEZE,"推广活动id:%s"),

    WITHDRAW_APPLICATION((byte)5, "提交提现申请","adOwner_media",TransactionTypeEnum.FREEZE,"提现申请id:%s,提现手续费:%s"),

    WITHDRAW_FINSISH((byte)6, "提现申请通过，平台打款到提现账户","adOwner_media",TransactionTypeEnum.DISBURSE,"提现申请id:%s,提现手续费:%s"),

    UPDATE_ACTIVITY_ADD((byte)7, "更新推广活动信息,追加预算，冻结预估推广金额","adOwner",TransactionTypeEnum.FREEZE,"推广活动id:%s"),

    UPDATE_ACTIVITY_REDUCE((byte)8, "更新推广活动信息,减少预算，解冻推广金额","adOwner",TransactionTypeEnum.UNFREEZE,"推广活动id:%s");


    private Byte code;
    private String name;
    private String owner;
    private TransactionTypeEnum transactionTypeEnum;
    private String transactionDesc;

    TradeBusinessTypeEnum(Byte code, String name, String owner, TransactionTypeEnum transactionTypeEnum, String transactionDesc) {
        this.code = code;
        this.name = name;
        this.owner = owner;
        this.transactionTypeEnum = transactionTypeEnum;
        this.transactionDesc = transactionDesc;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public TransactionTypeEnum getTransactionTypeEnum() {
        return transactionTypeEnum;
    }

    public void setTransactionTypeEnum(TransactionTypeEnum transactionTypeEnum) {
        this.transactionTypeEnum = transactionTypeEnum;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }
}


