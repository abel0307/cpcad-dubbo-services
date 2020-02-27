package com.futou.cpcad.userCenter.db.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class BillLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.oreder_id
     *
     * @mbg.generated
     */
    private String orederId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.transaction_type
     *
     * @mbg.generated
     */
    private Byte transactionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.business_type
     *
     * @mbg.generated
     */
    private Byte businessType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.transaction_amount
     *
     * @mbg.generated
     */
    private BigDecimal transactionAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.freeze_balance
     *
     * @mbg.generated
     */
    private BigDecimal freezeBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.available_balance
     *
     * @mbg.generated
     */
    private BigDecimal availableBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.withdraw_application_id
     *
     * @mbg.generated
     */
    private String withdrawApplicationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.activity_id
     *
     * @mbg.generated
     */
    private String activityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.business_id
     *
     * @mbg.generated
     */
    private String businessId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.transaction_desc
     *
     * @mbg.generated
     */
    private String transactionDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_log.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.id
     *
     * @return the value of bill_log.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.id
     *
     * @param id the value for bill_log.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.user_id
     *
     * @return the value of bill_log.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.user_id
     *
     * @param userId the value for bill_log.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.oreder_id
     *
     * @return the value of bill_log.oreder_id
     *
     * @mbg.generated
     */
    public String getOrederId() {
        return orederId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.oreder_id
     *
     * @param orederId the value for bill_log.oreder_id
     *
     * @mbg.generated
     */
    public void setOrederId(String orederId) {
        this.orederId = orederId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.transaction_type
     *
     * @return the value of bill_log.transaction_type
     *
     * @mbg.generated
     */
    public Byte getTransactionType() {
        return transactionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.transaction_type
     *
     * @param transactionType the value for bill_log.transaction_type
     *
     * @mbg.generated
     */
    public void setTransactionType(Byte transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.business_type
     *
     * @return the value of bill_log.business_type
     *
     * @mbg.generated
     */
    public Byte getBusinessType() {
        return businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.business_type
     *
     * @param businessType the value for bill_log.business_type
     *
     * @mbg.generated
     */
    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.transaction_amount
     *
     * @return the value of bill_log.transaction_amount
     *
     * @mbg.generated
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.transaction_amount
     *
     * @param transactionAmount the value for bill_log.transaction_amount
     *
     * @mbg.generated
     */
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.freeze_balance
     *
     * @return the value of bill_log.freeze_balance
     *
     * @mbg.generated
     */
    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.freeze_balance
     *
     * @param freezeBalance the value for bill_log.freeze_balance
     *
     * @mbg.generated
     */
    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.available_balance
     *
     * @return the value of bill_log.available_balance
     *
     * @mbg.generated
     */
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.available_balance
     *
     * @param availableBalance the value for bill_log.available_balance
     *
     * @mbg.generated
     */
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.order_id
     *
     * @return the value of bill_log.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.order_id
     *
     * @param orderId the value for bill_log.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.withdraw_application_id
     *
     * @return the value of bill_log.withdraw_application_id
     *
     * @mbg.generated
     */
    public String getWithdrawApplicationId() {
        return withdrawApplicationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.withdraw_application_id
     *
     * @param withdrawApplicationId the value for bill_log.withdraw_application_id
     *
     * @mbg.generated
     */
    public void setWithdrawApplicationId(String withdrawApplicationId) {
        this.withdrawApplicationId = withdrawApplicationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.activity_id
     *
     * @return the value of bill_log.activity_id
     *
     * @mbg.generated
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.activity_id
     *
     * @param activityId the value for bill_log.activity_id
     *
     * @mbg.generated
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.business_id
     *
     * @return the value of bill_log.business_id
     *
     * @mbg.generated
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.business_id
     *
     * @param businessId the value for bill_log.business_id
     *
     * @mbg.generated
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.transaction_desc
     *
     * @return the value of bill_log.transaction_desc
     *
     * @mbg.generated
     */
    public String getTransactionDesc() {
        return transactionDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.transaction_desc
     *
     * @param transactionDesc the value for bill_log.transaction_desc
     *
     * @mbg.generated
     */
    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.add_time
     *
     * @return the value of bill_log.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.add_time
     *
     * @param addTime the value for bill_log.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_log.update_time
     *
     * @return the value of bill_log.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_log.update_time
     *
     * @param updateTime the value for bill_log.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_log
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orederId=").append(orederId);
        sb.append(", transactionType=").append(transactionType);
        sb.append(", businessType=").append(businessType);
        sb.append(", transactionAmount=").append(transactionAmount);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", availableBalance=").append(availableBalance);
        sb.append(", orderId=").append(orderId);
        sb.append(", withdrawApplicationId=").append(withdrawApplicationId);
        sb.append(", activityId=").append(activityId);
        sb.append(", businessId=").append(businessId);
        sb.append(", transactionDesc=").append(transactionDesc);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_log
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BillLog other = (BillLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrederId() == null ? other.getOrederId() == null : this.getOrederId().equals(other.getOrederId()))
            && (this.getTransactionType() == null ? other.getTransactionType() == null : this.getTransactionType().equals(other.getTransactionType()))
            && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
            && (this.getTransactionAmount() == null ? other.getTransactionAmount() == null : this.getTransactionAmount().equals(other.getTransactionAmount()))
            && (this.getFreezeBalance() == null ? other.getFreezeBalance() == null : this.getFreezeBalance().equals(other.getFreezeBalance()))
            && (this.getAvailableBalance() == null ? other.getAvailableBalance() == null : this.getAvailableBalance().equals(other.getAvailableBalance()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getWithdrawApplicationId() == null ? other.getWithdrawApplicationId() == null : this.getWithdrawApplicationId().equals(other.getWithdrawApplicationId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getTransactionDesc() == null ? other.getTransactionDesc() == null : this.getTransactionDesc().equals(other.getTransactionDesc()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_log
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrederId() == null) ? 0 : getOrederId().hashCode());
        result = prime * result + ((getTransactionType() == null) ? 0 : getTransactionType().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getTransactionAmount() == null) ? 0 : getTransactionAmount().hashCode());
        result = prime * result + ((getFreezeBalance() == null) ? 0 : getFreezeBalance().hashCode());
        result = prime * result + ((getAvailableBalance() == null) ? 0 : getAvailableBalance().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getWithdrawApplicationId() == null) ? 0 : getWithdrawApplicationId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getTransactionDesc() == null) ? 0 : getTransactionDesc().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table bill_log
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "VARCHAR", false),
        userId("user_id", "userId", "VARCHAR", false),
        orederId("oreder_id", "orederId", "VARCHAR", false),
        transactionType("transaction_type", "transactionType", "TINYINT", false),
        businessType("business_type", "businessType", "TINYINT", false),
        transactionAmount("transaction_amount", "transactionAmount", "DECIMAL", false),
        freezeBalance("freeze_balance", "freezeBalance", "DECIMAL", false),
        availableBalance("available_balance", "availableBalance", "DECIMAL", false),
        orderId("order_id", "orderId", "VARCHAR", false),
        withdrawApplicationId("withdraw_application_id", "withdrawApplicationId", "VARCHAR", false),
        activityId("activity_id", "activityId", "VARCHAR", false),
        businessId("business_id", "businessId", "VARCHAR", false),
        transactionDesc("transaction_desc", "transactionDesc", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table bill_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}