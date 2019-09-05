package com.asiainfo.manydo.crawl.dao.mapper;

import com.asiainfo.manydo.crawl.dao.pojo.MhReshourse;

public interface MhReshourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MhReshourse record);

    int insertSelective(MhReshourse record);

    MhReshourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MhReshourse record);

    int updateByPrimaryKey(MhReshourse record);
}