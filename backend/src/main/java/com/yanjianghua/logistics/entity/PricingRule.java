package com.yanjianghua.logistics.entity;

import com.yanjianghua.logistics.enums.ShippingTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PricingRule {
    private Long ruleId;//主键
    private String ruleName;//规则名称
    //-----------匹配条件
    private ShippingTypeEnum shippingType;
    private String originRegion;//起始地区
    private String destRegion;//目的地
    private BigDecimal minWight;//最低重量
    private BigDecimal maxWight;//最高重量
    //------------------计费参数
    //==============普通寄件
    private BigDecimal firstWeight;//首重
    private BigDecimal firstWeightPrice;//首重价格
    private BigDecimal additionPricePerKg;//续重每公斤单价
    //================包车
    private BigDecimal charterBasePrice;//一口价
    //----------------------有效期与优先级
    private LocalDateTime effectiveDate;//生效日期
    private LocalDateTime expireDate;//失效日期
    private Integer priority;//优先级

    public PricingRule() {
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getOriginRegion() {
        return originRegion;
    }

    public void setOriginRegion(String originRegion) {
        this.originRegion = originRegion;
    }

    public ShippingTypeEnum getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingTypeEnum shippingType) {
        this.shippingType = shippingType;
    }

    public String getDestRegion() {
        return destRegion;
    }

    public void setDestRegion(String destRegion) {
        this.destRegion = destRegion;
    }

    public BigDecimal getMinWight() {
        return minWight;
    }

    public void setMinWight(BigDecimal minWight) {
        this.minWight = minWight;
    }

    public BigDecimal getMaxWight() {
        return maxWight;
    }

    public void setMaxWight(BigDecimal maxWight) {
        this.maxWight = maxWight;
    }

    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getFirstWeightPrice() {
        return firstWeightPrice;
    }

    public void setFirstWeightPrice(BigDecimal firstWeightPrice) {
        this.firstWeightPrice = firstWeightPrice;
    }

    public BigDecimal getAdditionPricePerKg() {
        return additionPricePerKg;
    }

    public void setAdditionPricePerKg(BigDecimal additionPricePerKg) {
        this.additionPricePerKg = additionPricePerKg;
    }

    public BigDecimal getCharterBasePrice() {
        return charterBasePrice;
    }

    public void setCharterBasePrice(BigDecimal charterBasePrice) {
        this.charterBasePrice = charterBasePrice;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
