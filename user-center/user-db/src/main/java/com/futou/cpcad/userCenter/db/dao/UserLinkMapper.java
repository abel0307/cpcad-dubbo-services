package com.futou.cpcad.userCenter.db.dao;

import com.futou.cpcad.userCenter.db.domain.UserLink;
import com.futou.cpcad.userCenter.db.domain.UserLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLinkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    long countByExample(UserLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int deleteByExample(UserLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int insert(UserLink record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int insertSelective(UserLink record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserLink selectOneByExample(UserLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserLink selectOneByExampleSelective(@Param("example") UserLinkExample example, @Param("selective") UserLink.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<UserLink> selectByExampleSelective(@Param("example") UserLinkExample example, @Param("selective") UserLink.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    List<UserLink> selectByExample(UserLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserLink selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") UserLink.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    UserLink selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserLink record, @Param("example") UserLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserLink record, @Param("example") UserLinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserLink record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_link
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserLink record);
}