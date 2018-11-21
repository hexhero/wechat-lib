package com.yangb.weichatmanager.config;

import com.netflix.hystrix.HystrixCommandProperties;
import com.yangb.weichatmanager.service.WeChatHttpByFeign;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * weichatmanager
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class FeignConfig {

    private String wechatUrl = "https://api.weixin.qq.com";

    public WeChatHttpByFeign weChatHttpByFeign(){
        return HystrixFeign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .setterFactory((target, method) ->
                        new SetterFactory.Default().create(target, method).
                                andCommandPropertiesDefaults(HystrixCommandProperties.defaultSetter().
                                        withExecutionTimeoutInMilliseconds(10000)))
                .logLevel(Logger.Level.FULL)
                .logger(new Logger.JavaLogger().appendToFile("D:\\fegin.log"))
                .target(WeChatHttpByFeign.class, this.wechatUrl);

    }
}
