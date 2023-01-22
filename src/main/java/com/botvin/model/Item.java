package com.botvin.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {

    private DeviceType deviceType;
    private Integer price;

    public Item() {

    }

    public Item(DeviceType deviceType, Integer price) {
        this.deviceType = deviceType;
        this.price = price;
    }
}
