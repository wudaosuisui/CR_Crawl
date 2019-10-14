package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import com.asiainfo.manydo.crawl.worktask.SougouWeixinTask;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;


/*
* 部署的 工作上的 程序，一般使用此 启动函数
* */

@Slf4j
public class CrMdCrawlApp {
    public static void main( String[] args ) {
        SpringManage.init();
        run();
//        runDMZJ();
//        test();
    }




    /**
     * 搜狗微信  爬取  高校 + 关键字
     * */
    public static void run() {


        SougouWeixinTask sougouWeixinTask = new SougouWeixinTask();
        String driverDir = "D:\\WorkShoft\\Chrome\\Application\\chromedriver.exe";
        Set<String> schools = new HashSet<>();
        Set<String> keys = new HashSet<>();

        Set<String> cSet = new HashSet<>();

        schools.add("北京大学");
        schools.add("南开大学");

//        1 - 10
        keys.add("道德");
        keys.add("德");
        keys.add("道德");
        keys.add("品德");
        keys.add("立德树人 高校 高等学校");
        keys.add("教育");
        keys.add("高等教育");
        keys.add("研究");
        keys.add("科研");
        keys.add("大学生");
        keys.add("研究生");
//        10 - 20
        keys.add("硕士");
        keys.add("博士");
        keys.add("博士后");
        keys.add("教师");
        keys.add("师生");
        keys.add("民族");
        keys.add("中华民族 青年 基层党组织");
        keys.add("思想");
        keys.add("政治");
        keys.add("思想政治 思政");
//        20 - 30
        keys.add("思政课");
        keys.add("复兴");
        keys.add("中国梦");
        keys.add("育人");
        keys.add("核心价值");
        keys.add("社会主义");
        keys.add("共产主义");
        keys.add("中国特色社会主义");
        keys.add("民族观");
        keys.add("国家观");
//        30 - 40
        keys.add("文化观");
        keys.add("世界观");
        keys.add("人生观");
        keys.add("价值观");
        keys.add("政治方向");
        keys.add("社会主义核心价值观");
        keys.add("爱国 爱党");
        keys.add("爱社会主义");
        keys.add("教育方针");
        keys.add("初心");
        keys.add("使命");
//        40 - 50
        keys.add("主题教育");
        keys.add("马克思主义");
        keys.add("群众路线");
        keys.add("民族");
        keys.add("革命");
        keys.add("理想");
        keys.add("人民");
        keys.add("谋");
        keys.add("担当");
        keys.add("服务");
//        50 - 60
        keys.add("新时代");
        keys.add("改革开放");
        keys.add("实事求是");
        keys.add("依法治国");
        keys.add("红船精神");
        keys.add("两个维护");
        keys.add("四个意识");
        keys.add(" 自信");
        keys.add("命运共同体");
        keys.add("素质");
//        60 - 70
        keys.add("修养");
        keys.add("党");
        keys.add("信仰");
        keys.add("信念");
        keys.add("意识形态");
        keys.add("理论");
        keys.add("育人");
        keys.add("德育");
        keys.add("培养");
        keys.add("文化");
//        70 - 80
        keys.add("习近平新时代中国特色社会主义思想");


//        循环 key
        for(String key : keys){
            cSet.add(key);
//            循环 school
            for(String school :schools){
                cSet.add(school);
//                循环 10 页
                for (int page = 1; page <= 1; page++) {
//                    进行访问处理
                    sougouWeixinTask.run(cSet, page,driverDir,null);
                }
                cSet.remove(school);
            }
            cSet.remove(key);
        }

    }



    /*
    * 新浪汽车
    * */
//    public static void run(){
//
//        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
//        JsoupExctrator jsoupExctrator = new JsoupExctrator();
//        String categoryUrl = "http://db.auto.sina.com.cn/list-0-1-0-0-0-0-0-0-9-0-1.html";
//        log.info(httpClientFetcher.sendCallUrl(categoryUrl));
//
////        SinaCar sinaCar = new SinaCar();
////        List<String[]> catgoryList = new ArrayList<>();
//////        new String[]{"入口url","类型名称"}
////        catgoryList.add(new String[]{"http://db.auto.sina.com.cn/list-0-1-0-0-0-0-0-0-9-0-1.html","两厢"});
////
////        for(String[] catgory : catgoryList){
////            sinaCar.run(catgory[0],catgory[1]);
////        }
//    }

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
