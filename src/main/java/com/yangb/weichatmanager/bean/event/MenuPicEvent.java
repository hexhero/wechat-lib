package com.yangb.weichatmanager.bean.event;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * 菜单点击发图事件
 * create by YangBin on 2018/11/20
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class MenuPicEvent extends MenuClickEvent {

    public static class SendPicsInfo{
        String Count;
        List<PicItem> PicList;

        public List<PicItem> getPicList() {
            return PicList;
        }

        public void setPicList(List<PicItem> picList) {
            PicList = picList;
        }

        public String getCount() {
            return Count;
        }

        public void setCount(String Count) {
            this.Count = Count;
        }
    }

    public static class PicItem{
        Item item;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }

    public static class Item{

        String PicMd5Sum;

        public String getPicMd5Sum() {
            return PicMd5Sum;
        }

        public void setPicMd5Sum(String picMd5Sum) {
            PicMd5Sum = picMd5Sum;
        }
    }

    private SendPicsInfo SendPicsInfo;

    public MenuPicEvent.SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(MenuPicEvent.SendPicsInfo sendPicsInfo) {
        SendPicsInfo = sendPicsInfo;
    }
}
