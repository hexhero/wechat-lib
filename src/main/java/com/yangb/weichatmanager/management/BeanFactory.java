package com.yangb.weichatmanager.management;

import com.yangb.weichatmanager.config.FeignConfig;
import com.yangb.weichatmanager.service.WeChatHttpByFeign;

import java.util.HashMap;
import java.util.Map;

/**
 * weichatmanager
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class BeanFactory {

    private static BeanFactory beanFactory;

    private static Map<Class<?>, Object> beanMap;

    private BeanFactory(){
        beanMap = new HashMap<>();
    }

    public static BeanFactory getInstance(){
        if(beanFactory == null) {
            synchronized (BeanFactory.class) {
                if (beanFactory == null) {
                    beanFactory = new BeanFactory();
                }
            }
        }
        return beanFactory;
    }

    public <T> T getService(Class<T> c){
        try {
            Object o = beanMap.get(c);
            if(o == null){
                o = c.newInstance();
                beanMap.put(c,o);
            }
            return (T) o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("create service fail -- [wechatmanager]");
    }

    public WeChatHttpByFeign getWechatHttp(){
        Object o = beanMap.get(WeChatHttpByFeign.class);
        if(o == null){
             o = new FeignConfig().weChatHttpByFeign();
            beanMap.put(WeChatHttpByFeign.class, o);
        }
        return (WeChatHttpByFeign) o;
    }
}
