package com.yanjianghua.logistics.enums;

public enum ShippingTypeEnum {
    STANDARD("普通寄件"),
    CHARTER("包车"),
    RESERVATION("预约寄件");
    private final String description;

    ShippingTypeEnum(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
}
