package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.WechatMenu;
import com.yangb.weichatmanager.bean.WechatResult;
import com.yangb.weichatmanager.management.BeanFactory;

/**
 * 菜单接口
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class MenuService {

    private TokenService tokenService;

    private WeChatHttpByFeign wechatHttp;

    public MenuService(){
        wechatHttp = BeanFactory.getInstance().getWechatHttp();
        tokenService = BeanFactory.getInstance().getService(TokenService.class);
    }

    /**
     * 创建菜单
     * @param menu
     * @return
     */
    public WechatResult create(WechatMenu menu){
        return wechatHttp.createMenu(menu, tokenService.getAccessToke().getAccess_token());
    }

    /**
     * 查询已创建的菜单
     * @return
     */
    public WechatMenu query(){
        return wechatHttp.queryMenu(tokenService.getAccessToke().getAccess_token());
    }

    /**
     * 查询已创建的菜单
     * @return
     */
    public WechatResult delete(){
        return wechatHttp.deleteMenu(tokenService.getAccessToke().getAccess_token());
    }

    /**
     * 创建个性化菜单
     */
    public WechatMenu.ConditionalMenu addConditional(WechatMenu.ConditionalMenu conditional){
        return wechatHttp.addconditional(conditional,tokenService.getAccessToke().getAccess_token());
    }

    /**
     * 删除个性化菜单
     */
    public WechatResult delConditional(String menuid){
        return wechatHttp.delconditional(menuid,tokenService.getAccessToke().getAccess_token());
    }

    /**
     * 测试个性化菜单匹配结果
     */
    WechatMenu.ConditionalMenu trymatchConditional(String user_id){
        return wechatHttp.trymatchConditional(user_id,tokenService.getAccessToke().getAccess_token());
    }
}
