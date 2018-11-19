package com.yangb.weichatmanager.bean;

/**
 * weichatmanager 微信验证信息
 * create by YangBin on 2018/11/16
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class VerifyServer {

    private String signature;

    private String timestamp;

    private String nonce;

    private String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
