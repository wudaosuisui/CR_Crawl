package com.asiainfo.manydo.crawl.worktask;

import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.tool.MyWriteFile;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

/**
 * 爬取微信
 * 使用技术 WebDriver
 * **/
@Slf4j
public class SougouWeixinTask_old {

    public void run(String url,int i){

        WebDriver wd = null;
        JsoupExctrator jsoupExctrator = new JsoupExctrator();
        MyWriteFile myWriteFile = new MyWriteFile("D:\\Documents\\WorkTasks\\微信公众号爬取\\else","Page"+i+".txt");

        try {

            System.setProperty("webdriver.chrome.driver", "D:\\WorkShoft\\Chrome\\Application\\chromedriver.exe");
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


            Set<String> otherWins = wd.getWindowHandles();
            String current = wd.getWindowHandle();
            otherWins.remove(current);
//            wd.switchTo().window(new);
//            wd.switchTo().window(current);

            for(String win : otherWins){
                log.info(win  + " Page : ");
//                刷新当前页
//                wd.navigate().refresh();
                try {
                    Thread.sleep(1000*2);
//                Thread.sleep(5000l*20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wd.switchTo().window(win);
//                log.info(wd.getPageSource());
                jsoupExctrator.init(wd.getPageSource());
                if(jsoupExctrator.select("#activity-name").equals("")){
                    continue;
                }else {

//                标题 公众号  作者  时间  正文
                    log.info("标题:"+jsoupExctrator.select("#activity-name")+
                            " 发布时间："+jsoupExctrator.select("#publish_time")+
                            " 作者："+jsoupExctrator.select("#meta_content > span.rich_media_meta.rich_media_meta_text")+
                            " 公众号："+getProfileBt(jsoupExctrator.select("#profileBt")));
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(getTitle(jsoupExctrator.select("#activity-name")));
                    stringBuffer.append("|");
                    stringBuffer.append(getProfileBt(jsoupExctrator.select("#profileBt")));
                    stringBuffer.append("|");
                    stringBuffer.append(jsoupExctrator.select("#meta_content > span.rich_media_meta.rich_media_meta_text"));
                    stringBuffer.append("|");
                    stringBuffer.append(jsoupExctrator.select("#publish_time"));
                    stringBuffer.append("|");
                    stringBuffer.append(jsoupExctrator.select("#js_content"));
                    myWriteFile.writeLine(stringBuffer.toString());
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

        }finally{

            myWriteFile.close();
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
}
