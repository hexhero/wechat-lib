package com.yangb.weichatmanager.management;

import com.yangb.weichatmanager.common.WeChatAccount;

/**
 * 系统初始化
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class WechatInitialize {

    public static void init(String appid, String appsecret){
        WeChatAccount.appID = appid;
        WeChatAccount.appsecret = appsecret;
    }

    public static void registEventHandler(EventHandler handler){
        HandlerHolder.getInstance().registEventHandler(handler);
    }

    public static void registMsgHandler(MsgHandler handler){
        HandlerHolder.getInstance().registMsgHandler(handler);
    }
}
