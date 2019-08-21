package com.asiainfo.manydo.crawl.mongo.dao;

import com.asiainfo.manydo.crawl.dao.pojo.SysUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SysUserDao extends MongoRepository<SysUser, ObjectId> {
    @SuppressWarnings("unchecked")
    public SysUser insert(SysUser sysUser);

    @Query("{?0:?1}")
    public SysUser findOne(String key, String value);

    @DeleteQuery("{\"key\":?0}")
    public void deleteById(String id);
}
