package com.yangb.weichatmanager.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.yangb.weichatmanager.bean.event.*;

/**
 * weichatmanager
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class XmlResolver {

    private static XStream xStream;

    static {
        xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.ignoreUnknownElements();

        xStream.alias("xml", EventMsg.class);
        xStream.alias("xml", MenuClickEvent.class);
        xStream.alias("xml", MenuLocationEvent.class);
        xStream.alias("xml", MenuPicEvent.class);
        xStream.alias("xml", MenuScancodeEvent.class);
        xStream.alias("xml", TextMsg.class);
        xStream.alias("xml", ImageMsg.class);
        xStream.alias("xml", LocationMsg.class);
        xStream.alias("xml", LinkMsg.class);
        xStream.alias("xml", VideoMsg.class);
        xStream.alias("xml", VoiceMsg.class);
        xStream.alias("SendLocationInfo", MenuLocationEvent.SendLocationInfo.class);
        xStream.alias("PicList",MenuPicEvent.PicItem.class);
        xStream.alias("SendPicsInfo",MenuPicEvent.SendPicsInfo.class);
        xStream.alias("ScanCodeInfo", MenuScancodeEvent.ScanCodeInfo.class);
        xStream.addImplicitCollection(MenuPicEvent.SendPicsInfo.class,"PicList","Item",MenuPicEvent.PicItem.class);
    }


    public <V extends EventMsg> V parseToEventMsg(Class<V> v, String xml) {
        V x = null;
        try {
            x = v.newInstance();
            xStream.fromXML(xml,x);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return x;
    }

    public String toXml(EventMsg event){
        return xStream.toXML(event);
    }


/*    public static void main(String[] args){
        String xml = "<xml><ToUserName><![CDATA[gh_1439a7c6ab05]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oEe5509FEwb1JeZyBUeh2rYgVy9k]]></FromUserName>\n" +
                "<CreateTime>1542769615</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[1]]></Content>\n" +
                "<MsgId>6626145042113824127</MsgId>\n" +
                "</xml>";
        TextMsg event = new XmlResolver().parseToEventMsg(TextMsg.class, xml);

        System.out.println(event);
    }*/
}
