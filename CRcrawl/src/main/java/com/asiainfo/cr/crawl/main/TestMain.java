package com.asiainfo.cr.crawl.main;

import com.asiainfo.cr.crawl.service.SysUserService;
import com.asiainfo.cr.crawl.spring.SpringManage;
import com.asiainfo.cr.crawl.store.dao.SysUserDao;
import com.asiainfo.cr.crawl.store.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMain {
    public static void main( String[] args ) {
        test();
    }

    public static void test(){

        SysUserService sysUserService = SpringManage.getBean(SysUserService.class);

        SysUser sysUser = new SysUser();

        sysUser.setRealName("Name Real 2");
        sysUser.setUserName("user Name 2");

        sysUserService.addMongo(sysUser);

//        2020年3月13日
//        16点46分 运行测试
        log.info(" 运行成功 。");

    }


}
