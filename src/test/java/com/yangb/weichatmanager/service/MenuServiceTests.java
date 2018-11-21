package com.yangb.weichatmanager.service;

import com.yangb.weichatmanager.bean.WechatMenu;
import com.yangb.weichatmanager.bean.WechatResult;
import feign.jackson.JacksonDecoder;
import org.junit.Test;

import java.util.ArrayList;

public class MenuServiceTests {

    MenuService menuService = new MenuService();

    /**
     * 测试添加菜单
     */
    @Test
    public void testCreateMenu() {
        WechatMenu menu = new WechatMenu();
        menu.setButton(new ArrayList<>());
        menu.getButton().add(new WechatMenu.Button(){
            {
                setName("misyang");
            }
            public String type = "click";
            public String key = "V100123";
        });
        menu.getButton().add(new WechatMenu.Button(){
            {
                setName("个");

                setSub_button(new ArrayList<>());
                getSub_button().add(new WechatMenu.Button(){
                    {
                        setName("性");
                    }
                    public String type = "click";
                    public String key = "V100124";
                });
                getSub_button().add(new WechatMenu.Button(){
                    {
                        setName("化");
                    }
                    public String type = "click";
                    public String key = "V100125";
                });
            }
        });


        menuService.create(menu);
    }

    /**
     * 查询菜单
     */
    @Test
    public void testQueryMenu(){
        WechatMenu wechatMenu = menuService.query();
    }

    /**
     * 添加个性化菜单
     */
    @Test
    public void testAddconditional(){
        WechatMenu.ConditionalMenu menu = new WechatMenu.ConditionalMenu();
        menu.setButton(new ArrayList<>());
        menu.getButton().add(new WechatMenu.Button(){
            {
                setName("misyang");
            }
            public String type = "click";
            public String key = "V100123";
        });
        menu.getButton().add(new WechatMenu.Button(){
            {
                setName("个");

                setSub_button(new ArrayList<>());
                getSub_button().add(new WechatMenu.Button(){
                    {
                        setName("性");
                    }
                    public String type = "click";
                    public String key = "V100124";
                });
                getSub_button().add(new WechatMenu.Button(){
                    {
                        setName("化");
                    }
                    public String type = "click";
                    public String key = "V100125";
                });
            }
        });
        menu.setMatchrule( new WechatMenu.Matchrule(){
            {
                setCountry("中国");
                setProvince("浙江");
                setCity("杭州");
            }
        });
        JacksonDecoder decoder = new JacksonDecoder();
        WechatMenu.ConditionalMenu conditionalMenu = menuService.addConditional(menu);
        System.out.println(conditionalMenu.getMenuid());
    }

    /**
     * 测试删除个性化菜单
     */
    @Test
    public void testDelconditional(){
        WechatResult wechatResult = menuService.delConditional("426321085");
        System.out.println(wechatResult.getErrmsg());
    }
}
