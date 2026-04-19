package com.yanjianghua.logistics.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.yanjianghua.logistics.enums.ShippingTypeEnum;

public class Order {
    private Long id;
    private  String orderNo;//订单号
    //------------寄件人信息-----------
    private String senderName;//寄件人姓名
    private String senderPhone;//寄件人电话
    private String senderAddress;//寄件人地址
    //-------------收件人信息
    private String receiveName;//收货人姓名
    private String receivePhone;//收货人电话
    private String receiveAddress;//收货地址
    //-------------货物信息与计费
    private boolean insured;//是否保价
    private BigDecimal weight;//货物重量
    private BigDecimal volume;//货物体积
    private ShippingTypeEnum shippingType;//寄件方式
    private BigDecimal insuredValue;//保价金额
    private BigDecimal finalPrice;//最终邮费
    //-------------------时间与状态
    private String status;//货物状态
    private LocalDateTime createdTime;//订单创建时间
    //========================
    private Long providerId;//承运商

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public ShippingTypeEnum getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingTypeEnum shippingType) {
        this.shippingType = shippingType;
    }

    public BigDecimal getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(BigDecimal insuredValue) {
        this.insuredValue = insuredValue;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

}
