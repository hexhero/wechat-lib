package com.yangb.weichatmanager.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * weichatmanager 事件
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */

@XmlRootElement(name="xml")
public class WeChatEvent {

    /**
     * 接收消息路径
     */
    private String URL;

    /**
     * 开发者微信号
     */
    private String ToUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;

    /**
     * 事件创建时间 （整型）
     */
    private String CreateTime;

    /**
     * 事件类型
     */
    private String Event;

}
