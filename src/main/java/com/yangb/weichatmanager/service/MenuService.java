package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.WechatMenu;
import com.yangb.weichatmanager.bean.WechatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * weichatmanager
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
@Service
public class MenuService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WeChatHttpByFeign wechatHttp;

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
}
