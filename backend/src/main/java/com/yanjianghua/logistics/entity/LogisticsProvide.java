package com.yanjianghua.logistics.entity;

import java.math.BigDecimal;

public class LogisticsProvide {

    private Long ProvideId;//主键
    private String name;//承运商站点名称
    private String contactPerson;//联系人
    private String phone;//电话
    private String serviceArea;//服务区域
    private String providerType;//运输类型
    private String status;//状态
    private BigDecimal maxLoad;//最大载重
    private Integer rating;//信用分

    public LogisticsProvide() {
    }

    public Long getProvideId() {
        return ProvideId;
    }

    public void setProvideId(Long provideId) {
        ProvideId = provideId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(BigDecimal maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
