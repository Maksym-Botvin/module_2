package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmartTelevision extends Television {

    private DeviceType deviceType;
    private String model;

    public SmartTelevision() {
        setDeviceType(DeviceType.TELEVISION);
    }

    public SmartTelevision(final DeviceType deviceType, String series, String model, int diagonal, String screenType, String country, int price) {
        super(series, diagonal, screenType, country, price);
        this.deviceType = deviceType;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Model: %s, Series: %s, Diagonal: %d, Screen type: %s, Country: %s, Price: %d"
                , getDeviceType(), getModel(), getSeries(), getDiagonal(), getScreenType(), getCountry(), getPrice());
    }

}
