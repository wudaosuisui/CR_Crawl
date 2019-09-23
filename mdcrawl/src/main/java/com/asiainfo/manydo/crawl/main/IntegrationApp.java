package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.integrationtask.WebdriverTask;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegrationApp {
    public static void main( String[] args ) {
        SpringManage.init();
//        动态操纵页面
        WebDriverRun();
    }

    public static void run(){

    }

    /*
    * 动态操纵页面
    * 测试基本成功
    * */
    public static void WebDriverRun(){
        WebdriverTask webdriverTask = new WebdriverTask();
        webdriverTask.run();
    }

}
