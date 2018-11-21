package com.yangb.weichatmanager.management;

import com.yangb.weichatmanager.bean.event.*;
import com.yangb.weichatmanager.common.WechatConstant;
import com.yangb.weichatmanager.util.MsgReplyHelper;
import com.yangb.weichatmanager.util.XmlResolver;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 分发管理器
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class DispatcherManagement {

    private XmlResolver xmlParser;

    public DispatcherManagement(){
        xmlParser = BeanFactory.getInstance().getService(XmlResolver.class);
    }

    HandlerHolder holder = HandlerHolder.getInstance();

    /**
     * 处理及响应事件
     * @param xml
     * @return
     */
    public EventMsg dispatch(String xml) {
        if (StringUtils.isEmpty(xml)) {
            throw new IllegalArgumentException("推送信息为空");
        }
        EventMsg event = xmlParser.parseToEventMsg(EventMsg.class, xml);
        if (event == null || StringUtils.isEmpty(event.getMsgType())) {
            throw new RuntimeException("xml 解析错误");
        }
        switch (event.getMsgType()) {
            case WechatConstant.MSG_TYPE_EVENT:
                if(holder.hasEventHandler()){
                    return dispatchEvent(event, xml);
                }
                return null;
            case WechatConstant.MSG_TYPE_TEXT:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().textMsg(xmlParser.parseToEventMsg(TextMsg.class,xml));
                }
                return defaultReply(event);
            case WechatConstant.MSG_TYPE_IMAGE:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().imageMsg(xmlParser.parseToEventMsg(ImageMsg.class,xml));
                }
                return defaultReply(event);
            case WechatConstant.MSG_TYPE_VOICE:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().voiceMsg(xmlParser.parseToEventMsg(VoiceMsg.class,xml));
                }
                return defaultReply(event);
            case WechatConstant.MSG_TYPE_VIDEO:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().videoMsg(xmlParser.parseToEventMsg(VideoMsg.class,xml));
                }
                return defaultReply(event);
            case WechatConstant.MSG_TYPE_SHORTVIDEO:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().shortvideoMsg(xmlParser.parseToEventMsg(VideoMsg.class,xml));
                }
                return defaultReply(event);
            case WechatConstant.MSG_TYPE_LOCATION:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().locationMsg(xmlParser.parseToEventMsg(LocationMsg.class,xml));
                }
                return defaultReply(event);
            case WechatConstant.MSG_TYPE_LINK:
                if(holder.hasMsgHandler()){
                    return holder.getMsgHandler().videoMsg(xmlParser.parseToEventMsg(VideoMsg.class,xml));
                }
                return defaultReply(event);

            default:
                throw new IllegalArgumentException("不支持的消息类型: " + event.getMsgType());

        }
    }

    /**
     * 事件分发
     * @param event
     * @param xml
     * @return
     */
    public EventMsg dispatchEvent(EventMsg event, String xml){
        if (StringUtils.isEmpty(event.getEvent())) {
            throw new RuntimeException("xml 解析错误");
        }
        holder.getEventHandler();
        switch (event.getEvent()){
            case WechatConstant.EVENT_TYPE_CLICK:
                return holder.getEventHandler().menuClick(xmlParser.parseToEventMsg(MenuClickEvent.class,xml));
            case WechatConstant.EVENT_TYPE_VIEW :
                holder.getEventHandler().menuView(xmlParser.parseToEventMsg(MenuClickEvent.class,xml));
                return null;
            case WechatConstant.EVENT_TYPE_SCANCODE_PUSH:
                return holder.getEventHandler().menuScancodePush(xmlParser.parseToEventMsg(MenuScancodeEvent.class,xml));
            case WechatConstant.EVENT_TYPE_SCANCODE_WAITMSG:
                return holder.getEventHandler().menuScancodeWaitmsg(xmlParser.parseToEventMsg(MenuScancodeEvent.class,xml));
            case WechatConstant.EVENT_TYPE_PIC_PHOTO_OR_ALBUM:
                return holder.getEventHandler().menuPicPhotoOrAlbum(xmlParser.parseToEventMsg(MenuPicEvent.class,xml));
            case WechatConstant.EVENT_TYPE_PIC_SYSPHOTO:
                return holder.getEventHandler().menuPicSysphoto(xmlParser.parseToEventMsg(MenuPicEvent.class,xml));
            case WechatConstant.EVENT_TYPE_PIC_WEIXIN:
                return holder.getEventHandler().menuPicWeixin(xmlParser.parseToEventMsg(MenuPicEvent.class,xml));
            case WechatConstant.EVENT_TYPE_LOCATION_SELECT:
                return holder.getEventHandler().menuLocationSelect(xmlParser.parseToEventMsg(MenuLocationEvent.class,xml));
            case WechatConstant.EVENT_TYPE_SUBSCRIBE:
                return holder.getEventHandler().subscrib(event);
            case WechatConstant.EVENT_TYPE_UNSUBSCRIBE:
                holder.getEventHandler().unsubscrib(event);
                return null;
            case WechatConstant.EVENT_TYPE_LOCATION:
                holder.getEventHandler().location(xmlParser.parseToEventMsg(LocationEvent.class,xml));
                return null;
            default:
                throw new IllegalArgumentException("不支持的事件类型:" + event.getEvent());

        }
    }

    public EventMsg defaultReply(EventMsg eventMsg){
        //TODO 默认回复内容
        EventMsg msg = MsgReplyHelper.preprocess(eventMsg);
        TextMsg textMsg = new TextMsg();
        try {
            BeanUtils.copyProperties(textMsg,msg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        textMsg.setMsgType("text");
        textMsg.setCreateTime(System.currentTimeMillis()+"");
        textMsg.setContent("reply default msg");
        return textMsg;
    }
}
