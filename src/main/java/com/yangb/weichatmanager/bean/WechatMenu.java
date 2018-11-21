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
    private WechatMenu menu;

    /**
     * 个性化菜单
     */
    private List<ConditionalMenu> conditionalmenu;

    private List<Button> button;

    private Long menuid;

    public WechatMenu getMenu() {
        return menu;
    }

    public List<ConditionalMenu> getConditionalmenu() {
        return conditionalmenu;
    }

    public List<Button> getButton() {
        return button;
    }

    public Long getMenuid() {
        return menuid;
    }

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
        private String name = "default";

        private List<Button> sub_button;

        public void setName(String name) {
            this.name = name;
        }

        public void setSub_button(List<Button> sub_button) {
            this.sub_button = sub_button;
        }

        public String getName() {
            return name;
        }

        public List<Button> getSub_button() {
            return sub_button;
        }
    }

    public static class ConditionalMenu extends WechatResult{
        private List<Button> button;
        private Matchrule matchrule;
        private String menuid;

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public void setButton(List<Button> button) {
            this.button = button;
        }

        public void setMatchrule(Matchrule matchrule) {
            this.matchrule = matchrule;
        }

        public List<Button> getButton() {
            return button;
        }

        public Matchrule getMatchrule() {
            return matchrule;
        }

        public String getMenuid() {
            return menuid;
        }
    }

    public static class Matchrule{
        private Integer group_id;
        private Integer sex;
        private String country;
        private String province;
        private String city;
        private String client_platform_type;
        private String tag_id;

        public Integer getGroup_id() {
            return group_id;
        }

        public Integer getSex() {
            return sex;
        }

        public String getCountry() {
            return country;
        }

        public String getProvince() {
            return province;
        }

        public String getCity() {
            return city;
        }

        public String getClient_platform_type() {
            return client_platform_type;
        }

        public String getTag_id() {
            return tag_id;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

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
