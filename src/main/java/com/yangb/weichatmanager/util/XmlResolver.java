package com.yangb.weichatmanager.util;

import com.thoughtworks.xstream.XStream;
import com.yangb.weichatmanager.bean.event.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * weichatmanager
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
@Component
public class XmlResolver {

    XStream xStream;
    {
        xStream = new XStream();
        xStream.alias("xml",EventMsg.class);
        xStream.alias("xml", MenuClickEvent.class);
        xStream.alias("xml", MenuLocationEvent.class);
        xStream.alias("xml", MenuPicEvent.class);
        xStream.alias("xml", MenuScancodeEvent.class);
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

 /*   public static void main(String[] args){
        String xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>\n" +
                "<CreateTime>1408090651</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[pic_sysphoto]]></Event>\n" +
                "<EventKey><![CDATA[6]]></EventKey>\n" +
                "<SendPicsInfo><Count>1</Count>\n" +
                "<PicList><item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum>\n" +
                "</item>\n" +
                "</PicList>\n" +
                "</SendPicsInfo>\n" +
                "</xml>";
        MenuPicEvent event = new XmlUtils().parseToEventMsg(MenuPicEvent.class, xml);

        System.out.println(event);
    }*/
}
