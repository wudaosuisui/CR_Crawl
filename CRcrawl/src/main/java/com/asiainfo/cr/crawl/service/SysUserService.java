package com.asiainfo.cr.crawl.service;

//import com.asiainfo.manydo.crawl.dao.mapper.SysUserMapper;
//import com.asiainfo.manydo.crawl.dao.pojo.SysUser;
//import com.asiainfo.manydo.crawl.mongo.dao.SysUserDao;
import com.asiainfo.cr.crawl.store.mongo.dao.UrlsDao;
import com.asiainfo.cr.crawl.store.mongo.model.Urls;
import com.asiainfo.cr.crawl.store.mysql.mapper.SysUserMapper;
import com.asiainfo.cr.crawl.store.mysql.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private UrlsDao urlsDao;



//    增
    public void addMysql(SysUser sysUser){sysUserMapper.insert(sysUser);}
    public void addMongo(Urls urls){urlsDao.insert(urls);}


//    删
//    改
//    查

}
