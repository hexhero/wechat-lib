# Wechat Lib 微信公众平台开发组件包 for java 😛
Wechat Official Accounts Develop Support For JAVA  
使用微信公众号 🔥 开发组件包能够快速的开发微信公众号后台,提供了支持与公众平台交互的API,通过wechat-lib提供的API进行快速开发.


## 将wechat-lib加入到你的项目

jar: `wechat-lib-1.0.0.jar` JDK1.8  

maven: 将项目下载本地仓库 `mvn install`, 并在你项目`pom.xml`中配置
```xml
<dependency>
    <groupId>com.yangb</groupId>
    <artifactId>wechat-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 在你的项目中使用wechat-lib

在你的项目中微信服务器配置地址接口交给wechat-lib来处理微信的请求,使用如下代码.  

```java
@Controller
@RequestMapping("/YouWechatServerAddress")
public class PublicController {

    @Autowired
    DispatcherManagement dispatcher;
    @Autowired
    XmlResolver xmlResolver;
    
    @PostMapping(headers = {"Content-Type=text/xml","Content-Type=application/xml"})
    @ResponseBody
    public String msgEvent(@RequestBody String content){
        EventMsg eventMsg = dispatcher.dispatch(content);
        return xmlResolver.toXml(eventMsg);
    }
    
    @GetMapping
    public String serverEvent(VerifyServer server){
        return server.getEchostr();
    }    
}
```
`DispatcherManagement` 和 `XmlResolver` 可以在Spring中配置,用`@Autowired`注入
```xml
<bean id="dispatcher" class="com.yangb.weichatmanager.management.DispatcherManagement"></bean>
<bean id="xmlResolver" class="com.yangb.weichatmanager.util.XmlResolver"></bean>
```
也可以用wechat-lib的`BeanFactory`直接创建他,取决于你的项目,创建方式如下:
```java
dispatcher = BeanFactory.getInstance().getService(DispatcherManagement.class);
xmlResolver = BeanFactory.getInstance().getService(XmlResolver.class);
```

## 配置账号
在项目启动之前需要对`weichatmanager`进行一些初始化操作,配置开发者账号和密码
```java
WechatInitialize.init("you appid","you appsecret"); //初始化账号
```

## 消息/事件处理器
如果需要接收并处理公众号的事件和消息,需要实现事件/消息处理器的接口,并且在初始化的时候注册他们.
* 事件处理器接口 `EventHandler` 接受微信事件并作出响应,如关注事件,菜单事件等等
 ```java
    /**
     * 点击菜单拉取消息时的事件推送
     * @param event
     * @return
     */
    EventMsg menuClick(MenuClickEvent event);

    /**
     * 点击菜单跳转链接时的事件推送
     * @param event
     * @return
     */
    EventMsg menuView(MenuClickEvent event);
    
    ...
```

* 消息处理器`MsgHandler`
```java
/**
     * 文本消息
     * @param msg
     * @return
     */
    EventMsg textMsg(TextMsg msg);

    /**
     * 图片消息
     * @param msg
     * @return
     */
    EventMsg imageMsg(ImageMsg msg);

    /**
     * 语音消息
     * @param msg
     * @return
     */
    EventMsg voiceMsg(VoiceMsg msg);
    ...
```
例如:对微信发来的文字消息进行回复
```java
    @Override
    public EventMsg textMsg(TextMsg textMsg) {
        System.out.println(textMsg.getContent());
        TextMsg msg = MsgReplyHelper.preprocess(textMsg);
        msg.setMsgType("text");
        msg.setContent("我在回复你的消息");
        return msg;
    }
```
## 注册事件处理器或消息处理器
最好在初始化的时候进行注册
```java
WechatInitialize.registEventHandler(new EventServiceImpl());//如果要处理消息,注册消息处理器
WechatInitialize.registMsgHandler(new MsgServiceImpl());//如果需要处理事件,注册事件处理器
```

## Wechat Lib Service
提供对公众平台的操作API
### MenuService
提供对公众号自定义菜单以及个性化菜单的API.  
test包的 `MenuServiceTests` 提供了调用自定义菜单的DEMO


## 该项目暂未全部完成,正在进行中,开发进度如下.
- [x] 服务器认证接口  
- [x] 自定义菜单 菜单事件推送 个性化菜单  
- [x] 消息管理  
- [ ] 用户管理  
- [ ] 账号管理  
- [ ] 素材管理  
- [ ] 网页开发  
- [ ] 数据统计  
- [ ] 微信卡卷  
- [ ] 微信支付  



