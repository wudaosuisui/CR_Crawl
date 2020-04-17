package com.asiainfo.cr.crawl.store.mysql.mapper;


import com.asiainfo.cr.crawl.store.pojo.SysUser;


public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int myinsert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser sysUser);

    int updateByPrimaryKey(SysUser sysUser);

}