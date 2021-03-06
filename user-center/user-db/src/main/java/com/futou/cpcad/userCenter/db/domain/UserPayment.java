package com.futou.cpcad.userCenter.db.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class UserPayment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Byte NOT_DELETED = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Byte IS_DELETED = 1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.uid
     *
     * @mbg.generated
     */
    private String uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.pay_type
     *
     * @mbg.generated
     */
    private String payType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.pay_account
     *
     * @mbg.generated
     */
    private String payAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.pay_name
     *
     * @mbg.generated
     */
    private String payName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.pay_id
     *
     * @mbg.generated
     */
    private String payId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.latest_time
     *
     * @mbg.generated
     */
    private LocalDateTime latestTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_payment.deleted
     *
     * @mbg.generated
     */
    private Byte deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.id
     *
     * @return the value of user_payment.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.id
     *
     * @param id the value for user_payment.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.uid
     *
     * @return the value of user_payment.uid
     *
     * @mbg.generated
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.uid
     *
     * @param uid the value for user_payment.uid
     *
     * @mbg.generated
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.pay_type
     *
     * @return the value of user_payment.pay_type
     *
     * @mbg.generated
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.pay_type
     *
     * @param payType the value for user_payment.pay_type
     *
     * @mbg.generated
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.pay_account
     *
     * @return the value of user_payment.pay_account
     *
     * @mbg.generated
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.pay_account
     *
     * @param payAccount the value for user_payment.pay_account
     *
     * @mbg.generated
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.pay_name
     *
     * @return the value of user_payment.pay_name
     *
     * @mbg.generated
     */
    public String getPayName() {
        return payName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.pay_name
     *
     * @param payName the value for user_payment.pay_name
     *
     * @mbg.generated
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.pay_id
     *
     * @return the value of user_payment.pay_id
     *
     * @mbg.generated
     */
    public String getPayId() {
        return payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.pay_id
     *
     * @param payId the value for user_payment.pay_id
     *
     * @mbg.generated
     */
    public void setPayId(String payId) {
        this.payId = payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.add_time
     *
     * @return the value of user_payment.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.add_time
     *
     * @param addTime the value for user_payment.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.latest_time
     *
     * @return the value of user_payment.latest_time
     *
     * @mbg.generated
     */
    public LocalDateTime getLatestTime() {
        return latestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.latest_time
     *
     * @param latestTime the value for user_payment.latest_time
     *
     * @mbg.generated
     */
    public void setLatestTime(LocalDateTime latestTime) {
        this.latestTime = latestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_payment.deleted
     *
     * @return the value of user_payment.deleted
     *
     * @mbg.generated
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_payment.deleted
     *
     * @param deleted the value for user_payment.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
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
        sb.append(", uid=").append(uid);
        sb.append(", payType=").append(payType);
        sb.append(", payAccount=").append(payAccount);
        sb.append(", payName=").append(payName);
        sb.append(", payId=").append(payId);
        sb.append(", addTime=").append(addTime);
        sb.append(", latestTime=").append(latestTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
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
        UserPayment other = (UserPayment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayAccount() == null ? other.getPayAccount() == null : this.getPayAccount().equals(other.getPayAccount()))
            && (this.getPayName() == null ? other.getPayName() == null : this.getPayName().equals(other.getPayName()))
            && (this.getPayId() == null ? other.getPayId() == null : this.getPayId().equals(other.getPayId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getLatestTime() == null ? other.getLatestTime() == null : this.getLatestTime().equals(other.getLatestTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayAccount() == null) ? 0 : getPayAccount().hashCode());
        result = prime * result + ((getPayName() == null) ? 0 : getPayName().hashCode());
        result = prime * result + ((getPayId() == null) ? 0 : getPayId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getLatestTime() == null) ? 0 : getLatestTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? IS_DELETED : NOT_DELETED);
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "CHAR", false),
        uid("uid", "uid", "CHAR", true),
        payType("pay_type", "payType", "VARCHAR", false),
        payAccount("pay_account", "payAccount", "VARCHAR", false),
        payName("pay_name", "payName", "VARCHAR", false),
        payId("pay_id", "payId", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        latestTime("latest_time", "latestTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "TINYINT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
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
         * This method corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_payment
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
         * This method corresponds to the database table user_payment
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