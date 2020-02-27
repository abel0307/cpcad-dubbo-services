package com.futou.cpad.userCenter.businessService;

import com.futou.cpcad.userCenter.db.dao.UserLinkMapper;
import com.futou.cpcad.userCenter.db.domain.UserLink;
import com.futou.cpcad.userCenter.db.domain.UserLinkExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.common.utils.id.UuidUtil.getSnowFlakeId;

@Transactional
@Service
public class UserLinkService {

  private final UserLink.Column[] result = new UserLink.Column[] {
      UserLink.Column.id,
      UserLink.Column.uid,
      UserLink.Column.openid
  };

  @Resource
  private UserLinkMapper userLinkMapper;

  public UserLink findByUid(String uid) {
    UserLinkExample example = new UserLinkExample();
    example.createCriteria().andUidEqualTo(uid);
    return userLinkMapper.selectOneByExampleSelective(example, result);
  }


  public UserLink findByOpenid(String openid) {
    UserLinkExample example = new UserLinkExample();
    example.createCriteria().andOpenidEqualTo(openid);
    return userLinkMapper.selectOneByExampleSelective(example, result);
  }

  public int deleteByUid(String uid) {
    UserLinkExample example = new UserLinkExample();
    example.createCriteria().andUidEqualTo(uid);
    return userLinkMapper.deleteByExample(example);
  }

  public int deleteByOpenid(String openid) {
    UserLinkExample example = new UserLinkExample();
    example.createCriteria().andOpenidEqualTo(openid);
    return userLinkMapper.deleteByExample(example);
  }

  public int add(UserLink userLink) {
    if (findByUid(userLink.getUid()) != null) {
      return -1;/* 存在一条绑定记录 */
    }
    userLink.setId(getSnowFlakeId());
    return userLinkMapper.insertSelective(userLink);
  }

}
