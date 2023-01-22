package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MobileTelephone extends Telephone {

    private DeviceType deviceType;
    private int diagonal;
    private String country;

    public MobileTelephone() {
        setDeviceType(DeviceType.TELEPHONE);
    }

    public MobileTelephone(final DeviceType deviceType, String series, String model, int diagonal, String screenType, String country, int price) {
        super(series, model, screenType, price);
        this.deviceType = deviceType;
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Model: %s, Series: %s, Diagonal: %d, Screen type: %s, Country: %s, Price: %d"
                , getDeviceType(), getModel(), getSeries(), getDiagonal(), getScreenType(), getCountry(), getPrice());
    }
}
