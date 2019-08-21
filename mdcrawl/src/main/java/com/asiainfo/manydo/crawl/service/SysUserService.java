package com.asiainfo.manydo.crawl.service;

import com.asiainfo.manydo.crawl.dao.mapper.SysUserMapper;
import com.asiainfo.manydo.crawl.dao.pojo.SysUser;
import com.asiainfo.manydo.crawl.mongo.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserDao sysUserDao;

    public void add(SysUser sysUser){sysUserMapper.insert(sysUser);}
    public void addMon(SysUser sysUser){sysUserDao.insert(sysUser);}

}
