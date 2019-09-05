package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.dao.mapper.MhReshourseMapper;
import com.asiainfo.manydo.crawl.dao.pojo.MhReshourse;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClient;
import com.asiainfo.manydo.crawl.fetcher.HttpClient3;
import com.asiainfo.manydo.crawl.fetcher.HttpClient4;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.CaricatureService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import com.asiainfo.manydo.crawl.task.BuKaTask;
import com.asiainfo.manydo.crawl.task.DMZJTask;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
public class TestMain {
    public static void main( String[] args ) {
        SpringManage.init();
//        run();
        test();
    }
    public static void run(){

        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
        JsoupExctrator jsoupExctrator = new JsoupExctrator();
        String categoryUrl = "http://www.buka.cn/category";
        jsoupExctrator.init(httpClientFetcher.sendGetRequest(categoryUrl));

    }

    public static void test(){


/*

Get
Post
访问网页 测试成功

//        String url = "http://www.buka.cn/category";
        String url = "http://www.buka.cn/category/12041/%E7%8E%84%E5%B9%BB";


        JsoupExctrator jsoupExctrator1 = new JsoupExctrator();
        JsoupExctrator jsoupExctrator2 = new JsoupExctrator();
        JsoupExctrator jsoupExctrator3 = new JsoupExctrator();

        jsoupExctrator1.init(HttpClient.doPost(url,"start=56"));
        log.info(jsoupExctrator1.select("#mangawrap > li:nth-child(1)"));

        Map map = new HashMap();
        map.put("start","56");
        jsoupExctrator2.init(HttpClient3.doPost(url,map));
        log.info(jsoupExctrator2.select("#mangawrap > li:nth-child(1)"));

        jsoupExctrator3.init(HttpClient4.doPost(url,map));
        log.info(jsoupExctrator3.select("#mangawrap > li:nth-child(1)"));

*/


/*

布卡漫画 按照分类抓取
        BuKaTask buKaTask = new BuKaTask();
        List<String[]> catgoryList = new ArrayList<>();

//        catgoryList.add(new String[]{"http://www.buka.cn/category/12103/少女漫/","少女漫"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12104/少年漫/","少年漫"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12033/联合出品/","联合出品"});

        for(String[] catgory : catgoryList){
            buKaTask.run(catgory[0],catgory[1]);
        }
*/

        /*

        获取布卡漫画分类

        catgoryList.add(new String[]{"http://www.buka.cn/news/","最近更新"});
        catgoryList.add(new String[]{"http://www.buka.cn/ranking/","今日热榜"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12128/付费漫画/","付费漫画"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12084/最近上新/","最近上新"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/303/经典/","经典"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12033/联合出品/","联合出品"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12036/条漫/","条漫"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/206/百合/","百合"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12009/肥皂/","肥皂"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12041/玄幻/","玄幻"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12116/霸道总裁/","霸道总裁"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/404/恋爱/","恋爱"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12091/用户原创/","用户原创"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12018/游戏/","游戏"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/202/治愈/","治愈"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/403/科幻/","科幻"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/10008/搞笑/","搞笑"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12023/励志/","励志"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/410/格斗/","格斗"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12103/少女漫/","少女漫"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12104/少年漫/","少年漫"});
        catgoryList.add(new String[]{"http://www.buka.cn/category/12117/真人漫/","真人漫"});

        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
        JsoupExctrator jsoupExctrator = new JsoupExctrator();
        String categoryUrl = "http://www.buka.cn/category";
        jsoupExctrator.init(httpClientFetcher.sendGetRequest(categoryUrl));

        Elements elements = jsoupExctrator.selectElements("body > div.main > div > div.category-title");

        for(Element element : elements) {
            System.out.println("catgoryList.add(new String[]{\"http://www.buka.cn"+element.select("a").attr("href")+"\",\""+element.select("h5").text()+"\"});");
        }
        */
        /*
        String strAuthor = "作者：摩丝摩丝";
        int top = strAuthor.indexOf(" ")+1;
        if(top>1){
            log.info(strAuthor.substring(top));
        }
        log.info(strAuthor);
        */

/*

        DMZJTask DMZJTask = new DMZJTask();
        List<String[]> catgoryList = new ArrayList<>();
//        先爬2页试试
        catgoryList.add(new String[]{"搞笑","2","2"});
        for(String[] catgory : catgoryList){
            DMZJTask.run(catgory[0],catgory[1],catgory[2]);
        }
*/


        /*
        测试添加一条数据
        CaricatureService caricatureService = SpringManage.getBean(CaricatureService.class);
        MhReshourse mhReshourse = new MhReshourse();
        mhReshourse.setReId("test");
        Map map = new HashMap();
        map.put("test_key","test_valee");
        mhReshourse.setMap(map.toString());
        caricatureService.add(mhReshourse);
*/
    }
}
