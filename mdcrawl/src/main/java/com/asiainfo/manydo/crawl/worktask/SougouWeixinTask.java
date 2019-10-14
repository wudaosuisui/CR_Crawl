package com.asiainfo.manydo.crawl.worktask;

import com.asiainfo.manydo.crawl.dao.pojo.WeChatSubscription;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.service.WeChatService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import com.asiainfo.manydo.crawl.tool.MyWriteFile;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 爬取微信
 * 使用技术 WebDriver
 * **/
@Slf4j
public class SougouWeixinTask {

    /**
     * run 输入
     url不再外部输入，反正里面的解析，也是针对搜狗的
     关键字  set 传入
     页码 int
     预留 map
     */
    public void run(Set<String> keys, int page, String driverDir,HashMap map){//(String url,int i){

        WebDriver wd = null;
        JsoupExctrator jsoupExctrator = new JsoupExctrator();
        WeChatService weChatService = SpringManage.getBean(WeChatService.class);
//        MyWriteFile myWriteFile = new MyWriteFile("D:\\Documents\\WorkTasks\\微信公众号爬取\\else","Page"+i+".txt");
        String url1 = "https://weixin.sogou.com/weixin?query=";
        String url3 = "&_sug_type_=&sut=24552&lkt=1%2C1569466179086%2C1569466179086&s_from=input&_sug_=y&type=2&sst0=1569466203385&page=";
        String url2 = getUrl2(keys);

        String url = url1+url2+url3+page;
        log.info(" curl : "+url);

        try {

            System.setProperty("webdriver.chrome.driver", driverDir);
            wd = new ChromeDriver();
            wd.get(url);
            try {
                Thread.sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<WebElement> lis =  wd.findElements(By.cssSelector("#main > div.news-box > ul li"));

            for(WebElement li : lis){
                li.findElement(By.cssSelector("a")).click();
                try {
                    Thread.sleep(1000*5);
//                    Thread.sleep(1000*30);
                    Thread.sleep(1000*(int)(1+Math.random()*(10-1+1)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lis.get(0).findElement(By.cssSelector("a")).click();


//            获取所有句柄
            Set<String> wins = wd.getWindowHandles();
            String current = wd.getWindowHandle();
//            去掉当前句柄
            wins.remove(current);
//            wd.switchTo().window(new);
//            wd.switchTo().window(current);

//            循环所有句柄
            for(String win : wins){
                log.info(win  + " Page : "+page);
//                刷新当前页
//                wd.navigate().refresh();
                try {
                    Thread.sleep(1000*2);
//                Thread.sleep(5000l*20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                切换到  win 句柄的 窗口
                wd.switchTo().window(win);
//                log.info(wd.getPageSource());
//                注入解析
                jsoupExctrator.init(wd.getPageSource());
                if(jsoupExctrator.select("#activity-name").equals("")){
                    continue;
                }else {

//                标题 公众号  作者  时间  正文
                    log.info("标题:"+jsoupExctrator.select("#activity-name")+
                            " 发布时间："+jsoupExctrator.select("#publish_time")+
                            " 作者："+jsoupExctrator.select("#meta_content > span.rich_media_meta.rich_media_meta_text")+
                            " 公众号："+getProfileBt(jsoupExctrator.select("#profileBt")));

                    WeChatSubscription weChatSubscription = new WeChatSubscription();
                    try {

//                    关键字 + 页码
                    weChatSubscription.setKeyword(url2+"_"+page);
//                    url
                    weChatSubscription.setUrl(wd.getCurrentUrl());
//                    标题
                    weChatSubscription.setTitle(getTitle(jsoupExctrator.select("#activity-name")));
//                    公众号
                    weChatSubscription.setWechatSubscription(getProfileBt(jsoupExctrator.select("#profileBt")));
//                    作者
                    weChatSubscription.setAuthor(jsoupExctrator.select("#meta_content > span.rich_media_meta.rich_media_meta_text"));
//                    发布时间
                    weChatSubscription.setPushTime(getPushTime(jsoupExctrator.select("#publish_time")));
//                    正文
                    weChatSubscription.setContent(jsoupExctrator.select("#js_content"));
//                    时间戳
                    weChatSubscription.setTimeStamp(new Date());

                    }catch (Exception e){
                        log.error(" 文章页 获取页面元素 出错",e);
                        weChatService.addMassage(wd.getCurrentUrl()," 文章页 获取页面元素 出错。e :"+e);

                    }
                    try {

                    weChatService.addWeChat(weChatSubscription);
                    }catch (Exception e){
                        log.error(" 存储出错  ",e);
                        weChatService.addMassage(wd.getCurrentUrl()," 存储出错。e :"+e);
                    }


//                    StringBuffer stringBuffer = new StringBuffer();
//                    stringBuffer.append(getTitle(jsoupExctrator.select("#activity-name")));
//                    stringBuffer.append("|");
//                    stringBuffer.append(getProfileBt(jsoupExctrator.select("#profileBt")));
//                    stringBuffer.append("|");
//                    stringBuffer.append(jsoupExctrator.select("#meta_content > span.rich_media_meta.rich_media_meta_text"));
//                    stringBuffer.append("|");
//                    stringBuffer.append(jsoupExctrator.select("#publish_time"));
//                    stringBuffer.append("|");
//                    stringBuffer.append(jsoupExctrator.select("#js_content"));
//                    myWriteFile.writeLine(stringBuffer.toString());
                }
            }

            try {
                Thread.sleep(1000*5);
                Thread.sleep(1000*(int)(1+Math.random()*(10-1+1)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }catch(Exception  e){

            log.error("web driver 启动整体出错",e);
            weChatService.addMassage("","web driver 启动整体出错 。"+e);

        }finally{

//            myWriteFile.close();
            try{
                //关闭driver
                if(wd!=null) {
                    Set<String> otherWins = wd.getWindowHandles();
                    for(String win : otherWins){
                        log.info(win+" close ");
                        wd.switchTo().window(win);
                        wd.close();
                    }
                }
            }catch(Exception e){
                log.error("关闭 driver 出错",e);
                weChatService.addMassage("","关闭 driver 出错 。"+e);
            }
        }
    }

    public String getTitle(String str){
        return str.replace("|"," ").replace("\""," ");
    }

    public String getProfileBt(String str){
        int top = str.indexOf(" ");
        if(top>0){
            return  str.substring(0,top);
        }
        return null;
    }
    public String getUrl2(Set<String> keys){
        StringBuffer stringBuffer = new StringBuffer();
        for(String key :keys){
            if(key.contains(" ")){
                key = key.replace(" ","%20");
            }
            stringBuffer.append(key);
            stringBuffer.append("%20");
        }
        return stringBuffer.toString();
    }
    public String getPushTime(String str){
        if(str.contains("今天")){
            return "2019年10月14日";
        }
        if(str.contains("昨天")){
            return "2019年10月13日";
        }
//        if(str.contains("今天")){
//            return "2019年10月14日";
//        }
        return str;
    }
}
