package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.AccessToken;
import com.yangb.weichatmanager.common.WeChatAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceTests {

    @Autowired
    TokenService tokenService;

    @Autowired
    WeChatHttpByFeign transfer;
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
