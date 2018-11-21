package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.AccessToken;
import com.yangb.weichatmanager.common.WeChatAccount;
import com.yangb.weichatmanager.config.FeignConfig;
import com.yangb.weichatmanager.management.BeanFactory;

/**
 * TokenService 令牌服务
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class TokenService {

    private static AccessToken accessToken;

    private WeChatHttpByFeign wechatHttp;

    public TokenService(){
        wechatHttp = BeanFactory.getInstance().getWechatHttp();
    }

    /**
     * 获取有效的 AccessToken
     * @return
     */
    public AccessToken getAccessToke(){
        if(accessToken == null || !accessToken.isValid()){
            accessToken = wechatHttp.getAccessToken(WeChatAccount.appID, WeChatAccount.appsecret);
        }
        return accessToken;
    }
}
