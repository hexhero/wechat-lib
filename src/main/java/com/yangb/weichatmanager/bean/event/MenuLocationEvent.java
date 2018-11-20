package com.yangb.weichatmanager.bean.event;

/**
 * 菜单定位事件
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class MenuLocationEvent extends MenuClickEvent {

    private SendLocationInfo SendLocationInfo;

    public MenuLocationEvent.SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(MenuLocationEvent.SendLocationInfo sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }

    public static class SendLocationInfo{
        String Location_X;
        String Location_Y;
        String Scale;
        String Label;
        String Poiname;

        public String getLocation_X() {
            return Location_X;
        }

        public void setLocation_X(String location_X) {
            Location_X = location_X;
        }

        public String getLocation_Y() {
            return Location_Y;
        }

        public void setLocation_Y(String location_Y) {
            Location_Y = location_Y;
        }

        public String getScale() {
            return Scale;
        }

        public void setScale(String scale) {
            Scale = scale;
        }

        public String getLabel() {
            return Label;
        }

        public void setLabel(String label) {
            Label = label;
        }

        public String getPoiname() {
            return Poiname;
        }

        public void setPoiname(String poiname) {
            Poiname = poiname;
        }
    }
}
