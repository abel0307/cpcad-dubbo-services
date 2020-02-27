package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpad.userCenter.businessService.UserCompanyService;
import com.futou.cpad.userCenter.businessService.UserPaymentService;
import com.futou.cpcad.core.util.ResponseData;
import com.futou.cpcad.userCenter.db.domain.UserCompany;
import com.futou.cpcad.userCenter.db.domain.UserMobile;
import com.futou.cpcad.userCenter.db.domain.UserPayment;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.futou.cpad.userCenter.constant.CommonConstant.*;
import static com.futou.cpcad.common.utils.id.UuidUtil.getSnowFlakeId;
import static com.futou.cpcad.core.util.ResponseData.*;
import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Transactional
@Service
public class BasicManageService {

  private final Logger logger = getLogger(getClass());

  /* TODO: 账户余额查询服务 */

  /* TODO: 用户积分查询 */

  @Resource
  private UserInfoService userInfoService;

  @Resource
  private UserPaymentService paymentService;

  @Resource
  private UserCompanyService companyService;

  public ResponseData queryBasicInfo(String uid) {
    logger.info("{} uid={}",
        "Query basic info:",
        uid);

    /* TODO: money */
    /* TODO: score */

    /* account */
    ResponseData<UserMobile> session = userInfoService.findMobileByUid(uid);
    if (!session.isOk()) {
      return convert(session);
    }

    /* hidden password */
    session.getData().setPassword(null);

    /* payment */
    UserPayment userPayment = paymentService.findByUid(uid, UserPayment.NOT_DELETED);

    /* company */
    UserCompany userCompany = companyService.findByUid(uid, UserCompany.NOT_DELETED);

    Map<Object, Object> data = new HashMap<>(8);
    data.put(LEFT_MONEY, "0.00");
    data.put(LEFT_SCORE, 0);
    data.put(INFO_BIND, session.getData());
    data.put(INFO_PAYMENT, userPayment == null ? "" : userPayment);
    data.put(INFO_COMPANY, userCompany == null ? "" : userCompany);

    return ok(data);
  }


  public ResponseData savePayment(String uid, UserPayment payment) {
    if (isBlank(payment.getId())) {
      payment.setUid(uid);
      payment.setId(getSnowFlakeId());
      payment.setAddTime(now());
      payment.setLatestTime(payment.getAddTime());

      int addResult = paymentService.add(payment);

      logger.info("{} result={} uid={}",
          "Bind payment info:",
          addResult,
          uid);

      if (addResult == -1) {
        return fail(10000000, "已存在账号信息");
      }

      if (addResult == 0) {
        return fail(10000001, "添加失败，请稍后再试");
      }
    } else {
      payment.setLatestTime(now());
      int updateResult = paymentService.updateById(payment);

      if (updateResult == 0) {
        return fail(10000002, "保存失败，请稍后再试");
      }
    }

    return ok(payment);
  }

  public ResponseData saveCompany(String uid, UserCompany company) {
    if (isBlank(company.getId())) {
      company.setId(getSnowFlakeId());
      company.setUid(uid);
      company.setAddTime(now());
      company.setLatestTime(company.getAddTime());

      int addResult = companyService.add(company);

      logger.info("{} result={} uid={}",
          "Bind company info:",
          addResult,
          uid);

      if (addResult == -1) {
        return fail(10000000, "已存在公司信息");
      }

      if (addResult == 0) {
        return fail(10000001, "绑定公司信息失败，请稍后再试");
      }
    } else {
      company.setLatestTime(now());
      int updateResult = companyService.updateById(company);

      if (updateResult == 0) {
        return fail(10000002, "保存失败，请稍后再试");
      }
    }

    return ok(company);
  }


}
