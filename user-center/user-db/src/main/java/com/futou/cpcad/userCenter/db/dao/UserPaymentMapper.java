package com.futou.cpcad.userCenter.db.dao;

import com.futou.cpcad.userCenter.db.domain.UserPayment;
import com.futou.cpcad.userCenter.db.domain.UserPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPaymentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    long countByExample(UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int deleteByExample(UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int insert(UserPayment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int insertSelective(UserPayment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserPayment selectOneByExample(UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserPayment selectOneByExampleSelective(@Param("example") UserPaymentExample example, @Param("selective") UserPayment.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<UserPayment> selectByExampleSelective(@Param("example") UserPaymentExample example, @Param("selective") UserPayment.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    List<UserPayment> selectByExample(UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserPayment selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") UserPayment.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    UserPayment selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserPayment selectByPrimaryKeyWithLogicalDelete(@Param("id") String id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserPayment record, @Param("example") UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserPayment record, @Param("example") UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserPayment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserPayment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") UserPaymentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_payment
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(String id);
}