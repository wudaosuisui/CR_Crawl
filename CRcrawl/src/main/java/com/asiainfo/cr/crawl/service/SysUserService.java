package com.asiainfo.cr.crawl.service;

//import com.asiainfo.manydo.crawl.dao.mapper.SysUserMapper;
//import com.asiainfo.manydo.crawl.dao.pojo.SysUser;
//import com.asiainfo.manydo.crawl.mongo.dao.SysUserDao;
import com.asiainfo.cr.crawl.store.dao.SysUserDao;
import com.asiainfo.cr.crawl.store.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

//    增
    public void addMongo(SysUser sysUser){sysUserDao.addMongo(sysUser);}
    public void addMysql(SysUser sysUser){sysUserDao.addMysql(sysUser);}


//    删
//    改
//    查

}
