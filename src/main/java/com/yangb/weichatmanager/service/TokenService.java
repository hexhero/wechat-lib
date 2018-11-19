package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.AccessToken;
import com.yangb.weichatmanager.common.WeChatAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TokenService 令牌服务
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */
@Service
public class TokenService {

    private static AccessToken accessToken;

    @Autowired
    private WeChatHttpByFeign wechatHttp;

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
