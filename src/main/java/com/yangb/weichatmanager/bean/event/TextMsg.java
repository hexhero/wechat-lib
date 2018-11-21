package com.yangb.weichatmanager.bean.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * weichatmanager
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class TextMsg extends EventMsg {

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    private String Content;
}
