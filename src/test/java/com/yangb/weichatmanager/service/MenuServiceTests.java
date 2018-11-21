package com.yangb.weichatmanager.service;

import com.alibaba.fastjson.JSON;
import com.yangb.weichatmanager.bean.WechatMenu;
import com.yangb.weichatmanager.bean.WechatResult;
import org.junit.Test;

import java.util.ArrayList;

public class MenuServiceTests {

    MenuService menuService;

    /**
     * 测试添加菜单
     */
    @Test
    public void testCreateMenu() {
        WechatMenu wechaMenu = new WechatMenu();

        wechaMenu.button = new ArrayList<>();

        wechaMenu.button.add(new WechatMenu.Button(){
            {
                name = "杨斌测试";
            }
            public String type = "click";
            public String key = "V1001_TODAY_MUSIC";
        });

        wechaMenu.button.add(new WechatMenu.Button(){

            {
                name = "菜单";
                sub_button = new ArrayList<>();
                sub_button.add(new WechatMenu.Button(){
                    {
                        name = "搜索";
                    }
                    public String type = "view";
                    public String url = "http://www.soso.com/";
                });
                sub_button.add(new WechatMenu.Button(){
                    {
                        name = "赞一下我们";
                    }
                    public String type = "click";
                    public String key = "V1001_GOOD";
                });

            }

        });

        String json = JSON.toJSONString(wechaMenu);
        System.out.println(json);

        menuService.create(wechaMenu);
    }

    /**
     * 查询菜单
     */
    @Test
    public void testQueryMenu(){
        WechatMenu wechatMenu = menuService.query();
        System.out.println(JSON.toJSONString(wechatMenu));
    }

    /**
     * 添加个性化菜单
     */
    @Test
    public void testAddconditional(){
        WechatMenu.ConditionalMenu menu = new WechatMenu.ConditionalMenu();
        menu.button = new ArrayList<>();
        menu.button.add(new WechatMenu.Button(){
            {
                name = "个性化";
            }
            public String type = "click";
            public String key = "V100123";
        });
        menu.button.add(new WechatMenu.Button(){
            {
                name = "个";

                sub_button = new ArrayList<>();
                sub_button.add(new WechatMenu.Button(){
                    {
                        name = "性";
                    }
                    public String type = "click";
                    public String key = "V100124";
                });
                sub_button.add(new WechatMenu.Button(){
                    {
                        name = "化";
                    }
                    public String type = "click";
                    public String key = "V100125";
                });
            }
        });
        menu.matchrule = new WechatMenu.Matchrule(){
            {
                country = "中国";
                province = "浙江";
                city = "杭州";
            }
        };

        WechatMenu.ConditionalMenu conditionalMenu = menuService.addConditional(menu);
        System.out.println(conditionalMenu.menuid);
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
