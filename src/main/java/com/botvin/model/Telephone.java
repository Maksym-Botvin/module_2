package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Telephone {

    private String series;
    private String model;
    private String screenType;
    private int price;

    public Telephone() {

    }

    public Telephone(String series, String model, String screenType, int price) {
        this.series = series;
        this.model = model;
        this.screenType = screenType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "series: " + series + ", model: " + model + ", screenType: " + screenType + ", price: " + price;
    }
}