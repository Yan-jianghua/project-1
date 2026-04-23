package com.yanjianghua.logistics.service.impl;

import com.yanjianghua.logistics.entity.Order;
import com.yanjianghua.logistics.entity.PricingRule;
import com.yanjianghua.logistics.enums.ShippingTypeEnum;
import com.yanjianghua.logistics.service.PricingService;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PricingServiceImpl implements com.yanjianghua.logistics.service.PricingService {
    private final List<PricingRule> pricingRules = new ArrayList<>();

    public PricingServiceImpl() {
        initRules();
    }

    private void initRules() {
        PricingRule rule1 = new PricingRule();
        rule1.setRuleId(1L);
        rule1.setRuleName("顺丰快递-轻");
        rule1.setShippingType(ShippingTypeEnum.STANDARD);
        rule1.setMinWight(new BigDecimal("0"));
        rule1.setMaxWight(new BigDecimal("10"));
        rule1.setFirstWeight(new BigDecimal("1"));
        rule1.setFirstWeightPrice(new BigDecimal("12"));
        rule1.setAdditionPricePerKg(new BigDecimal("1"));
        pricingRules.add(rule1);


        PricingRule rule2 = new PricingRule();
        rule2.setRuleId(2L);
        rule2.setRuleName("圆通标准快递-轻件");
        rule2.setShippingType(ShippingTypeEnum.STANDARD);
        rule2.setMinWight(new BigDecimal("0"));
        rule2.setMaxWight(new BigDecimal("10"));
        rule2.setFirstWeight(new BigDecimal("1"));
        rule2.setFirstWeightPrice(new BigDecimal("8"));
        rule2.setAdditionPricePerKg(new BigDecimal("1.5"));
        pricingRules.add(rule2);

        // 规则3：顺丰标准快递，重量10~50kg（演示重件阶梯）
        PricingRule rule3 = new PricingRule();
        rule3.setRuleId(3L);
        rule3.setRuleName("顺丰标准快递-重件");
        rule3.setShippingType(ShippingTypeEnum.STANDARD);
        rule3.setMinWight(new BigDecimal("10"));
        rule3.setMaxWight(new BigDecimal("50"));
        rule3.setFirstWeight(new BigDecimal("1"));
        rule3.setFirstWeightPrice(new BigDecimal("12"));
        rule3.setAdditionPricePerKg(new BigDecimal("1.8"));
        pricingRules.add(rule3);
    }

    @Override
    public BigDecimal calculatePrice(Order order) {
        ShippingTypeEnum type = order.getShippingType();
        BigDecimal weight = order.getWeight();

        List<PricingRule> typeMatched = new ArrayList<>();
        for(PricingRule rule : pricingRules){
            if(rule.getShippingType()== type){
                typeMatched.add(rule);
            }
        }
        if (typeMatched.isEmpty()){
            throw new RuntimeException("未找到邮寄方式为 " + type.getDescription() + " 的计费规则");
        }

        // 2. 按重量区间匹配规则
        PricingRule matchedRule = null;
        for (PricingRule rule : typeMatched) {
            if (weight.compareTo(rule.getMinWight()) >= 0 &&
                    weight.compareTo(rule.getMaxWight()) <= 0) {
                matchedRule = rule;
                break;
            }
        }

        if (matchedRule == null) {
            throw new RuntimeException("订单重量 " + weight + "kg 超出所有规则范围");
        }

        // 3. 根据邮寄方式调用对应计算逻辑（目前仅实现STANDARD）
        if (type == ShippingTypeEnum.STANDARD) {
            return computeStandardPrice(weight, matchedRule);
        } else {
            throw new RuntimeException("暂不支持邮寄方式：" + type.getDescription());
        }
    }

    /**
     * 普通快递阶梯计价公式
     */
    private BigDecimal computeStandardPrice(BigDecimal weight, PricingRule rule) {
        BigDecimal firstWeight = rule.getFirstWeight();
        BigDecimal firstPrice = rule.getFirstWeightPrice();
        BigDecimal additionalPrice = rule.getAdditionPricePerKg();

        if (weight.compareTo(firstWeight) <= 0) {
            return firstPrice;
        }

        BigDecimal extraWeight = weight.subtract(firstWeight);
        // 不足1kg按1kg算
        BigDecimal chargedWeight = extraWeight.setScale(0, RoundingMode.UP);
        BigDecimal extraCost = chargedWeight.multiply(additionalPrice);

        return firstPrice.add(extraCost);
        }
}
