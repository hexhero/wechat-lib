package com.yangb.weichatmanager.bean.event;

/**
 * 菜单扫码事件推送
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class MenuScancodeEvent extends MenuClickEvent {

    public static class ScanCodeInfo{
        String ScanType;

        String ScanResult;

        public String getScanType() {
            return ScanType;
        }

        public void setScanType(String scanType) {
            ScanType = scanType;
        }

        public String getScanResult() {
            return ScanResult;
        }

        public void setScanResult(String scanResult) {
            ScanResult = scanResult;
        }
    }

    private ScanCodeInfo ScanCodeInfo;

    public MenuScancodeEvent.ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(MenuScancodeEvent.ScanCodeInfo scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }
}
