package com.yanjianghua.logistics.service;

import com.yanjianghua.logistics.entity.Order;

import java.math.BigDecimal;

import com.yanjianghua.logistics.entity.Order;
import java.math.BigDecimal;
/*
订单计价服务接口
 */
public interface PricingService {
   /*
   根据订单信息计算运费
   @param order (重量，邮寄方式)
   @throws RuntimeException 如果未找到匹配计费规则
    */
    BigDecimal calculatePrice(Order order);
}
