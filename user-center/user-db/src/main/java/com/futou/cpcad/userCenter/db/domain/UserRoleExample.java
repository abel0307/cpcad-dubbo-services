package com.futou.cpcad.userCenter.db.domain;

import java.util.ArrayList;
import java.util.List;

public class UserRoleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_role
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_role
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_role
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public UserRoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public UserRoleExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public UserRoleExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Criteria newAndCreateCriteria() {
        UserRoleExample example = new UserRoleExample();
        return example.createCriteria();
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_role
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIdEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIdNotEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIdGreaterThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIdGreaterThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIdLessThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIdLessThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleNameEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleNameNotEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleNameGreaterThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleNameGreaterThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleNameLessThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleNameLessThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("role_code is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("role_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("role_code =", value, "roleCode");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleCodeEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_code = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("role_code <>", value, "roleCode");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleCodeNotEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_code <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("role_code >", value, "roleCode");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleCodeGreaterThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_code > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("role_code >=", value, "roleCode");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleCodeGreaterThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_code >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("role_code <", value, "roleCode");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleCodeLessThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_code < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("role_code <=", value, "roleCode");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andRoleCodeLessThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("role_code <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("role_code like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("role_code not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("role_code in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("role_code not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("role_code between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("role_code not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andStatusEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("`status` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andStatusNotEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("`status` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andStatusGreaterThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("`status` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andStatusGreaterThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("`status` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andStatusLessThanColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("`status` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andStatusLessThanOrEqualToColumn(UserRole.Column column) {
            addCriterion(new StringBuilder("`status` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_role
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private UserRoleExample example;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        protected Criteria(UserRoleExample example) {
            super();
            this.example = example;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public UserRoleExample example() {
            return this.example;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        /**
         * This interface was generated by MyBatis Generator.
         * This interface corresponds to the database table user_role
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public interface ICriteriaAdd {
            /**
             * This method was generated by MyBatis Generator.
             * This method corresponds to the database table user_role
             *
             * @mbg.generated
             * @project https://github.com/itfsw/mybatis-generator-plugin
             */
            Criteria add(Criteria add);
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_role
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}