package com.futou.cpcad.userCenter.db.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class UserCompany {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Byte NOT_DELETED = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Byte IS_DELETED = 1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.uid
     *
     * @mbg.generated
     */
    private String uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.company_name
     *
     * @mbg.generated
     */
    private String companyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.company_no
     *
     * @mbg.generated
     */
    private String companyNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.province
     *
     * @mbg.generated
     */
    private String province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.city
     *
     * @mbg.generated
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.area
     *
     * @mbg.generated
     */
    private String area;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.pca
     *
     * @mbg.generated
     */
    private String pca;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.address_detail
     *
     * @mbg.generated
     */
    private String addressDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.contact_name
     *
     * @mbg.generated
     */
    private String contactName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.contact_tel
     *
     * @mbg.generated
     */
    private String contactTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.latest_time
     *
     * @mbg.generated
     */
    private LocalDateTime latestTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_company.deleted
     *
     * @mbg.generated
     */
    private Byte deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.id
     *
     * @return the value of user_company.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.id
     *
     * @param id the value for user_company.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.uid
     *
     * @return the value of user_company.uid
     *
     * @mbg.generated
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.uid
     *
     * @param uid the value for user_company.uid
     *
     * @mbg.generated
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.company_name
     *
     * @return the value of user_company.company_name
     *
     * @mbg.generated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.company_name
     *
     * @param companyName the value for user_company.company_name
     *
     * @mbg.generated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.company_no
     *
     * @return the value of user_company.company_no
     *
     * @mbg.generated
     */
    public String getCompanyNo() {
        return companyNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.company_no
     *
     * @param companyNo the value for user_company.company_no
     *
     * @mbg.generated
     */
    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.province
     *
     * @return the value of user_company.province
     *
     * @mbg.generated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.province
     *
     * @param province the value for user_company.province
     *
     * @mbg.generated
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.city
     *
     * @return the value of user_company.city
     *
     * @mbg.generated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.city
     *
     * @param city the value for user_company.city
     *
     * @mbg.generated
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.area
     *
     * @return the value of user_company.area
     *
     * @mbg.generated
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.area
     *
     * @param area the value for user_company.area
     *
     * @mbg.generated
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.pca
     *
     * @return the value of user_company.pca
     *
     * @mbg.generated
     */
    public String getPca() {
        return pca;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.pca
     *
     * @param pca the value for user_company.pca
     *
     * @mbg.generated
     */
    public void setPca(String pca) {
        this.pca = pca;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.address_detail
     *
     * @return the value of user_company.address_detail
     *
     * @mbg.generated
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.address_detail
     *
     * @param addressDetail the value for user_company.address_detail
     *
     * @mbg.generated
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.contact_name
     *
     * @return the value of user_company.contact_name
     *
     * @mbg.generated
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.contact_name
     *
     * @param contactName the value for user_company.contact_name
     *
     * @mbg.generated
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.contact_tel
     *
     * @return the value of user_company.contact_tel
     *
     * @mbg.generated
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.contact_tel
     *
     * @param contactTel the value for user_company.contact_tel
     *
     * @mbg.generated
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.add_time
     *
     * @return the value of user_company.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.add_time
     *
     * @param addTime the value for user_company.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.latest_time
     *
     * @return the value of user_company.latest_time
     *
     * @mbg.generated
     */
    public LocalDateTime getLatestTime() {
        return latestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.latest_time
     *
     * @param latestTime the value for user_company.latest_time
     *
     * @mbg.generated
     */
    public void setLatestTime(LocalDateTime latestTime) {
        this.latestTime = latestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_company.deleted
     *
     * @return the value of user_company.deleted
     *
     * @mbg.generated
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_company.deleted
     *
     * @param deleted the value for user_company.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
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
        sb.append(", companyName=").append(companyName);
        sb.append(", companyNo=").append(companyNo);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", pca=").append(pca);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactTel=").append(contactTel);
        sb.append(", addTime=").append(addTime);
        sb.append(", latestTime=").append(latestTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
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
        UserCompany other = (UserCompany) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyNo() == null ? other.getCompanyNo() == null : this.getCompanyNo().equals(other.getCompanyNo()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getPca() == null ? other.getPca() == null : this.getPca().equals(other.getPca()))
            && (this.getAddressDetail() == null ? other.getAddressDetail() == null : this.getAddressDetail().equals(other.getAddressDetail()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactTel() == null ? other.getContactTel() == null : this.getContactTel().equals(other.getContactTel()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getLatestTime() == null ? other.getLatestTime() == null : this.getLatestTime().equals(other.getLatestTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyNo() == null) ? 0 : getCompanyNo().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getPca() == null) ? 0 : getPca().hashCode());
        result = prime * result + ((getAddressDetail() == null) ? 0 : getAddressDetail().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactTel() == null) ? 0 : getContactTel().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getLatestTime() == null) ? 0 : getLatestTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? IS_DELETED : NOT_DELETED);
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table user_company
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "CHAR", false),
        uid("uid", "uid", "CHAR", true),
        companyName("company_name", "companyName", "VARCHAR", false),
        companyNo("company_no", "companyNo", "VARCHAR", false),
        province("province", "province", "VARCHAR", false),
        city("city", "city", "VARCHAR", false),
        area("area", "area", "VARCHAR", false),
        pca("pca", "pca", "VARCHAR", false),
        addressDetail("address_detail", "addressDetail", "VARCHAR", false),
        contactName("contact_name", "contactName", "VARCHAR", false),
        contactTel("contact_tel", "contactTel", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        latestTime("latest_time", "latestTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "TINYINT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
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
         * This method corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_company
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
         * This method corresponds to the database table user_company
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