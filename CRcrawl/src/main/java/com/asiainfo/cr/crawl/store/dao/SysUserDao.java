package com.asiainfo.cr.crawl.store.dao;


import com.asiainfo.cr.crawl.store.pojo.SysUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface SysUserDao extends MongoRepository<SysUser, ObjectId> {
//    增
    public SysUser addMongo(SysUser sysUser);

    int addMysql(SysUser sysUser);

//    删
//    改
//    查
}
