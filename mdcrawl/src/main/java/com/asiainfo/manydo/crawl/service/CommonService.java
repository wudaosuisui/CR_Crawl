package com.asiainfo.manydo.crawl.service;

import com.asiainfo.manydo.crawl.dao.mapper.ErrorMassageMapper;
import com.asiainfo.manydo.crawl.dao.pojo.ErrorMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CommonService {
    @Autowired
    private ErrorMassageMapper errorMassageMapper;

    public void addMassage(String appName ,String url,String massage){
        errorMassageMapper.insert(new ErrorMassage(appName,url,massage,new Date()));}


}
