package com.asiainfo.manydo.crawl.task;

import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.CommonService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;

/*
* 当当网
* */

@Slf4j
public class DangDangTask {

    //    访问器
    private HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
    //    列表页解析器
    private JsoupExctrator jsoupExctrator = new JsoupExctrator();
    //    存储器
    private CommonService commonService = SpringManage.getBean(CommonService.class);

    public void run(String url){
        try {
//            String string = httpClientFetcher.sendGetRequest(url);
//            log.info(string);
            jsoupExctrator.init(httpClientFetcher.sendGetRequest(url));
//            jsoupExctrator.init(string);
            String name = getName(jsoupExctrator);
//            String name = jsoupExctrator.select(".dangdang_icon");

            String id = getId(url);
//            ICAZ:8888888888_t4378|{"createTime":"2019-07-30 15:36:45","p1":"一线天","p2":"","p3":"","p4":{"cat1":"旅游","cat2":"","cat3":"","cat4":"","cat5":"0"},"tags":""}
            if(name.equals("")){
                add("Fail-"+url,"2-获取元素失败");
            }else {
                String str = "ICAZ:15008_" + id + "|{\"createTime\":\"2019-09-20 15:36:45\",\"p1\":\"" + name + "\",\"p2\":\"\",\"p3\":\"\",\"p4\":{\"cat1\":\"电商\",\"cat2\":\"\",\"cat3\":\"\",\"cat4\":\"\",\"cat5\":\"0\"},\"tags\":\"\"}";
                add("Succ-" + url, str);
            }
        }catch (Exception e){
            add("Fail-"+url,"1-爬取失败");
        }

    }

    public String getName(JsoupExctrator jsoupExctrator){
        String name = null;
        name  = jsoupExctrator.select(".dangdang_icon");
        if(!name.equals("")){
            return name;
        }
        name  = jsoupExctrator.select(".j_detail article");
        if(!name.equals("")){
            return name;
        }
        return name;
    }
    public  String getId(String url){
        int top = url.indexOf("m/")+2;
//        log.info("top :"+top);
        if(top>2){
            int end = url.indexOf(".ht");
//            log.info("end :"+end);
            return url.substring(top,end);
        }
        return null;
    }
    public void add(String url , String str){
        commonService.addMassage("当当网-客户识别",url,str);
    }



}
