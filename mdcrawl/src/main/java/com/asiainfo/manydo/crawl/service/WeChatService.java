package com.asiainfo.manydo.crawl.service;

import com.asiainfo.manydo.crawl.dao.mapper.WeChatSubscriptionMapper;
import com.asiainfo.manydo.crawl.dao.pojo.ErrorMassage;
import com.asiainfo.manydo.crawl.dao.pojo.WeChatSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeChatService extends CommonService {
    @Autowired
    private WeChatSubscriptionMapper weChatSubscriptionMapper;

    public void addWeChat(WeChatSubscription weChatSubscription){weChatSubscriptionMapper.insert(weChatSubscription);}
    public void addMassage(String url,String massage){
        addMassage( "搜狗微信" , url, massage);}

}
