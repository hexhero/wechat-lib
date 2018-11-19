package com.yangb.weichatmanager.bean;

import com.yangb.weichatmanager.util.DateUtil;
import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * weichatmanager
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class AccessToken {

    private String access_token;

    private String expires_in;

    private Date validTime;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        validTime = DateUtil.addSecond(new Date(), Integer.parseInt(expires_in));
        this.expires_in = expires_in;
    }

    public boolean isValid(){
        if(new Date().getTime() > validTime.getTime()){
            return false;
        }
        return true;
    }

}
