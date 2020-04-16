package com.asiainfo.cr.crawl.store.mysql.mapper;


import com.asiainfo.cr.crawl.store.pojo.SysUser;


public interface SysUserMapper
{
//        extends MongoRepository<SysUser, ObjectId> {
    int deleteByPrimaryKey(Integer userId);

    int myinsert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
//




}