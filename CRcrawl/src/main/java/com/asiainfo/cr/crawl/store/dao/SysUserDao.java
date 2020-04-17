package com.asiainfo.cr.crawl.store.dao;

import com.asiainfo.cr.crawl.store.mongo.dao.SysUserMongoDao;
import com.asiainfo.cr.crawl.store.mysql.mapper.SysUserMapper;
import com.asiainfo.cr.crawl.store.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserDao {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserMongoDao sysUserMongoDao;


//    增

    public void addMy(SysUser sysUser) {
        sysUserMapper.myinsert(sysUser);
    }

    public void addMo(SysUser sysUser) {
        sysUserMongoDao.insert(sysUser);
    }

//    删

    public void delMyById(Integer userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

//    改

    public void upMyById(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKey(sysUser);
    }
//    查
}
