package com.yangb.weichatmanager.bean.event;

/**
 * weichat-lib
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class LocationEvent extends EventMsg {

    private String Latitude;
    private String Longitude;
    private String Precision;

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }
}
