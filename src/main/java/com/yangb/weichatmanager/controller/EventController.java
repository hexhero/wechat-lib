package com.yangb.weichatmanager.controller;

import com.yangb.weichatmanager.bean.VerifyServer;
import com.yangb.weichatmanager.bean.WeChatEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * weichatmanager
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/wechatmanager/event")
public class EventController {

    /**
     * 消息/事件接收与响应
     * @param value
     * @return
     */
    @PostMapping
    public WeChatEvent msgEvent(WeChatEvent value){

        return null;
    }

    /**
     * 微信服务器接入
     * @param server
     * @return
     */
    @GetMapping
    public String serverEvent(VerifyServer server){
        //TODO 确认此次GET请求来自微信服务器
        return server.getEchostr();
    }
}
