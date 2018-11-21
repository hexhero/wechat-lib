package com.yangb.weichatmanager.config;

import com.yangb.weichatmanager.service.WeChatHttpByFeign;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * weichatmanager
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class FeignConfig {

    private String wechatUrl = "https://api.weixin.qq.com";

    public WeChatHttpByFeign weChatHttpByFeign(){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .options(new Request.Options(3000,5000))
                .retryer(new Retryer.Default(5000,5000,3))
                .target(WeChatHttpByFeign.class, this.wechatUrl);

    }
}
