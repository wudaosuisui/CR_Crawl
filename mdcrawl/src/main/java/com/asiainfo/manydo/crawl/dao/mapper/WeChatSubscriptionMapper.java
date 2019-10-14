package com.asiainfo.manydo.crawl.dao.mapper;

import com.asiainfo.manydo.crawl.dao.pojo.WeChatSubscription;

public interface WeChatSubscriptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatSubscription record);

    int insertSelective(WeChatSubscription record);

    WeChatSubscription selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatSubscription record);

    int updateByPrimaryKey(WeChatSubscription record);
}