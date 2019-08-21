package com.asiainfo.manydo.crawl.extract;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class JsonExctrator implements Exctrator {

    private  JSONObject jsonObject ;

    @Override
    public void init(String jsonString){
        this.jsonObject = JSONArray.parseObject(jsonString);
    }

    @Override
    public String select(String key){
        return jsonObject.getString(key);
    }

    @Override
    public String selectUrl(String cssQuery) {
        return null;
    }


    public JSONObject getJsonObject() {
        return jsonObject;
    }
    /*
    * 通过HttpClientFactory获取数据
    * 并解析成Json
    * */
//    public JSONObject getJsonByHttpClientFactory(String url){
//        String returnStr = httpClientFactory.sendGetRequest(url,"");
//        return  JSONArray.parseObject(returnStr);
//    }
}
