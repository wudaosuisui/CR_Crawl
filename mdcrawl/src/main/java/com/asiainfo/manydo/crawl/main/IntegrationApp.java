package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.integrationtask.PoolTestThread;
import com.asiainfo.manydo.crawl.integrationtask.WebdriverTask;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class IntegrationApp {
    public static void main( String[] args ) {
        SpringManage.init();
//        线程池的操作
        poolRun();
//        动态操纵页面
//        WebDriverRun();
    }
    /*
    * 内容：
    * 效果：
    * */
    public static void Run(){

    }

    /*
    * 内容：线程池的操作
    * 效果：成功
    * */
    public static void poolRun(){
        try {
//            添加的这几个线程是并行的（在最大并行线程数内），不是顺序执行的
//            执行完成后，超时自动停止线程。
//        创建线程池
            ExecutorService pool = Executors.newFixedThreadPool(4);//最多并行线程数
            pool.submit(new PoolTestThread(1,"一号线程"));
            pool.submit(new PoolTestThread(2,"二号线程"));
            pool.submit(new PoolTestThread(3,"三号线程"));
        }catch (Exception e){
            log.error("线程池执行出错",e);
        }

    }

    /*
    * 内容：动态操纵页面
    * 效果：测试基本成功
    * */
    public static void WebDriverRun(){
        WebdriverTask webdriverTask = new WebdriverTask();
        webdriverTask.run();
    }

}
