package com.futou.cpad.userCenter.businessService;

import com.futou.cpcad.userCenter.db.dao.UserCompanyMapper;
import com.futou.cpcad.userCenter.db.domain.UserCompany;
import com.futou.cpcad.userCenter.db.domain.UserCompanyExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.userCenter.db.domain.UserCompany.Column;
import static com.futou.cpcad.userCenter.db.domain.UserCompany.Column.*;
import static com.futou.cpcad.userCenter.db.domain.UserCompany.NOT_DELETED;

@Transactional
@Service
public class UserCompanyService {

  private final Column[] detail = new Column[] {
      id, uid, companyName, companyNo,
      province, city, area, pca, addressDetail,
      contactName, contactTel,
      addTime, latestTime, deleted
  };

  @Resource
  private UserCompanyMapper companyMapper;

  public long countByUid(String uid) {
    UserCompanyExample example = new UserCompanyExample();
    example.createCriteria().andUidEqualTo(uid);
    return companyMapper.countByExample(example);
  }

  public int add(UserCompany company) {
    if (countByUid(company.getUid()) > 0) {
      return -1;/* 已存在则不插入  */
    }

    company.setDeleted(NOT_DELETED);

    return companyMapper.insertSelective(company);
  }

  public int deleteById(String id) {
    return companyMapper.logicalDeleteByPrimaryKey(id);
  }

  public int deleteByUid(String uid) {
    UserCompanyExample example = new UserCompanyExample();
    example.createCriteria().andUidEqualTo(uid);

    return companyMapper.logicalDeleteByExample(example);
  }

  public int updateById(UserCompany company) {
    return companyMapper.updateByPrimaryKeySelective(company);
  }

  public int updateByUid(UserCompany company) {
    UserCompanyExample example = new UserCompanyExample();
    UserCompanyExample.Criteria criteria = example.createCriteria();
    criteria.andUidEqualTo(company.getUid());

    return companyMapper.updateByExampleSelective(company, example);
  }

  public UserCompany findById(String id, Byte deleted) {
    UserCompanyExample example = new UserCompanyExample();
    UserCompanyExample.Criteria criteria = example.createCriteria();
    criteria.andIdEqualTo(id);

    if (deleted != null) {
      criteria.andDeletedEqualTo(deleted);
    }

    return companyMapper.selectByPrimaryKeySelective(id, detail);
  }

  public UserCompany findByUid(String uid, Byte deleted) {
    UserCompanyExample example = new UserCompanyExample();
    UserCompanyExample.Criteria criteria = example.createCriteria();
    criteria.andUidEqualTo(uid);

    if (deleted != null) {
      criteria.andDeletedEqualTo(deleted);
    }

    return companyMapper.selectOneByExampleSelective(example, detail);
  }

}
