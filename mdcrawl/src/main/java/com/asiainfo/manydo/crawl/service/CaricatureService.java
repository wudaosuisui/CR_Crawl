package com.asiainfo.manydo.crawl.service;

import com.asiainfo.manydo.crawl.dao.mapper.ErrorMassageMapper;
import com.asiainfo.manydo.crawl.dao.mapper.MhReshourseMapper;
import com.asiainfo.manydo.crawl.dao.pojo.ErrorMassage;
import com.asiainfo.manydo.crawl.dao.pojo.MhReshourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CaricatureService {
    @Autowired
    private MhReshourseMapper mhReshourseMapper;
    @Autowired
    private ErrorMassageMapper errorMassageMapper;

    public void add(MhReshourse mhReshourse){mhReshourseMapper.insert(mhReshourse);}
    public void addMassage(String appName ,String url,String massage){
        errorMassageMapper.insert(new ErrorMassage(appName,url,massage,new Date()));}
}
