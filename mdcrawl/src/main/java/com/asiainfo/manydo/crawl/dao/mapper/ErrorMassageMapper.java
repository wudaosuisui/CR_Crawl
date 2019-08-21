package com.asiainfo.manydo.crawl.dao.mapper;

import com.asiainfo.manydo.crawl.dao.pojo.ErrorMassage;

public interface ErrorMassageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErrorMassage record);

    int insertSelective(ErrorMassage record);

    ErrorMassage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ErrorMassage record);

    int updateByPrimaryKey(ErrorMassage record);
}