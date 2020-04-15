package com.asiainfo.cr.crawl.store.dao;

import com.asiainfo.cr.crawl.store.pojo.SysUser;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SysUserDao extends   MongoRepository<SysUser, ObjectId>   {
//SysUserMapperTest
//}, MongoRepository<SysUser, ObjectId>  {

    @SuppressWarnings("unchecked")
    public SysUser insert(SysUser sysUser);

    @Query("{\"task_id\": ?0 , \"excute_id\": ?1, \"excute_uuid\": ?2, \"url_seq\": ?3}")
    public List<SysUser> findBy4(Integer taskId, Integer excuteId, String excuteUuid, Integer urlSeq);

    @DeleteQuery("{\"task_id\": ?0 }")
    public void delete(Integer taskId);


}
