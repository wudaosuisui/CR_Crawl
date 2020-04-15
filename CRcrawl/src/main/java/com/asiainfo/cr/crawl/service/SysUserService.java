package com.asiainfo.cr.crawl.service;

import com.asiainfo.cr.crawl.store.dao.SysUserDao;
import com.asiainfo.cr.crawl.store.mysql.tst.SysUserMapperTest;
import com.asiainfo.cr.crawl.store.dao.UrlsDao;
import com.asiainfo.cr.crawl.store.pojo.Urls;
import com.asiainfo.cr.crawl.store.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapperTest sysUserMapper;
    @Autowired
    private UrlsDao urlsDao;
    @Autowired
    private SysUserDao sysUserDao;




    //    增
//    public void addMysql(SysUser sysUser){sysUserMapper.insert(sysUser);}
    public void addMysql(SysUser sysUser){sysUserMapper.myinsert(sysUser);}
    public void addMoSy(SysUser sysUser){sysUserDao.insert(sysUser);}
    public void addMongo(Urls urls){urlsDao.insert(urls);}


//    删
//    改
//    查

}
