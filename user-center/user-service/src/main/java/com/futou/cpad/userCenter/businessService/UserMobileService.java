package com.futou.cpad.userCenter.businessService;

import com.futou.cpad.userCenter.businessService.user.vo.UserInfoVo;
import com.futou.cpad.userCenter.businessService.user.vo.UserMobileVo;
import com.futou.cpcad.userCenter.db.dao.UserMobileMapper;
import com.futou.cpcad.userCenter.db.domain.*;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


import static com.futou.cpad.userCenter.constant.ConstantEnum.STATUS_INVALID;
import static com.futou.cpad.userCenter.constant.ConstantEnum.STATUS_VALID;
import static com.futou.cpcad.userCenter.db.domain.UserMobile.Column.*;
import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Transactional
@Service
public class UserMobileService {

    private final UserMobile.Column[] pwdResult = excludes();

    private final UserMobile.Column[] result = excludes(password);

    private final UserMobile.Column[] select = new UserMobile.Column[]{
            id, mobile
    };

    @Resource
    private UserMobileMapper userMobileMapper;

    @Resource
    private UserLinkService userLinkService;

    @Resource
    private UserWxService userWxService;

    private UserMobileExample selectExample(UserMobileVo vo) {
        UserMobileExample example = new UserMobileExample();
        UserMobileExample.Criteria criteria = example.createCriteria();

        if (isNotBlank(vo.getMobile())) {
            criteria.andMobileLike("%" + vo.getMobile() + "%");
        }
        if (vo.getStatus() != null) {
            criteria.andStatusEqualTo(vo.getStatus());
        }

        return example;
    }

    public long countSelect(UserMobileVo vo) {
        return userMobileMapper.countByExample(selectExample(vo));
    }

    public List<UserMobile> findSelectList(UserMobileVo vo) {
        UserMobileExample example = selectExample(vo);
        example.setOrderByClause(vo.getSort() + " " + vo.getOrder());

        PageHelper.startPage(vo.getPage(), vo.getLimit());

        return userMobileMapper.selectByExampleSelective(example, select);
    }

    public List<UserInfoVo> findFullUserInfoList(UserMobileVo vo) {
        List<UserInfoVo> data = Lists.newArrayList();

        List<UserMobile> list = getUserMobiles(vo);

        for (UserMobile userMobile : list) {
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUserMobile(userMobile);
            UserLink userLink = this.userLinkService.findByUid(userMobile.getId());
            if (userLink != null) {
                userInfoVo.setUserWx(this.userWxService.findUserWxByOpenid(userLink.getOpenid()));
            }
            data.add(userInfoVo);
        }
        return data;
    }

    private List<UserMobile> getUserMobiles(UserMobileVo vo) {
        UserMobileExample example = selectExample(vo);
        example.setOrderByClause(vo.getSort() + " " + vo.getOrder());

        Integer page=vo.getPage();
        Integer limit=vo.getLimit();
        PageHelper.startPage(page, limit);
        return userMobileMapper.selectByExample(example);
    }


    private UserMobileExample.Criteria getMobileCriteria(String mobile) {
        UserMobileExample example = new UserMobileExample();
        UserMobileExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        return criteria;
    }

    public UserMobile findById(String id) {
        return userMobileMapper.selectByPrimaryKeySelective(id, result);
    }

    public long countByMobile(String mobile) {
        UserMobileExample.Criteria criteria = getMobileCriteria(mobile);
        return userMobileMapper.countByExample(criteria.example());
    }

    public List<UserMobile> findUserMobile(String mobile) {
        UserMobileExample.Criteria criteria = getMobileCriteria(mobile);
        return userMobileMapper.selectByExampleSelective(criteria.example(), result);
    }

    public UserMobile findValidUserMobile(String mobile) {
        UserMobileExample.Criteria criteria = getMobileCriteria(mobile);
        criteria.andStatusEqualTo(STATUS_VALID.getValue());
        return userMobileMapper.selectOneByExampleSelective(criteria.example(), result);
    }

    public UserMobile findAuthUserMobile(String mobile, Integer status) {
        UserMobileExample.Criteria criteria = getMobileCriteria(mobile);

        if (status != null) {
            criteria.andStatusEqualTo(status);
        }

        return userMobileMapper.selectOneByExampleSelective(criteria.example(), pwdResult);
    }

    public UserMobile findAuthUserByUid(String uid, Integer status) {
        UserMobileExample example = new UserMobileExample();
        UserMobileExample.Criteria criteria = example.createCriteria().andIdEqualTo(uid);

        if (status != null) {
            criteria.andStatusEqualTo(status);
        }

        return userMobileMapper.selectOneByExampleSelective(example, pwdResult);
    }

    public int updateByPrimaryKeySelective(UserMobile userMobile) {
        return userMobileMapper.updateByPrimaryKeySelective(userMobile);
    }

    public int deleteById(String id) {
        UserMobile userMobile = new UserMobile();
        userMobile.setId(id);
        userMobile.setStatus(STATUS_INVALID.getValue());
        return userMobileMapper.updateByPrimaryKeySelective(userMobile);
    }

    public int add(UserMobile userMobile) {
        if (countByMobile(userMobile.getMobile()) > 0) {
            return -1;/* 已存在用户则不插入 */
        }
        userMobile.setAddTime(now());
        return userMobileMapper.insertSelective(userMobile);
    }

}
