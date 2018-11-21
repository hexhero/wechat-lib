package com.yangb.weichatmanager.util;

import com.yangb.weichatmanager.bean.event.EventMsg;

/**
 * weichatmanager
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class MsgReplyHelper {

    /**
     * 消息预处理 转换回复人信息
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends EventMsg> T preprocess(T t){
        String toUsername = t.getToUserName();
        t.setToUserName(t.getFromUserName());
        t.setFromUserName(toUsername);
        return t;
    }
}
