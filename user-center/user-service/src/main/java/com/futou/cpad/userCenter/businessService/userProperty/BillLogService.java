package com.futou.cpad.userCenter.businessService.userProperty;

import com.futou.cpad.userCenter.businessService.userProperty.constant.TradeBusinessTypeEnum;
import com.futou.cpad.userCenter.businessService.userProperty.constant.TransactionTypeEnum;
import com.futou.cpad.userCenter.businessService.vo.EnumValues;
import com.futou.cpad.userCenter.businessService.vo.QueryBillLogVo;
import com.futou.cpcad.common.utils.id.UuidUtil;
import com.futou.cpcad.core.util.ResponseData;
import com.futou.cpcad.userCenter.db.dao.BillLogMapper;
import com.futou.cpcad.userCenter.db.domain.BillLog;
import com.futou.cpcad.userCenter.db.domain.BillLogExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BillLogService {

    @Autowired
    private BillLogMapper billLogMapper;

    public int add(BillLog billLog){
        billLog.setId(UuidUtil.getSnowFlakeId());
        billLog.setAddTime(LocalDateTime.now());
        return this.billLogMapper.insertSelective(billLog);
    }

    public ResponseData list(QueryBillLogVo queryBillLogVo){
        BillLogExample billLogExample=new BillLogExample();
        BillLogExample.Criteria criteria=billLogExample.createCriteria();
        Byte transactionType=queryBillLogVo.getTransactionType();

        criteria.andUserIdEqualTo(queryBillLogVo.getUid());

        if(transactionType!=null){
            criteria.andTransactionTypeEqualTo(transactionType);
        }

        Integer page = queryBillLogVo.getPage();
        Integer size = queryBillLogVo.getLimit();
        PageHelper.startPage(page, size);

        String sort = queryBillLogVo.getSort();
        String order = queryBillLogVo.getOrder();
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            billLogExample.setOrderByClause(sort + " " + order);
        }

        List<BillLog> list=this.billLogMapper.selectByExample(billLogExample);

        long total = PageInfo.of(list).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", list);

        return ResponseData.ok(data);

    }


    public ResponseData queryTradeBusinessTypeEnum(){
        List<EnumValues> list= Lists.newArrayList();

        for(TradeBusinessTypeEnum tradeBusinessTypeEnum:TradeBusinessTypeEnum.values()){
            EnumValues enumValues=new EnumValues();
            enumValues.setCode((short) tradeBusinessTypeEnum.getCode());
            enumValues.setDesc(tradeBusinessTypeEnum.getName());
            list.add(enumValues);
        }

        return ResponseData.ok(list);
    }



    public ResponseData queryTransactionTypeEnum(){
        List<EnumValues> list= Lists.newArrayList();
        for(TransactionTypeEnum transactionTypeEnum:TransactionTypeEnum.values()){
            EnumValues enumValues=new EnumValues();
            enumValues.setCode((short) transactionTypeEnum.getCode());
            enumValues.setDesc(transactionTypeEnum.getName());
            list.add(enumValues);
        }
        return ResponseData.ok(list);
    }

    public ResponseData queryAdminStatis(){
        //今日新增资金



        //平台总资金


        return ResponseData.ok();
    }





}
