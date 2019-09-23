package com.asiainfo.manydo.crawl.integrationtask;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
* 动态爬取页面
* */
@Slf4j
public class WebdriverTask {

    public void run(){

        WebDriver wd = null;

        try {

//            System.setProperty("webdriver.firefox.bin", "E:\\WorkShoft\\Mozilla Firefox\\firefox.exe");
            System.setProperty("webdriver.chrome.driver", "D:\\WorkShoft\\Chrome\\Application\\chromedriver.exe");

//            启动浏览器
//             wd =new FirefoxDriver();
            wd = new ChromeDriver();

//            访问页面
            wd.get("http://www.gdzwfw.gov.cn/portal/personal/theme?region=440000&catalogCode=001001002");

//            等待几秒，页面加载完毕。
            try {
                Thread.sleep(1000*2);
//                Thread.sleep(5000l*20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Actions action = new Actions(wd);
//            获取元素
            WebElement buttrn1 = wd.findElement(By.cssSelector("body>div.wrapper>div.main>div:nth-child(1)>div.matters-list>div.matters-list-pagination>ul>li:nth-child(3)>a"));
            WebElement buttrn2 = wd.findElement(By.cssSelector("#bPageNextPage"));
            WebElement tr = wd.findElement(By.cssSelector("#content > tr:nth-child(1)"));
//            log.info("tr : "+tr.getText());
            try {
//                点击元素
                buttrn1.click();
            }catch (Exception e){
                log.error("",e);
            }
//            等待几秒
            try {
                Thread.sleep(1000*4);
//                Thread.sleep(5000l*20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Str:");
//            输出页面内容
            log.info(wd.getPageSource());
            try {
                Thread.sleep(1000*2);
//                Thread.sleep(5000l*20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//            //获取输入框
//            WebElement shurukuang = wd.findElement(By.cssSelector("#sole-input"));
//            //输入检索内容
//            shurukuang.sendKeys(grabCity.getCity() + "市美食");
//            //获取检索按钮
//            WebElement jiansuo = wd.findElement(By.cssSelector("#search-button"));
//            //点击检索按钮
//            jiansuo.click();
//            获取列表页内容
//            restaurant = wd.findElements(By.className("n-blue"));//获取列表页内容




        } catch(Exception  e){

            log.error("web driver 启动整体出错",e);

        }finally{
            try{
                //关闭driver
                if(wd!=null) {
                    wd.close();
                }
            }catch(Exception e){
                log.error("关闭 driver 出错",e);
            }
        }
    }
}
