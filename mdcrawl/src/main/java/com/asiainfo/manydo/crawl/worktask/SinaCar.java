package com.asiainfo.manydo.crawl.worktask;

import com.asiainfo.manydo.crawl.dao.pojo.MhReshourse;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.CaricatureService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
* 新浪汽车
* */

@Slf4j
public class SinaCar extends  CrawlTask{
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
        this.CrawlCar(seedUrl,catgoryName);
    }

    /*
    * 爬取流程函数
    * */
    public void CrawlCar(String seedUrl,String catgoryName){
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
            while (!isStop) {
                try {
//            访问 cUrl  获取列表页
                    log.info("开始爬取列表页 Page : " + page++ + " Url : " + cUrl);
//            存储一下  访问前  cURl的值
                    copyUrl = cUrl;
                    jsoupExctratorForList.init( httpClientFetcher.sendGetRequest(cUrl));
//            获取下一页
                    cUrl = jsoupExctratorForList.selectElements(".next").get(0).attr("href");
//                    获取元素列表
                    Elements elements = jsoupExctratorForList.selectElements("#J_motoDataMain > div.content > div.y-tuku235.seek-list > ul > li");
//        通用id
                    String re_id = "ICAZ:18714_";
//            循环处理列表元素
                    for(Element element : elements) {
                        String url= element.select("div > a").get(0).attr("href");
                        String title = formalStrP(element.select("p.title").text());
                        String price = formalStrP(element.select("p.price").text());
                        //            存储的 String
                        StringBuffer str = new StringBuffer();
                        str.append("{\"createTime\":\"2019-09-06\",\"p1\":\"");
                        str.append(title);
                        str.append("\",\"p2\":\"");
                        str.append(price);
                        str.append("\",\"p3\":\"");
                        str.append(url);
                        str.append("\",\"p4\":{\"cat1\":\"阅读\",\"cat2\":\"阅读\",\"cat3\":\"" );
                        str.append(catgoryName);
                        str.append("\",\"cat4\":\"\",\"cat5\":\"0\"},\"tags\":\"\"}");
                        MhReshourse mhReshourse = new MhReshourse(re_id+getId(url),str.toString());
                        caricatureService.add(mhReshourse);
                    }

//            判停
                    String massage = catgoryName+"分类 ， Page : " + (page-1) + " 最后一页url为 ：" + copyUrl;
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

                }catch (Exception e) {
                    log.error(" 循环翻页出错 ，" + stopMassage,e);
                    caricatureService.addMassage("新浪汽车Error "+catgoryName,seedUrl,"循环翻页出错 "+e);
                    break;
                }
            } // while (!isStop) End
            log.info(stopMassage);
            caricatureService.addMassage("新浪汽车 "+catgoryName,copyUrl,stopMassage);

        }catch (Exception e){
            log.error("新浪汽车 "+catgoryName+" 爬取流程整体出错",e);
            caricatureService.addMassage("新浪汽车Error "+catgoryName,seedUrl,"爬取流程整体出错 "+e);
        }
        log.info(" --------------------- "+catgoryName+" END ------------------------- ");

    }

//     -------------------- 一些处理函数
    public String getId(String url){
        try {

//        href="//db.auto.sina.com.cn/1384/
//        int top = url.lastIndexOf("/")+1;
//        if(top>1){
//            int end = url.indexOf(".html");
//            return url.substring(top,end);
//        }
//        return null;
        String[] strlist = url.split("/");
        return strlist[2];
        }catch (Exception e){
            log.error("截取 id 出错",e);
            return null;
        }
    }
}






















