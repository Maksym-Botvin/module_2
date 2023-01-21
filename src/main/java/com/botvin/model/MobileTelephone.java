package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MobileTelephone extends Telephone {

    private DeviceType deviceType;
    private double diagonal;
    private String country;

    public MobileTelephone() {

    }

    public MobileTelephone(final DeviceType deviceType, String series, String model, double diagonal, String screenType, String country, double price) {
        super(series, model, screenType, price);
        this.deviceType = deviceType;
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Model: %s, Series: %s, Diagonal: %f, Screen type: %s, Country: %s, Price: %d"
                , getDeviceType(), getModel(), getSeries(), getDiagonal(), getScreenType(), getCountry(), getPrice());
    }
}
