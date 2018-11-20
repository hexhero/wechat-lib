package com.yangb.weichatmanager.bean.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 菜单点击事件
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class MenuClickEvent extends EventMsg {

    /**
     * 点击菜单拉取消息
     */
    private String Event;

    private String EventKey;

    /**
     * 点击菜单跳转链接时的事件推送
     */
    private String MenuId;

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
}
