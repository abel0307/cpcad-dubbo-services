package com.futou.cpad.userCenter.businessService;

import com.futou.cpcad.userCenter.db.dao.UserWxMapper;
import com.futou.cpcad.userCenter.db.domain.UserWx;
import com.futou.cpcad.userCenter.db.domain.UserWxExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.common.utils.id.UuidUtil.getSnowFlakeId;
import static java.time.LocalDateTime.now;

@Transactional
@Service
public class UserWxService {

  private final UserWx.Column[] result = new UserWx.Column[] {
      UserWx.Column.id,
      UserWx.Column.openid,
      UserWx.Column.subscribe,
      UserWx.Column.nickname,
      UserWx.Column.sex,
      UserWx.Column.country,
      UserWx.Column.province,
      UserWx.Column.city,
      UserWx.Column.headImgUrl,
      UserWx.Column.language,
      UserWx.Column.lastTime,
      UserWx.Column.addTime
  };

  @Resource
  private UserWxMapper userWxMapper;

  private UserWxExample.Criteria getCriteria() {
    UserWxExample example = new UserWxExample();
    return example.createCriteria();
  }

  public UserWx findUserWxByOpenid(String openid) {
    UserWxExample.Criteria criteria = getCriteria();
    criteria.andOpenidEqualTo(openid);
    return userWxMapper.selectOneByExampleSelective(criteria.example(), result);
  }

  public int updateByOpenid(UserWx userWx) {
    return userWxMapper.updateByPrimaryKeySelective(userWx);
  }

  public int add(UserWx userWx) {
    if (findUserWxByOpenid(userWx.getOpenid()) != null) {
      return -1;/* 已存在微信用户记录 */
    }
    userWx.setId(getSnowFlakeId());
    userWx.setAddTime(now());
    return userWxMapper.insertSelective(userWx);
  }

}
