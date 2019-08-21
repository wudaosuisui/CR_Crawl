package com.asiainfo.manydo.crawl.fetcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FetcherFactory {
    private static HttpClientFactory httpClientFactory  = new HttpClientFactory();

    private static  FetcherFactory fetcherFactory = new FetcherFactory();
    public static FetcherFactory getInstance(){ return  fetcherFactory ; }
    public static HttpClientFactory getHttpClientFactory(){ return httpClientFactory;}

    /*
        * 输入关键字 获取对应解析器
        * */
    public static Fetcher getFetcher(String excName){
        switch(excName)
        {
            case "HttpClientFetcher" :
                return new HttpClientFetcher();
            case "HtmlUnitFetcher" :
                return new HtmlUnitFetcher();
            default :
                log.error(" excName is Wrong : "+ excName);
                return null;
        }
//        if(excName.equals("HttpClientFetcher")){
//            return new HttpClientFetcher();
//        }else if(excName.equals("HtmlUnitFetcher")){
//            return new HtmlUnitFetcher();
//        }else{
//            log.error(" excName is Wrong : "+ excName);
//            return null;
//        }

//        if(excName.indexOf("httpClient")>0){
//            return new HttpClientFetcher();
//        }else if(excName.indexOf("htmlUnit")>0){
//            return new HtmlUnitFetcher();
//        }else{
//            return null;
//        }
    }

}
