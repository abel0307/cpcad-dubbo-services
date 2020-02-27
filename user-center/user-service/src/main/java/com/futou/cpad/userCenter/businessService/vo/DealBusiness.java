package com.futou.cpad.userCenter.businessService.vo;


import com.futou.cpad.userCenter.businessService.userProperty.constant.TradeBusinessTypeEnum;

import java.math.BigDecimal;

public class DealBusiness {

    private TradeBusinessTypeEnum tradeBusinessTypeEnum;

    private String userId;

    private BigDecimal transactionAmount;

    private String activityId;

    private String withdrawApplicatonId;

    private String orderId;

    private String businessId;

    private BigDecimal serviceCharge;

    public TradeBusinessTypeEnum getTradeBusinessTypeEnum() {
        return tradeBusinessTypeEnum;
    }

    public void setTradeBusinessTypeEnum(TradeBusinessTypeEnum tradeBusinessTypeEnum) {
        this.tradeBusinessTypeEnum = tradeBusinessTypeEnum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getWithdrawApplicatonId() {
        return withdrawApplicatonId;
    }

    public void setWithdrawApplicatonId(String withdrawApplicatonId) {
        this.withdrawApplicatonId = withdrawApplicatonId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
