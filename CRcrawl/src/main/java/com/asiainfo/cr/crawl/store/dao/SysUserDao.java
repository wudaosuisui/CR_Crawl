package com.asiainfo.cr.crawl.store.dao;

import com.asiainfo.cr.crawl.store.mongo.dao.SysUserMongoDao;
import com.asiainfo.cr.crawl.store.mysql.mapper.SysUserMapper;
import com.asiainfo.cr.crawl.store.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserDao {
//
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserMongoDao sysUserDao;


    public void addMysql(SysUser sysUser){sysUserMapper.myinsert(sysUser);}
    public void addMoSy(SysUser sysUser){sysUserDao.insert(sysUser);}
}
