package com.yangb.weichatmanager.controller;

import com.yangb.weichatmanager.bean.VerifyServer;
import com.yangb.weichatmanager.bean.event.EventMsg;
import com.yangb.weichatmanager.management.DispatcherManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * weichatmanager
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/wechatmanager/access")
public class EventController {

    @Autowired
    private DispatcherManagement dispatcher;

    /**
     * 消息/事件分发与响应
     * @param content
     * @return
     */
    @PostMapping(headers = {"Content-Type=text/xml","Content-Type=application/xml"})
    public EventMsg msgEvent(@RequestBody String content){
        return dispatcher.dispatch(content);
    }

    /**
     * 微信服务器接入响应事件
     * @param server
     * @return
     */
    @GetMapping
    public String serverEvent(VerifyServer server){
        //TODO 确认此次GET请求来自微信服务器
        return server.getEchostr();
    }
}
