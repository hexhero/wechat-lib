package com.yangb.weichatmanager.bean;

import java.util.List;

/**
 * weichatmanager
 * create by YangBin on 2018/11/19
 * Copyright © 2017 YangBin. All rights reserved.
 */
public class WechatMenu {

    /**
     * 普通菜单
     */
    public WechatMenu menu;

    /**
     * 个性化菜单
     */
    public List<ConditionalMenu> conditionalmenu;

    public List<Button> button;

    public Long menuid;

    public void setMenu(WechatMenu menu) {
        this.menu = menu;
    }

    public void setConditionalmenu(List<ConditionalMenu> conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public static class Button{
        public String name = "default";

        public List<Button> sub_button;

        public void setName(String name) {
            this.name = name;
        }

        public void setSub_button(List<Button> sub_button) {
            this.sub_button = sub_button;
        }
    }

    public static class ConditionalMenu{
        public List<Button> button;
        public Matchrule matchrule;
        public Long menuid;

        public void setButton(List<Button> button) {
            this.button = button;
        }

        public void setMatchrule(Matchrule matchrule) {
            this.matchrule = matchrule;
        }

        public void setMenuid(Long menuid) {
            this.menuid = menuid;
        }
    }

    public static class Matchrule{
        public Integer group_id;
        public Integer sex;
        public String country;
        public String city;
        public String client_platform_type;

        public void setGroup_id(Integer group_id) {
            this.group_id = group_id;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setClient_platform_type(String client_platform_type) {
            this.client_platform_type = client_platform_type;
        }
    }


}
