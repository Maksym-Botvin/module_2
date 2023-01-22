package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Television {

    private String series;
    private int diagonal;
    private String screenType;
    private String country;
    private int price;

    public Television() {

    }

    public Television(String series, int diagonal, String screenType, String country, int price) {
        this.series = series;
        this.diagonal = diagonal;
        this.screenType = screenType;
        this.country = country;
        this.price = price;
    }

    @Override
    public String toString() {
        return "series: " + series + ", diagonal: " + diagonal + ", screenType: " + screenType + ", country: " + country + ", price: " + price;
    }

}