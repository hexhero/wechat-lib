package com.yangb.weichatmanager.bean.event;

/**
 * weichatmanager
 * create by YangBin on 2018/11/21
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class LinkMsg extends EventMsg {

    private String Title;
    private String Description;
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
