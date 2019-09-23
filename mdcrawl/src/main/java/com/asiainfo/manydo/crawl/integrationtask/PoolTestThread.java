package com.asiainfo.manydo.crawl.integrationtask;

import lombok.extern.slf4j.Slf4j;

/*
* 测试线程池调度
* */
@Slf4j
public class PoolTestThread implements Runnable{

//    编号
    private int num;
//    名称
    private String name;

    public PoolTestThread() {
    }

    public PoolTestThread(int num, String name) {
        this.num = num;
        this.name = name;
    }

    //    继承  Runnable  ，加入线程池后，会自动调度执行 run() 方法
    @Override
    public void run() {
        log.info("编号 ： "+num+" 名称："+name);
    }
}
