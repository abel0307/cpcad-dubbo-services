package com.futou.cpcad.userCenter.db.dao;

import com.futou.cpcad.userCenter.db.domain.UserProperty;
import com.futou.cpcad.userCenter.db.domain.UserPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPropertyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    long countByExample(UserPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int deleteByExample(UserPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int insert(UserProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int insertSelective(UserProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserProperty selectOneByExample(UserPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserProperty selectOneByExampleSelective(@Param("example") UserPropertyExample example, @Param("selective") UserProperty.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<UserProperty> selectByExampleSelective(@Param("example") UserPropertyExample example, @Param("selective") UserProperty.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    List<UserProperty> selectByExample(UserPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserProperty selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") UserProperty.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    UserProperty selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserProperty record, @Param("example") UserPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserProperty record, @Param("example") UserPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_property
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserProperty record);
}