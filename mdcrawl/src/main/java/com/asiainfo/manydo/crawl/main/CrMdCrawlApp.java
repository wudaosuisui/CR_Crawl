package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.dao.pojo.SysUser;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.SysUserService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import com.asiainfo.manydo.crawl.task.BuKaTask;
import com.asiainfo.manydo.crawl.task.DMZJTask;
import com.asiainfo.manydo.crawl.task.SinaCar;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CrMdCrawlApp {
    public static void main( String[] args ) {
        SpringManage.init();
        run();
//        runDMZJ();
//        test();
    }

    /*
    * 新浪汽车
    * */
    public static void run(){
        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
        JsoupExctrator jsoupExctrator = new JsoupExctrator();
        String categoryUrl = "http://db.auto.sina.com.cn/list-0-1-0-0-0-0-0-0-9-0-1.html";
        log.info(httpClientFetcher.sendCallUrl(categoryUrl));

//        SinaCar sinaCar = new SinaCar();
//        List<String[]> catgoryList = new ArrayList<>();
////        new String[]{"入口url","类型名称"}
//        catgoryList.add(new String[]{"http://db.auto.sina.com.cn/list-0-1-0-0-0-0-0-0-9-0-1.html","两厢"});
//
//        for(String[] catgory : catgoryList){
//            sinaCar.run(catgory[0],catgory[1]);
//        }
    }

    /*
    * 布卡漫画爬取程序
    * */
//    public static void run(){
//
////        布卡漫画
////        22 个分类
//        BuKaTask buKaTask = new BuKaTask();
//        List<String[]> catgoryList = new ArrayList<>();
//
////        new String[]{"入口url","类型名称"}
////        catgoryList.add(new String[]{"http://www.buka.cn/news/","最近更新"});
////        catgoryList.add(new String[]{"http://www.buka.cn/ranking/","今日热榜"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/12128/付费漫画/","付费漫画"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/12084/最近上新/","最近上新"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/303/经典/","经典"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/12033/联合出品/","联合出品"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/12036/条漫/","条漫"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/206/百合/","百合"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/12009/肥皂/","肥皂"});
////        catgoryList.add(new String[]{"http://www.buka.cn/category/12041/玄幻/","玄幻"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12116/霸道总裁/","霸道总裁"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/404/恋爱/","恋爱"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12091/用户原创/","用户原创"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12018/游戏/","游戏"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/202/治愈/","治愈"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/403/科幻/","科幻"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/10008/搞笑/","搞笑"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12023/励志/","励志"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/410/格斗/","格斗"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12103/少女漫/","少女漫"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12104/少年漫/","少年漫"});
//        catgoryList.add(new String[]{"http://www.buka.cn/category/12117/真人漫/","真人漫"});
//
//        for(String[] catgory : catgoryList){
//            buKaTask.run(catgory[0],catgory[1]);
//        }
//
////        DMZJTask DMZJTask = new DMZJTask();
////        List<String[]> catgoryList2 = new ArrayList<>();
////        catgoryList2.add(new String[]{"其他","24","781"});
////
////        for(String[] catgory : catgoryList2){
////            DMZJTask.run(catgory[0],catgory[1],catgory[2]);
////        }
//    }

    /*
    * 动漫之家 爬取程序
    * */
//    public static void runDMZJ(){
//
////        url : https://www.dmzj.com/category/0-0-0-2-0-0-1.html
////        注 2 是分类   1  是页码
//
//        DMZJTask DMZJTask = new DMZJTask();
//        List<String[]> catgoryList = new ArrayList<>();
//
////        new String[]{"类型名称","类型代码","最大页数"}
//        catgoryList.add(new String[]{"冒险","1","62"});
//        catgoryList.add(new String[]{"搞笑","2","4"});
//        catgoryList.add(new String[]{"格斗","3","26"});
//        catgoryList.add(new String[]{"科幻","4","22"});
////        137
//        catgoryList.add(new String[]{"爱情","5","44"});
//        catgoryList.add(new String[]{"侦探","6","4"});
//        catgoryList.add(new String[]{"竞技","7","5"});
//        catgoryList.add(new String[]{"魔法","8","18"});
//        catgoryList.add(new String[]{"校园","9","33"});
//        catgoryList.add(new String[]{"百合","11","7"});
////        catgoryList.add(new String[]{"耽美","13","0"});
//        catgoryList.add(new String[]{"历史","14","15"});
//        catgoryList.add(new String[]{"战争","15","12"});
//        catgoryList.add(new String[]{"宅系","16","3"});
//        catgoryList.add(new String[]{"治愈","17","35"});
//        catgoryList.add(new String[]{"仙侠","18","8"});
//        catgoryList.add(new String[]{"武侠","19","7"});
//        catgoryList.add(new String[]{"职场","20","6"});
//        catgoryList.add(new String[]{"鬼神","21","6"});
//        catgoryList.add(new String[]{"奇幻","22","39"});
//        catgoryList.add(new String[]{"生活","23","45"});
//        catgoryList.add(new String[]{"其他","24","781"});
//
//
//
//        for(String[] catgory : catgoryList){
//            DMZJTask.run(catgory[0],catgory[1],catgory[2]);
//        }
//
//
//    }

//    public static void test(){
//
//        String url = "http://music.migu.cn/v3/music/playlist?tagId=1000001672";
//        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
//        log.info(" str : ");
//        log.info(httpClientFetcher.sendGetRequest(url));
//        /*
//        MongoDB 存储测试成功
//        且 在同一个 Service 中  存储的 同一个实体类
//
//        SysUserService sysUserService = SpringManage.getBean(SysUserService.class);
//        SysUser sysUser = new SysUser();
//        sysUser.setRealName("testRealName");
//        sysUserService.addMon(sysUser);
//        */
//        /*
//        MySQL 存储测试成功
//
//        SysUserService sysUserService = SpringManage.getBean(SysUserService.class);
//        SysUser sysUser = new SysUser();
//        sysUser.setRealName("testRealName");
//        sysUserService.add(sysUser);
//        */
//    }
}
