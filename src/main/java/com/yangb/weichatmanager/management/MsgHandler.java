package com.yangb.weichatmanager.management;

import com.yangb.weichatmanager.bean.event.*;

/**
 * weichatmanager
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public interface MsgHandler {

    /**
     * 文本消息
     * @param msg
     * @return
     */
    EventMsg textMsg(TextMsg msg);

    /**
     * 图片消息
     * @param msg
     * @return
     */
    EventMsg imageMsg(ImageMsg msg);

    /**
     * 语音消息
     * @param msg
     * @return
     */
    EventMsg voiceMsg(VoiceMsg msg);

    /**
     * 视频消息
     * @param msg
     * @return
     */
    EventMsg videoMsg(VideoMsg msg);

    /**
     * 小视频消息
     * @param msg
     * @return
     */
    EventMsg shortvideoMsg(VideoMsg msg);

    /**
     * 地理位置消息
     * @param msg
     * @return
     */
    EventMsg locationMsg(LocationMsg msg);

    /**
     * 链接消息
     * @param msg
     * @return
     */
    EventMsg linkMsg(LinkMsg msg);
}
