package com.asiainfo.manydo.crawl.fetcher;

/*
* 取样器
* 获取网页所用
* */
//@Service
public interface Fetcher {
//    @Autowired

     String sendGetRequest(String url);

}
