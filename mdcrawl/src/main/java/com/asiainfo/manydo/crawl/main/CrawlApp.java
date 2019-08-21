package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.dao.pojo.SysUser;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.SysUserService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CrawlApp {
    public static void main( String[] args ) {
        SpringManage.init();
        run();
        test();
    }

    public static void run(){

    }

    public static void test(){

        String url = "http://music.migu.cn/v3/music/playlist?tagId=1000001672";
        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
        log.info(" str : ");
        log.info(httpClientFetcher.sendGetRequest(url));
        /*
        MongoDB 存储测试成功
        且 在同一个 Service 中  存储的 同一个实体类

        SysUserService sysUserService = SpringManage.getBean(SysUserService.class);
        SysUser sysUser = new SysUser();
        sysUser.setRealName("testRealName");
        sysUserService.addMon(sysUser);
        */
        /*
        MySQL 存储测试成功

        SysUserService sysUserService = SpringManage.getBean(SysUserService.class);
        SysUser sysUser = new SysUser();
        sysUser.setRealName("testRealName");
        sysUserService.add(sysUser);
        */
    }
}
