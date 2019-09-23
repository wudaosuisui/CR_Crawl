package com.asiainfo.manydo.crawl.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.manydo.crawl.dao.pojo.MhReshourse;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.CaricatureService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;

import java.util.*;


/*
*
* 布卡漫画
* */
@Slf4j
public class BuKaTask extends  CrawlTask{

//    访问器
    private HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
//    列表页解析器
    private JsoupExctrator jsoupExctratorForList = new JsoupExctrator();
//    详情页解析器
    private JsoupExctrator jsoupExctratorForPage = new JsoupExctrator();
//    存储器
    private CaricatureService caricatureService = SpringManage.getBean(CaricatureService.class);
    @Override
    public void run() {

    }
    /*
    * 执行函数
    * */
    public void run(String seedUrl,String catgoryName){

        this.CrawlBuKa(seedUrl,catgoryName);
    }

    /*
    * 爬取流程函数
    * */
    public void CrawlBuKa(String seedUrl,String catgoryName){
//        访问第一页
//        获取第二页
//        解析第一页 网页
//        循环列表元素
//          访问一本漫画
//          存储其数据


        try {

//        cUrl 接下来要访问的url （列表页）
            String cUrl = seedUrl;
//            备份 url 为了需要回溯url的时候 方便获取
            String copyUrl = "";

//        停止判断器
            Boolean isStop = false;
//       停止信息状态
            String stopMassage = "";
//      翻页
            int page = 0;

            int stop = 0;

            while (!isStop) {
                try {
//            列表元素的 url
//                    List<String> urlList = new ArrayList<>();
//            访问 cUrl  获取列表页
                    log.info("开始爬取列表页 Page : " + page + " Url : " + cUrl);
//            存储一下  访问前  cURl的值
                    copyUrl = cUrl;
                    String listStr = httpClientFetcher.sendGetRequest(cUrl);
//            注入列表解析器
                    jsoupExctratorForList.init(listStr);
//            获取下一页
                    cUrl = seedUrl+page*28;
//                    获取元素列表
                    Elements elements = jsoupExctratorForList.selectElements("#mangawrap > li");

//        通用id
                    String re_id = "ICAZ:2626_";

//            循环处理列表元素 url
                    for (Element element : elements) {
                        String url= "http://www.buka.cn" + element.select("div > a").get(0).attr("href");
                        String title = formalStrP(element.select("div > a").text());
                        String author = element.select("div > p > a.manga-author").text();
//            存储的 String
                        StringBuffer str = new StringBuffer();
                        str.append("{\"createTime\":\"2019-09-06\",\"p1\":\"");
                        str.append(title);
                        str.append("\",\"p2\":\"");
                        str.append(author);
                        str.append("\",\"p3\":\"");
                        str.append(url);
                        str.append("\",\"p4\":{\"cat1\":\"阅读\",\"cat2\":\"阅读\",\"cat3\":\"" );
                        str.append(catgoryName);
                        str.append("\",\"cat4\":\"\",\"cat5\":\"0\"},\"tags\":\"\"}");
                        MhReshourse mhReshourse = new MhReshourse(re_id+getId(url),str.toString());
                        caricatureService.add(mhReshourse);
                    }

////            循环处理列表元素 url
//                    for (String bookUrl : urlList) {
////                        log.info(" bookUrl : " + bookUrl);
//                        CrawlBuKaPage(bookUrl,catgoryName);
//                    }

                    log.info("列表页爬取完成 Page : " + (page++) + " Url : " + cUrl);

//            判停
                    String massage = catgoryName+"分类 ， Page : " + (page-1) + " 最后一页url为 ：" + copyUrl;
//                    log.info("massage : "+massage);
//            1.下一页获取失败
                    if (cUrl == null || cUrl.equals("")) {
                        isStop = true;
                        stopMassage = "‘下一页’url获取失败，推测已到最后一页，" + massage;
                    }
//            2.获取的列表元素为空
                    if (elements == null || elements.size() == 0) {
                        isStop = true;
                        stopMassage = "列表元素获取为空，推测已到最后一页，" + massage;
                    }
//
//            截停
//                    stop++;
//                    if (stop > 1) {
//                        isStop = true;
//                    }
                }catch (Exception e){
                    log.error(" 循环翻页出错 ，"+stopMassage);
                }
            }

            log.info(stopMassage);
            caricatureService.addMassage("布卡漫画 "+catgoryName,copyUrl,stopMassage);

        }catch (Exception e){
            log.error("爬取线程整体出错",e);
        }

        log.info(" --------------------- END ------------------------- ");


    }

    /*
    * 爬取详情页的函数
    * 这个也有多页的  但是可以一起获取 不用担心  包括番外也是
    * eg ： 非人哉 http://www.buka.cn/detail/217144.html
    * */
    public void CrawlBuKaPage(String bookUrl,String catgoryName){
        try {

            log.info("正在爬取详情页  类型 ： "+catgoryName+" url: "+bookUrl);

//        访问
        String pageStr = httpClientFetcher.sendGetRequest(bookUrl);
//        注入
        jsoupExctratorForPage.init(pageStr);
//        获取
        Elements elements = jsoupExctratorForPage.selectElements(".epsbox-eplink");
//        作者
        String author = jsoupExctratorForPage.select(".author");
//        书名
        String bookName = formalStrP(jsoupExctratorForPage.select(".title-font"));

//      示例数据：  ICAZ:21300_157477|{"createTime":"2019-08-26","p1":"一代灵后 第12话 人世间（下）","p2":"","p3":"","p4":{"cat1":"阅读","cat2":"阅读","cat3":"","cat4":"","cat5":"0"},"tags":""}

//        通用id
        String re_id = "ICAZ:2626_";

        for(Element element : elements){
            try {


            String url = element.attr("href");
            if(url.equals("")){
//                payChapter('/view/1347/65544.html','8话',4.9);
                url = formalUrl(element.attr("onclick"));
            }

//            存储的 String
                StringBuffer str = new StringBuffer();
                str.append("{\"createTime\":\"2019-09-02\",\"p1\":\"");
                str.append(formalStrP(element.attr("title")));
                str.append("\",\"p2\":\"");
                str.append(author);
                str.append("\",\"p3\":\""+url+"\",\"p4\":{\"cat1\":\"阅读\",\"cat2\":\"阅读\",\"cat3\":\"" +catgoryName+
                        "\",\"cat4\":\"\",\"cat5\":\"0\"},\"tags\":\"\"}");

            MhReshourse mhReshourse = new MhReshourse(re_id+getId(url),str.toString());

            caricatureService.add(mhReshourse);

            }catch (Exception e){
                log.error("循环 详情页 章节 出错 ， BookUrl : "+bookUrl+" element :"+element.toString(),e);
            }

        }
            log.info("详情页爬取完成  类型 ："+catgoryName+" bookName : "+bookName+" url : "+bookUrl);
        }catch (Exception e){
            log.error("循环 详情页 章节 出错 ， BookUrl : "+bookUrl,e);
        }


    }



//    -------------------- 一些处理函数
    public String formalUrl(String str){
//        payChapter('/view/1347/65544.html','8话',4.9);
        int top = str.indexOf("/");
        if(top>0){
            int end = str.indexOf("'",top);
            return str.substring(top,end);
        }
        return null;
    }

    public String getId(String url){
        int top = url.lastIndexOf("/")+1;
        if(top>1){
            int end = url.indexOf(".html");
            return url.substring(top,end);
        }
        return null;
    }

    public Map getMap(){
        Map map = new HashMap();
        map.put("cat1","阅读");
        map.put("cat2","阅读");
        map.put("cat3","");
        map.put("cat4","");
        map.put("cat5","0");
        return map;
    }

    public String getNestPage(){
        Elements elements = jsoupExctratorForList.selectElements("body > div.main.boxshadow > div.page > a");
        Element next = elements.get(elements.size()-1);
        return next.attr("href");
    }


}
