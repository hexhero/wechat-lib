package com.yangb.weichatmanager.management;

import com.yangb.weichatmanager.bean.event.*;

/**
 * 事件处理器
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public interface EventHandler {

    /**
     * 点击菜单拉取消息时的事件推送
     * @param event
     * @return
     */
    EventMsg menuClick(MenuClickEvent event);

    /**
     * 点击菜单跳转链接时的事件推送
     * @param event
     * @return
     */
    EventMsg menuView(MenuClickEvent event);

    /**
     * 扫码推事件的事件推送
     * @param event
     * @return
     */
    EventMsg menuScancodePush(MenuScancodeEvent event);

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     * @param event
     * @return
     */
    EventMsg menuScancodeWaitmsg(MenuScancodeEvent event);

    /**
     * 弹出系统拍照发图的事件推送
     * @param event
     * @return
     */
    EventMsg menuPicPhotoOrAlbum(MenuPicEvent event);

    /**
     * 弹出拍照或者相册发图的事件推送
     * @param event
     * @return
     */
    EventMsg menuPicSysphoto(MenuPicEvent event);

    /**
     * 弹出微信相册发图器的事件推送
     * @param event
     * @return
     */
    EventMsg menuPicWeixin(MenuPicEvent event);

    /**
     * 弹出地理位置选择器的事件推送
     * @param event
     * @return
     */
    EventMsg menuLocationSelect(MenuLocationEvent event);

}
