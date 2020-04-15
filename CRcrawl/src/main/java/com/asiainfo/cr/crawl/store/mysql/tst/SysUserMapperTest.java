package com.asiainfo.cr.crawl.store.mysql.tst;


import com.asiainfo.cr.crawl.store.pojo.SysUser;

public interface SysUserMapperTest {
    int deleteByPrimaryKey(Integer userId);

    int myinsert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}