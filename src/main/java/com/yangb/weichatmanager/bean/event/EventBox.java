package com.yangb.weichatmanager.bean.event;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * EventBox 事件盒子
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
@XmlRootElement(name="xml")
public class EventBox extends EventMsg {

    /**
     * 点击菜单拉取消息
     */
    private String Event;

    private String EventKey;

    /**
     * 点击菜单跳转链接时的事件推送
     */
    private String MenuId;

    private MenuLocationEvent.SendLocationInfo SendLocationInfo;

    private MenuPicEvent.SendPicsInfo SendPicsInfo;

    private MenuScancodeEvent.ScanCodeInfo ScanCodeInfo;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public MenuLocationEvent.SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(MenuLocationEvent.SendLocationInfo sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }

    public MenuPicEvent.SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(MenuPicEvent.SendPicsInfo sendPicsInfo) {
        SendPicsInfo = sendPicsInfo;
    }

    public MenuScancodeEvent.ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(MenuScancodeEvent.ScanCodeInfo scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }
}
