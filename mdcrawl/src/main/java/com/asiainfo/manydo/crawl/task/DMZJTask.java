package com.asiainfo.manydo.crawl.task;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.manydo.crawl.dao.pojo.MhReshourse;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.CaricatureService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;

@Slf4j
public class DMZJTask  extends  CrawlTask{

    //    访问器
    private HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
    //    列表页解析器
    private JsoupExctrator jsoupExctratorForList = new JsoupExctrator();
    //    详情页解析器
    private JsoupExctrator jsoupExctratorForPage = new JsoupExctrator();
    //    存储器
    private CaricatureService caricatureService = SpringManage.getBean(CaricatureService.class);

    public DMZJTask(HttpClientFetcher httpClientFetcher, JsoupExctrator jsoupExctratorForList, JsoupExctrator jsoupExctratorForPage, CaricatureService caricatureService) {
        this.httpClientFetcher = httpClientFetcher;
        this.jsoupExctratorForList = jsoupExctratorForList;
        this.jsoupExctratorForPage = jsoupExctratorForPage;
        this.caricatureService = caricatureService;
    }

    public DMZJTask() {
    }

    @Override
    public void run() {

    }

    /*
    * 执行函数
    * */
    public void run(String catgoryName ,String catgoryNum,String pageNum){

        int pageMax = Integer.parseInt(pageNum);
        this.CrawlDMZJ(catgoryName,catgoryNum,pageMax);
    }
    /*
    * 爬取流程函数
    * */
    public void CrawlDMZJ(String catgoryName ,String catgoryNum,int pageMax){
//        url : https://www.dmzj.com/category/0-0-0-2-0-0-1.html
//        注 2 是分类   1  是页码

//        组装 url
//        循环url
//        获取列表元素
//        爬取列表元素详情页


//        组装url   https://www.dmzj.com/category/0-0-0-?-0-0-
//        主体部分Url
        String Url = "https://www.dmzj.com/category/0-0-0-"+catgoryNum+"-0-0-";
//        访问的url
        String url = "";
//        页码
        int page = 1 ;
//      在最大页数范围内  循环url
        try {
            for (;page<=pageMax;page++){
                log.info("列表页爬取 "+catgoryName+" 类型，正在爬取第 "+page+" 页");
                url = Url+page+".html";
//                访问 并注入
                jsoupExctratorForList.init(httpClientFetcher.sendGetRequest(url));
//                判断一下返回情况
//                获取列表元素
                Elements elements = jsoupExctratorForList.selectElements("body > div.wrap_mhlist.autoHeight > div.wrap_mhlist_l.con_left > div.wrap_list_con.autoHeight > div > ul > li");

//        通用id
                String re_id = "ICAZ:22891_";

//                循环处理列表元素
                for(Element element : elements){
                    String bookUrl=element.select("span > h3 > a").attr("href");
                    String title = formalStrP(element.select("span > h3 > a").text());
                    String author = formalAuthor(element.select("span > p:nth-child(2)").text());
//            存储的 String
                    StringBuffer str = new StringBuffer();
                    str.append("{\"createTime\":\"2019-09-06\",\"p1\":\"");
                    str.append(title);
                    str.append("\",\"p2\":\"");
                    str.append(author);
                    str.append("\",\"p3\":\"");
                    str.append(bookUrl);
                    str.append("\",\"p4\":{\"cat1\":\"阅读\",\"cat2\":\"阅读\",\"cat3\":\"" );
                    str.append(catgoryName);
                    str.append("\",\"cat4\":\"\",\"cat5\":\"0\"},\"tags\":\"\"}");
                    MhReshourse mhReshourse = new MhReshourse(re_id+getId(bookUrl),str.toString());
                    caricatureService.add(mhReshourse);




//                    log.info("bookUrl : "+element.select("span > h3 > a").attr("href"));
//                    爬取详情页
//                    CrawlDMZJPage(element.select("span > h3 > a").attr("href"),catgoryName);

                }

                log.info("列表页爬取 "+catgoryName+" 类型, "+page+" 页，爬取完成");
            }
            caricatureService.addMassage("动漫之家 "+catgoryName,url,catgoryName+" 类型，爬取完成，page "+(page-1));
        }catch (Exception e){
            log.error(" 循环爬取列表页时出错 ， 类型： "+catgoryName+" 类型代码 ： "+catgoryNum+" 页数, url: "+url);
        }

        log.info(" ------------  END "+catgoryName+" 类型 爬取完成 ------------------");
    }

    /*
    * 爬取详情页的函数
    * */
    public void CrawlDMZJPage(String bookUrl , String catgoryName){

        log.info("正在爬取详情页  类型 ： "+catgoryName+" url : "+bookUrl);
        String bookName = "";
        try {
//        访问并注入
            jsoupExctratorForPage.init(httpClientFetcher.sendGetRequest(bookUrl));
//            获取
            Elements elements = jsoupExctratorForPage.selectElements("body > div.wrap.autoHeight > div.wrap_intro_l.widthEigLeft.con_left > div.zj_list.autoHeight > div.tab-content.tab-content-selected.zj_list_con.autoHeight > ul > li a");
//        作者
            String author = formalAuthor(jsoupExctratorForPage.select("body > div.wrap.autoHeight > div.wrap_intro_l.widthEigLeft.con_left > div.wrap_intro_l_comic > div.comic_deCon > ul.comic_deCon_liO > li:nth-child(1)"));
//        书名
            bookName = jsoupExctratorForPage.select("body > div.wrap.autoHeight > div.wrap_intro_l.widthEigLeft.con_left > div.wrap_intro_l_comic > div.comic_deCon > h1 > a");

//      示例数据：  ICAZ:21300_157477|{"createTime":"2019-08-26","p1":"一代灵后 第12话 人世间（下）","p2":"","p3":"","p4":{"cat1":"阅读","cat2":"阅读","cat3":"","cat4":"","cat5":"0"},"tags":""}

//        通用id
            String re_id = "ICAZ:22891_";

            for(Element element : elements) {
//            存储的 String
                StringBuffer str = new StringBuffer();
                String url = element.attr("href");
                String title = formalTitle(element.attr("title"));
                str.append("{\"createTime\":\"2019-09-02\",\"p1\":\"");
                str.append(title);
                str.append("\",\"p2\":\"");
                str.append(author);
                str.append("\",\"p3\":\""+url+"\",\"p4\":{\"cat1\":\"阅读\",\"cat2\":\"阅读\",\"cat3\":\"");
                str.append(catgoryName);
                str.append("\",\"cat4\":\"\",\"cat5\":\"0\"},\"tags\":\"\"}");

                MhReshourse mhReshourse = new MhReshourse(re_id+getId(url),str.toString());

                caricatureService.add(mhReshourse);

            }

        }catch (Exception e){
            log.error("详情页爬取失败 类型 ： "+catgoryName+" bookName : "+bookName+" url : "+bookUrl,e);
            return;
        }

        log.info("详情页爬取完成  类型 ： "+catgoryName+" bookName : "+bookName+" url : "+bookUrl);

    }
    //    -------------------- 一些处理函数
    public String formalAuthor(String strAuthor){
        int top = strAuthor.indexOf("：")+1;
        if(top>1){
            return strAuthor.substring(top);
        }
        return strAuthor;
    }

    public String formalTitle(String strTitle){
        int end = strTitle.indexOf(" ");
        if(end>0){
            return strTitle.substring(0,end);
        }
        return formalStrP(strTitle);
    }

    public String getId(String url){
        int top = url.lastIndexOf("/")+1;
        if(top>1){
            int end = url.indexOf(".html");
            return url.substring(top,end);
        }
        return null;
    }


}






