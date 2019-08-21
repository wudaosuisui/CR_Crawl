package com.asiainfo.manydo.crawl.extract;

import com.alibaba.fastjson.JSONObject;

/*
* 解析器
* */
public interface Exctrator {

    void init(String html);

    String select(String cssQuery);

    String selectUrl(String cssQuery);

    JSONObject getJsonObject();
}
