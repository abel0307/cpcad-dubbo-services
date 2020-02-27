package com.futou.cpad.userCenter.businessService;

import com.futou.cpcad.userCenter.db.dao.UserPaymentMapper;
import com.futou.cpcad.userCenter.db.domain.UserPayment;
import com.futou.cpcad.userCenter.db.domain.UserPaymentExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpcad.userCenter.db.domain.UserPayment.Column;
import static com.futou.cpcad.userCenter.db.domain.UserPayment.Column.*;
import static com.futou.cpcad.userCenter.db.domain.UserPayment.NOT_DELETED;

@Transactional
@Service
public class UserPaymentService {

  private final Column[] detail = new Column[] {
      id, uid, payType, payAccount,
      payName, payId,
      addTime, latestTime, deleted
  };

  @Resource
  private UserPaymentMapper paymentMapper;

  public long countByUid(String uid) {
    UserPaymentExample example = new UserPaymentExample();
    example.createCriteria().andUidEqualTo(uid);

    return paymentMapper.countByExample(example);
  }

  public int add(UserPayment payment) {
    if (countByUid(payment.getUid()) > 0) {
      return -1;/* 已存在则不插入 */
    }

    payment.setDeleted(NOT_DELETED);

    return paymentMapper.insertSelective(payment);
  }

  public int deleteById(String id) {
    return paymentMapper.logicalDeleteByPrimaryKey(id);
  }

  public int deleteByUid(String uid) {
    UserPaymentExample example = new UserPaymentExample();
    example.createCriteria().andUidEqualTo(uid);

    return paymentMapper.logicalDeleteByExample(example);
  }

  public int updateById(UserPayment payment) {
    return paymentMapper.updateByPrimaryKeySelective(payment);
  }

  public int updateByUid(UserPayment payment) {
    UserPaymentExample example = new UserPaymentExample();
    example.createCriteria().andUidEqualTo(payment.getUid());

    return paymentMapper.updateByExampleSelective(payment, example);
  }

  public UserPayment findById(String id, Byte deleted) {
    UserPaymentExample example = new UserPaymentExample();
    UserPaymentExample.Criteria criteria = example.createCriteria();
    criteria.andIdEqualTo(id);

    if (deleted != null) {
      criteria.andDeletedEqualTo(deleted);
    }

    return paymentMapper.selectByPrimaryKeySelective(id, detail);
  }

  public UserPayment findByUid(String uid, Byte deleted) {
    UserPaymentExample example = new UserPaymentExample();
    UserPaymentExample.Criteria criteria = example.createCriteria();
    criteria.andUidEqualTo(uid);

    if (deleted != null) {
      criteria.andDeletedEqualTo(deleted);
    }

    return paymentMapper.selectOneByExampleSelective(example, detail);
  }

}
