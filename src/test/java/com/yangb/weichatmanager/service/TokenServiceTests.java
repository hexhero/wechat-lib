package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.AccessToken;
import com.yangb.weichatmanager.common.WeChatAccount;
import com.yangb.weichatmanager.management.BeanFactory;
import org.junit.Test;
public class TokenServiceTests {

    TokenService tokenService  = new TokenService();

    WeChatHttpByFeign transfer = BeanFactory.getInstance().getWechatHttp();
    /**
     * 获取 AccessToken
     */
    @Test
    public void testGetAccessToken() {
        AccessToken accessToken = tokenService.getAccessToke();
        System.out.println(accessToken.getAccess_token());
    }

    @Test
    public void testGetAccessTokenUseFeign() {
        AccessToken accessToken = transfer.getAccessToken(WeChatAccount.appID, WeChatAccount.appsecret);
        System.out.println(accessToken.getAccess_token());
    }

}
