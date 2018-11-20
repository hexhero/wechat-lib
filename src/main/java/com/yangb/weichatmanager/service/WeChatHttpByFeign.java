package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.AccessToken;
import com.yangb.weichatmanager.bean.WechatMenu;
import com.yangb.weichatmanager.bean.WechatResult;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * weichatmanager
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
@Headers("Content-Type: application/json")
public interface WeChatHttpByFeign {

    /**
     * 获取AccessToken
     * @param aapid
     * @param secret
     * @return
     */
    @RequestLine("GET /cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}")
    AccessToken getAccessToken(@Param("appid") String aapid, @Param("secret") String secret);

    /**
     * 创建菜单
     * @param menu
     * @param access_token
     * @return
     */
    @RequestLine("POST /cgi-bin/menu/create?access_token={access_token}")
    WechatResult createMenu(WechatMenu menu, @Param("access_token") String access_token);

    /**
     * 查询菜单
     * @param access_token
     * @return
     */
    @RequestLine("GET /cgi-bin/menu/get?access_token={access_token}")
    WechatMenu queryMenu(@Param("access_token") String access_token);

    /**
     * 删除菜单
     * @param access_token
     * @return
     */
    @RequestLine("GET /cgi-bin/menu/delete?access_token={access_token}")
    WechatResult deleteMenu(@Param("access_token") String access_token);

    /**
     * 添加个性化菜单
     * @return
     */
    @RequestLine("POST /cgi-bin/menu/addconditional?access_token={access_token}")
    WechatMenu.ConditionalMenu addconditional(WechatMenu.ConditionalMenu conditionalMenu,@Param("access_token") String access_token);

    /**
     * 删除个性化菜单
     * @param menuid
     * @param access_token
     * @return
     */
    @RequestLine("POST /cgi-bin/menu/delconditional?access_token={access_token}")
    @Body("%7B\"menuid\":\"{menuid}\"%7D")
    WechatResult delconditional(@Param("menuid") String menuid,@Param("access_token") String access_token);

    /**
     * 测试个性化菜单匹配结果
     * @param user_id
     * @param access_token
     * @return
     */
    @RequestLine("POST /cgi-bin/menu/trymatch?access_token={access_token}")
    @Body("%7B\"user_id\":\"{user_id}\"%7D")
    WechatMenu.ConditionalMenu trymatchConditional(@Param("user_id") String user_id, @Param("access_token") String access_token);
}
