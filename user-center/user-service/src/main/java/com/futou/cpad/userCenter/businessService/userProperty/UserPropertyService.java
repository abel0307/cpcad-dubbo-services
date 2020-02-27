package com.futou.cpad.userCenter.businessService.userProperty;

import com.futou.cpad.userCenter.businessService.userProperty.constant.TradeBusinessTypeEnum;
import com.futou.cpad.userCenter.businessService.vo.DealBusiness;
import com.futou.cpcad.core.exception.BusinessException;
import com.futou.cpcad.core.exception.BusinessExceptionEnum;
import com.futou.cpcad.userCenter.db.dao.UserPropertyMapper;
import com.futou.cpcad.userCenter.db.domain.BillLog;
import com.futou.cpcad.userCenter.db.domain.UserProperty;
import com.futou.cpcad.userCenter.db.domain.UserPropertyExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class UserPropertyService {

    @Resource
    private UserPropertyMapper userPropertyMapper;

    @Autowired
    private BillLogService billLogService;

    public UserProperty selectByPrimaryKey(String id) {
        return this.userPropertyMapper.selectByPrimaryKey(id);
    }

    public UserProperty queryByUserId(String userId) {
        UserPropertyExample userPropertyExample = new UserPropertyExample();
        UserPropertyExample.Criteria criteria = userPropertyExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return this.userPropertyMapper.selectOneByExample(userPropertyExample);
    }


    public int add(UserProperty userProperty) {
        userProperty.setAddTime(LocalDateTime.now());
        return this.userPropertyMapper.insertSelective(userProperty);
    }

    public int updateByPrimaryKeySelective(UserProperty userProperty) {
        return this.userPropertyMapper.updateByPrimaryKeySelective(userProperty);
    }

    public int updateByUserId(UserProperty userProperty) {
        String userId = userProperty.getUserId();
        Integer version = userProperty.getVersion();
        if (StringUtils.isNotBlank(userId) && version != null) {
            UserPropertyExample userPropertyExample = new UserPropertyExample();
            UserPropertyExample.Criteria criteria = userPropertyExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andVersionLessThan(version + 1);
            userProperty.setVersion(version + 1);
            return this.userPropertyMapper.updateByExampleSelective(userProperty, userPropertyExample);
        }
        return -1;
    }


    public List<UserProperty> list() {
        UserPropertyExample userPropertyExample = new UserPropertyExample();
        return this.userPropertyMapper.selectByExample(userPropertyExample);
    }


    public int deal(DealBusiness dealBusiness) {
        TradeBusinessTypeEnum tradeBusinessTypeEnum=dealBusiness.getTradeBusinessTypeEnum();

        String userId=dealBusiness.getUserId();

        BigDecimal transactionAmount=dealBusiness.getTransactionAmount();

        String activityId=dealBusiness.getActivityId();

        String withdrawApplicatonId=dealBusiness.getWithdrawApplicatonId();

        String orderId=dealBusiness.getOrderId();

        String businessId=dealBusiness.getBusinessId();

        BigDecimal serviceCharge=dealBusiness.getServiceCharge();

        int propertyResult = -1;

        //封装账单记录
        BillLog billLog = new BillLog();
        billLog.setTransactionAmount(transactionAmount);
        billLog.setUserId(userId);
        billLog.setActivityId(activityId);
        billLog.setBusinessId(businessId);
        billLog.setOrderId(orderId);
        billLog.setWithdrawApplicationId(withdrawApplicatonId);
        billLog.setBusinessType(tradeBusinessTypeEnum.getCode());
        billLog.setTransactionType(tradeBusinessTypeEnum.getTransactionTypeEnum().getCode());

        //查询用户的余额
        UserProperty userProperty = this.queryByUserId(userId);
        if (TradeBusinessTypeEnum.CHARGE.compareTo(tradeBusinessTypeEnum) == 0) {
            userProperty.setAvailableBalance(userProperty.getAvailableBalance().add(transactionAmount));

            //插入账单记录
            billLog.setTransactionDesc(tradeBusinessTypeEnum.getTransactionDesc());
        } else if (TradeBusinessTypeEnum.CREATE_ACTIVITY.compareTo(tradeBusinessTypeEnum) == 0 ||
                TradeBusinessTypeEnum.WITHDRAW_APPLICATION.compareTo(tradeBusinessTypeEnum) == 0  || TradeBusinessTypeEnum.UPDATE_ACTIVITY_ADD.compareTo(tradeBusinessTypeEnum) == 0) {
            if (userProperty.getAvailableBalance().compareTo(transactionAmount) >= 0) {
                userProperty.setAvailableBalance(userProperty.getAvailableBalance().subtract(transactionAmount));
                userProperty.setFreezeBalance(userProperty.getFreezeBalance().add(transactionAmount));

                //插入账单记录
                if (TradeBusinessTypeEnum.CREATE_ACTIVITY.compareTo(tradeBusinessTypeEnum) == 0 || TradeBusinessTypeEnum.UPDATE_ACTIVITY_ADD.compareTo(tradeBusinessTypeEnum) == 0) {
                    billLog.setTransactionDesc(String.format(tradeBusinessTypeEnum.getTransactionDesc(), activityId));
                } else if (TradeBusinessTypeEnum.WITHDRAW_APPLICATION.compareTo(tradeBusinessTypeEnum) == 0) {
                    billLog.setTransactionDesc(String.format(tradeBusinessTypeEnum.getTransactionDesc(), withdrawApplicatonId,serviceCharge!=null ?
                            serviceCharge.toString():"0"));
                }
            } else {
                throw new BusinessException(BusinessExceptionEnum.INSUFFICIENT_BALANCE);
            }
        } else if (TradeBusinessTypeEnum.ADOWNER_ORDER_SETTLEMENT.compareTo(tradeBusinessTypeEnum) == 0) {
            if (userProperty.getFreezeBalance().compareTo(transactionAmount) <= 0) {
                userProperty.setFreezeBalance(userProperty.getFreezeBalance().subtract(transactionAmount));
                billLog.setTransactionDesc(String.format(tradeBusinessTypeEnum.getTransactionDesc(), activityId, orderId));
            } else {
                throw new BusinessException("媒体主完成订单，扣减广告主的预算失败");
            }
        } else if (TradeBusinessTypeEnum.MEDIA_ORDER_SETTLEMENT.compareTo(tradeBusinessTypeEnum) == 0) {
            userProperty.setAvailableBalance(userProperty.getAvailableBalance().add(transactionAmount));
            billLog.setTransactionDesc(String.format(tradeBusinessTypeEnum.getTransactionDesc(), activityId, orderId));
        } else if (TradeBusinessTypeEnum.ACTIVITY_OVER.compareTo(tradeBusinessTypeEnum) == 0 || TradeBusinessTypeEnum.UPDATE_ACTIVITY_REDUCE.compareTo(tradeBusinessTypeEnum) == 0 ) {
            if (userProperty.getFreezeBalance().compareTo(transactionAmount)<=0) {
                userProperty.setFreezeBalance(userProperty.getFreezeBalance().subtract(transactionAmount));
                userProperty.setAvailableBalance(userProperty.getAvailableBalance().add(transactionAmount));
                billLog.setTransactionDesc(String.format(tradeBusinessTypeEnum.getTransactionDesc(), activityId));
            } else {
                throw new BusinessException("推广活动结束时，解冻金额异常，请联系客服");
            }
        } else if (TradeBusinessTypeEnum.WITHDRAW_FINSISH.compareTo(tradeBusinessTypeEnum) == 0) {
            if (userProperty.getFreezeBalance().compareTo(transactionAmount)<=0) {
                userProperty.setFreezeBalance(userProperty.getFreezeBalance().subtract(transactionAmount));

                billLog.setTransactionDesc(String.format(tradeBusinessTypeEnum.getTransactionDesc(), withdrawApplicatonId,serviceCharge!=null ?
                        serviceCharge.toString():"0"));
            } else {
                throw new BusinessException("提现失败，提现金额异常，请联系客服");
            }
        }

        propertyResult = this.updateByUserId(userProperty);
        if (propertyResult > 0) {
            billLog.setAvailableBalance(userProperty.getAvailableBalance());
            billLog.setFreezeBalance(userProperty.getFreezeBalance());
            return this.billLogService.add(billLog);
        }

        return -1;
    }


}
