package com.asiainfo.manydo.crawl.main;

import com.asiainfo.manydo.crawl.dao.pojo.WeChatSubscription;
import com.asiainfo.manydo.crawl.extract.JsoupExctrator;
import com.asiainfo.manydo.crawl.fetcher.HttpClientFetcher;
import com.asiainfo.manydo.crawl.service.WeChatService;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import com.asiainfo.manydo.crawl.worktask.SougouWeixinTask;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
* 编写代码时 用于测试的启动函数
* */
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
        String categoryUrl = "http://product.dangdang.com/1325201189.html";
//        jsoupExctrator.init(httpClientFetcher.sendGetRequest(categoryUrl));
        log.info(httpClientFetcher.sendGetRequest(categoryUrl));

    }

    public static void test(){

        String key = "rere asfsf";
        if(key.contains(" ")){
            key = key.replace(" ","%20");
        }
        log.info(key);
//        搜狗微信  爬取  高校 + 关键字
//
//        SougouWeixinTask sougouWeixinTask = new SougouWeixinTask();
//        String driverDir = "D:\\WorkShoft\\Chrome\\Application\\chromedriver.exe";
//        Set<String> schools = new HashSet<>();
//        Set<String> keys = new HashSet<>();
//
//        Set<String> cSet = new HashSet<>();
//
//        schools.add("北京大学");
//        schools.add("南开大学");
//
//        keys.add("道德");
//        keys.add("德");
//        keys.add("道德");
//        keys.add("品德");
//        keys.add("立德树人 高校 高等学校");
//        keys.add("教育");
//        keys.add("高等教育");
//        keys.add("研究");
//        keys.add("科研");
//        keys.add("大学生");
//        keys.add("研究生");
//        keys.add("硕士");
//        keys.add("博士");
//        keys.add("博士后");
//        keys.add("教师");
//        keys.add("师生");
//        keys.add("民族");
//        keys.add("中华民族 青年 基层党组织");
//        keys.add("思想");
//        keys.add("政治");
//        keys.add("思想政治 思政");
//        keys.add("思政课");
//        keys.add("复兴");
//        keys.add("中国梦");
//        keys.add("育人");
//        keys.add("核心价值");
//        keys.add("社会主义");
//        keys.add("共产主义");
//        keys.add("中国特色社会主义");
//        keys.add("民族观");
//        keys.add("国家观");
//        keys.add("文化观");
//        keys.add("世界观");
//        keys.add("人生观");
//        keys.add("价值观");
//        keys.add("政治方向");
//        keys.add("社会主义核心价值观");
//        keys.add("爱国 爱党");
//        keys.add("爱社会主义");
//        keys.add("教育方针");
//        keys.add("初心");
//        keys.add("使命");
//        keys.add("主题教育");
//        keys.add("马克思主义");
//        keys.add("群众路线");
//        keys.add("民族");
//        keys.add("革命");
//        keys.add("理想");
//        keys.add("人民");
//        keys.add("谋");
//        keys.add("担当");
//        keys.add("服务");
//        keys.add("新时代");
//        keys.add("改革开放");
//        keys.add("实事求是");
//        keys.add("依法治国");
//        keys.add("红船精神");
//        keys.add("两个维护");
//        keys.add("四个意识");
//        keys.add(" 自信");
//        keys.add("命运共同体");
//        keys.add("素质");
//        keys.add("修养");
//        keys.add("党");
//        keys.add("信仰");
//        keys.add("信念");
//        keys.add("意识形态");
//        keys.add("理论");
//        keys.add("育人");
//        keys.add("德育");
//        keys.add("培养");
//        keys.add("文化");
//        keys.add("习近平新时代中国特色社会主义思想");
//
//
////        循环 key
//        for(String key : keys){
//            cSet.add(key);
////            循环 school
//            for(String school :schools){
//                cSet.add(school);
////                循环 10 页
//                for (int page = 1; page <= 1; page++) {
////                    进行访问处理
//                    sougouWeixinTask.run(cSet, page,driverDir,null);
//                }
//                cSet.remove(school);
//            }
//            cSet.remove(key);
//        }

//        for (int i = 1; i <= 10; i++) {
//
////            sougouWeixinTask.run(Url + i + "&ie=utf8&w=01019900&dr=1", i);
//
//        }



//        System.out.print(new Date());
//        WeChatService weChatService = SpringManage.getBean(WeChatService.class);
////        weChatService.addMassage("testurl","testmassage");
//        WeChatSubscription weChatSubscription = new WeChatSubscription();
//        weChatSubscription.setKeyword("test");
//        weChatSubscription.setTimeStamp(new Date());
//        weChatService.addWeChat(weChatSubscription);


//        SougouWeixinTask sougouWeixinTask = new SougouWeixinTask();
//        String Url = "https://weixin.sogou.com/weixin?query=%E5%8C%97%E4%BA%AC%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6+%E9%81%93%E5%BE%B7&_sug_type_=&sut=24552&lkt=1%2C1569466179086%2C1569466179086&s_from=input&_sug_=y&type=2&sst0=1569466203385&page=";
////        sougouWeixinTask.run("https://weixin.sogou.com/weixin?query=%E5%8C%97%E4%BA%AC%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6+%E9%81%93%E5%BE%B7&_sug_type_=&sut=24552&lkt=1%2C1569466179086%2C1569466179086&s_from=input&_sug_=y&type=2&sst0=1569466203385&page=4&ie=utf8&w=01019900&dr=1");
//        for(int i = 1 ;i<=10 ;i++){
//            sougouWeixinTask.run(Url+i+"&ie=utf8&w=01019900&dr=1",i);
//        }

/*

        客户识别 9月20日 当当网

        DangDangTask dangDangTask = new DangDangTask();
        List<String> urlList = new ArrayList();

        urlList.add("http://product.dangdang.com/25583206.html");
        urlList.add("http://product.dangdang.com/25259300.html");
        urlList.add("http://product.dangdang.com/1083331798.html");
        urlList.add("http://product.dangdang.com/23785047.html");
        urlList.add("http://product.dangdang.com/26490464.html");
        urlList.add("http://product.dangdang.com/27892079.html");
        urlList.add("http://product.dangdang.com/23457691.html");
        urlList.add("http://product.dangdang.com/25247638.html");
        urlList.add("http://product.dangdang.com/27872267.html");
        urlList.add("http://product.dangdang.com/25308985.html");
        urlList.add("http://product.dangdang.com/26488584.html");
        urlList.add("http://product.dangdang.com/25259300.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/1513619479.html");
        urlList.add("http://product.dangdang.com/27904794.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/25259300.html");
        urlList.add("http://product.dangdang.com/1419396625.html");
        urlList.add("http://product.dangdang.com/1513619469.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/25583206.html");
        urlList.add("http://product.dangdang.com/25247638.html");
        urlList.add("http://product.dangdang.com/23778791.html");
        urlList.add("http://product.dangdang.com/25247638.html");
        urlList.add("http://product.dangdang.com/27854458.html");
        urlList.add("http://product.dangdang.com/27878722.html");
        urlList.add("http://product.dangdang.com/26482571.html");
        urlList.add("http://product.dangdang.com/25259300.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/27878722.html");
        urlList.add("http://product.dangdang.com/23761145.html");
        urlList.add("http://product.dangdang.com/24156030.html");
        urlList.add("http://product.dangdang.com/27871865.html");
        urlList.add("http://product.dangdang.com/27878722.html");
        urlList.add("http://product.dangdang.com/27871448.html");
        urlList.add("http://product.dangdang.com/25247638.html");
        urlList.add("http://product.dangdang.com/25126128.html");
        urlList.add("http://product.dangdang.com/1396442730.html");
        urlList.add("http://product.dangdang.com/27872267.html");
        urlList.add("http://product.dangdang.com/26923356.html");
        urlList.add("http://product.dangdang.com/23761145.html");
        urlList.add("http://product.dangdang.com/27871448.html");
        urlList.add("http://product.dangdang.com/26488584.html");
        urlList.add("http://product.dangdang.com/23444350.html");
        urlList.add("http://product.dangdang.com/25238195.html");
        urlList.add("http://product.dangdang.com/1083331798.html");
        urlList.add("http://product.dangdang.com/25259300.html");
        urlList.add("http://product.dangdang.com/26488584.html");
        urlList.add("http://product.dangdang.com/26916944.html");
        urlList.add("http://product.dangdang.com/25289538.html");
        urlList.add("http://product.dangdang.com/26488584.html");
        urlList.add("http://product.dangdang.com/25137790.html");
        urlList.add("http://product.dangdang.com/25323113.html");
        urlList.add("http://product.dangdang.com/26916944.html");
        urlList.add("http://product.dangdang.com/25126128.html");
        urlList.add("http://product.dangdang.com/1083360098.html");
        urlList.add("http://product.dangdang.com/27891222.html");
        urlList.add("http://product.dangdang.com/1444703727.html");
        urlList.add("http://product.dangdang.com/25259300.html");
        urlList.add("http://product.dangdang.com/1419396625.html");
        urlList.add("http://product.dangdang.com/25247638.html");
        urlList.add("http://product.dangdang.com/1513619469.html");
        urlList.add("http://product.dangdang.com/26923356.html");
        urlList.add("http://product.dangdang.com/26916944.html");
        urlList.add("http://product.dangdang.com/26482571.html");
        urlList.add("http://product.dangdang.com/23785047.html");
        urlList.add("http://product.dangdang.com/23785047.html");
        urlList.add("http://product.dangdang.com/27871448.html");
        urlList.add("http://product.dangdang.com/1513760138.html");
        urlList.add("http://product.dangdang.com/1471660627.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/1523416292.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/1419393325.html");
        urlList.add("http://product.dangdang.com/23716798.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/25284154.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/25181620.html");
        urlList.add("http://product.dangdang.com/26914924.html");
        urlList.add("http://product.dangdang.com/27847515.html");
        urlList.add("http://product.dangdang.com/26482572.html");
        urlList.add("http://product.dangdang.com/1083360098.html");
        urlList.add("http://product.dangdang.com/25138856.html");
        urlList.add("http://product.dangdang.com/23457691.html");
        urlList.add("http://product.dangdang.com/27885398.html");
        urlList.add("http://product.dangdang.com/25332466.html");
        urlList.add("http://product.dangdang.com/1329217947.html");
        urlList.add("http://product.dangdang.com/21086025.html");
        urlList.add("http://product.dangdang.com/1509606234.html");
        urlList.add("http://product.dangdang.com/26488584.html");
        urlList.add("http://product.dangdang.com/27893366.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/24105221.html");
        urlList.add("http://product.dangdang.com/26482572.html");
        urlList.add("http://product.dangdang.com/27904794.html");
        urlList.add("http://product.dangdang.com/24156030.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/24244860.html");

        urlList.add("http://product.dangdang.com/27904241.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/26914924.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/27878160.html");
        urlList.add("http://product.dangdang.com/1271047687.html");
        urlList.add("http://product.dangdang.com/1329217947.html");
        urlList.add("http://product.dangdang.com/463785.html");
        urlList.add("http://product.dangdang.com/25181620.html");
        urlList.add("http://product.dangdang.com/27878722.html");
        urlList.add("http://product.dangdang.com/1509606234.html");
        urlList.add("http://product.dangdang.com/25289538.html");
        urlList.add("http://product.dangdang.com/27904495.html");
        urlList.add("http://product.dangdang.com/23761145.html");
        urlList.add("http://product.dangdang.com/27872267.html");
        urlList.add("http://product.dangdang.com/27871865.html");
        urlList.add("http://product.dangdang.com/25284154.html");
        urlList.add("http://product.dangdang.com/1509606234.html");
        urlList.add("http://product.dangdang.com/25138856.html");
        urlList.add("http://product.dangdang.com/25238195.html");
        urlList.add("http://product.dangdang.com/26916944.html");
        urlList.add("http://product.dangdang.com/23716798.html");
        urlList.add("http://product.dangdang.com/23457691.html");
        urlList.add("http://product.dangdang.com/27880773.html");
        urlList.add("http://product.dangdang.com/25119332.html");
        urlList.add("http://product.dangdang.com/1083360098.html");
        urlList.add("http://product.dangdang.com/25126128.html");
        urlList.add("http://product.dangdang.com/1513619489.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/1018361210.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/23457691.html");
        urlList.add("http://product.dangdang.com/24041704.html");
        urlList.add("http://product.dangdang.com/25126128.html");
        urlList.add("http://product.dangdang.com/23457691.html");
        urlList.add("http://product.dangdang.com/26921715.html");
        urlList.add("http://product.dangdang.com/1409828625.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/25142121.html");
        urlList.add("http://product.dangdang.com/25180441.html");
        urlList.add("http://product.dangdang.com/25119332.html");
        urlList.add("http://product.dangdang.com/23785047.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/25138856.html");
        urlList.add("http://product.dangdang.com/25137790.html");
        urlList.add("http://product.dangdang.com/25137790.html");
        urlList.add("http://product.dangdang.com/25138856.html");
        urlList.add("http://product.dangdang.com/1513632599.html");
        urlList.add("http://product.dangdang.com/27891222.html");
        urlList.add("http://product.dangdang.com/26909802.html");
        urlList.add("http://product.dangdang.com/27904794.html");
        urlList.add("http://product.dangdang.com/27882865.html");
        urlList.add("http://product.dangdang.com/23444350.html");
        urlList.add("http://product.dangdang.com/23444350.html");
        urlList.add("http://product.dangdang.com/25301747.html");
        urlList.add("http://product.dangdang.com/23566280.html");
        urlList.add("http://product.dangdang.com/25323113.html");
        urlList.add("http://product.dangdang.com/26921715.html");
        urlList.add("http://product.dangdang.com/1329217947.html");
        urlList.add("http://product.dangdang.com/26923356.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/1419394125.html");
        urlList.add("http://product.dangdang.com/1412761225.html");
        urlList.add("http://product.dangdang.com/27880773.html");
        urlList.add("http://product.dangdang.com/26482571.html");
        urlList.add("http://product.dangdang.com/25137790.html");
        urlList.add("http://product.dangdang.com/27878160.html");
        urlList.add("http://product.dangdang.com/26921715.html");
        urlList.add("http://product.dangdang.com/25536856.html");
        urlList.add("http://product.dangdang.com/25336319.html");
        urlList.add("http://product.dangdang.com/1083353598.html");
        urlList.add("http://product.dangdang.com/1419394125.html");
        urlList.add("http://product.dangdang.com/25332466.html");
        urlList.add("http://product.dangdang.com/24041704.html");
        urlList.add("http://product.dangdang.com/1419393425.html");
        urlList.add("http://product.dangdang.com/25138856.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/27867305.html");
        urlList.add("http://product.dangdang.com/27868279.html");
        urlList.add("http://product.dangdang.com/27880773.html");
        urlList.add("http://product.dangdang.com/27882865.html");
        urlList.add("http://product.dangdang.com/23751637.html");
        urlList.add("http://product.dangdang.com/1513632599.html");
        urlList.add("http://product.dangdang.com/24105221.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/23785047.html");
        urlList.add("http://product.dangdang.com/23751637.html");
        urlList.add("http://product.dangdang.com/27867305.html");
        urlList.add("http://product.dangdang.com/25220925.html");
        urlList.add("http://product.dangdang.com/23778791.html");
        urlList.add("http://product.dangdang.com/23691200.html");
        urlList.add("http://product.dangdang.com/24041704.html");
        urlList.add("http://product.dangdang.com/27904241.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/23691200.html");
        urlList.add("http://product.dangdang.com/1501468051.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/27879058.html");
        urlList.add("http://product.dangdang.com/24156030.html");
        urlList.add("http://product.dangdang.com/1513632599.html");
        urlList.add("http://product.dangdang.com/23566280.html");
        urlList.add("http://product.dangdang.com/25328588.html");
        urlList.add("http://product.dangdang.com/25180441.html");
        urlList.add("http://product.dangdang.com/27892079.html");
        urlList.add("http://product.dangdang.com/27854458.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/27878160.html");
        urlList.add("http://product.dangdang.com/27871865.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/25308985.html");
        urlList.add("http://product.dangdang.com/25247638.html");
        urlList.add("http://product.dangdang.com/1396442730.html");
        urlList.add("http://product.dangdang.com/27847515.html");
        urlList.add("http://product.dangdang.com/1419394125.html");
        urlList.add("http://product.dangdang.com/1412761225.html");
        urlList.add("http://product.dangdang.com/25126128.html");
        urlList.add("http://product.dangdang.com/27882865.html");
        urlList.add("http://product.dangdang.com/25536856.html");
        urlList.add("http://product.dangdang.com/26515681.html");
        urlList.add("http://product.dangdang.com/25180441.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/24156030.html");
        urlList.add("http://product.dangdang.com/24175371.html");
        urlList.add("http://product.dangdang.com/26923356.html");
        urlList.add("http://product.dangdang.com/23445575.html");
        urlList.add("http://product.dangdang.com/27878722.html");
        urlList.add("http://product.dangdang.com/26515681.html");
        urlList.add("http://product.dangdang.com/25308985.html");
        urlList.add("http://product.dangdang.com/23990140.html");
        urlList.add("http://product.dangdang.com/25238195.html");
        urlList.add("http://product.dangdang.com/26490464.html");
        urlList.add("http://product.dangdang.com/1444703727.html");
        urlList.add("http://product.dangdang.com/23761145.html");
        urlList.add("http://product.dangdang.com/24198400.html");
        urlList.add("http://product.dangdang.com/1419396625.html");
        urlList.add("http://product.dangdang.com/25206708.html");
        urlList.add("http://product.dangdang.com/23566280.html");
        urlList.add("http://product.dangdang.com/1444703627.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/1513619469.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/25238195.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/24026212.html");
        urlList.add("http://product.dangdang.com/1396442730.html");
        urlList.add("http://product.dangdang.com/24156030.html");
        urlList.add("http://product.dangdang.com/26490464.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/27871865.html");
        urlList.add("http://product.dangdang.com/25308985.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/27851155.html");
        urlList.add("http://product.dangdang.com/26515681.html");
        urlList.add("http://product.dangdang.com/1396442730.html");
        urlList.add("http://product.dangdang.com/1513619469.html");
        urlList.add("http://product.dangdang.com/25213190.html");
        urlList.add("http://product.dangdang.com/1396442730.html");
        urlList.add("http://product.dangdang.com/1325201189.html");
        urlList.add("http://product.dangdang.com/25301747.html");
        urlList.add("http://product.dangdang.com/23691200.html");
        urlList.add("http://product.dangdang.com/27904241.html");
        urlList.add("http://product.dangdang.com/25236263.html");
        urlList.add("http://product.dangdang.com/24198400.html");
        urlList.add("http://product.dangdang.com/27895103.html");
        urlList.add("http://product.dangdang.com/23691200.html");
        urlList.add("http://product.dangdang.com/25124059.html");
        urlList.add("http://product.dangdang.com/26490464.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/26922482.html");
        urlList.add("http://product.dangdang.com/26923356.html");
        urlList.add("http://product.dangdang.com/25272807.html");
        urlList.add("http://product.dangdang.com/25583206.html");
        urlList.add("http://product.dangdang.com/27897936.html");
        urlList.add("http://product.dangdang.com/1514415429.html");
        urlList.add("http://product.dangdang.com/27893366.html");
        urlList.add("http://product.dangdang.com/23691200.html");
        urlList.add("http://product.dangdang.com/27854458.html");
        urlList.add("http://product.dangdang.com/1513632609.html");
        urlList.add("http://product.dangdang.com/1325201189.html");
        urlList.add("http://product.dangdang.com/27851155.html");
        urlList.add("http://product.dangdang.com/25308985.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/24026212.html");
        urlList.add("http://product.dangdang.com/27883500.html");
        urlList.add("http://product.dangdang.com/23464478.html");
        urlList.add("http://product.dangdang.com/27891222.html");
        urlList.add("http://product.dangdang.com/24198400.html");
        urlList.add("http://product.dangdang.com/1504044618.html");
        urlList.add("http://product.dangdang.com/26482572.html");
        urlList.add("http://product.dangdang.com/25124059.html");
        urlList.add("http://product.dangdang.com/27847515.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/27878160.html");
        urlList.add("http://product.dangdang.com/25124059.html");
        urlList.add("http://product.dangdang.com/1501468041.html");
        urlList.add("http://product.dangdang.com/26482572.html");
        urlList.add("http://product.dangdang.com/27904794.html");
        urlList.add("http://product.dangdang.com/1419432825.html");
        urlList.add("http://product.dangdang.com/20039611.html");
        urlList.add("http://product.dangdang.com/1325201189.html");
        urlList.add("http://product.dangdang.com/25181620.html");
        urlList.add("http://product.dangdang.com/27880773.html");
        urlList.add("http://product.dangdang.com/27854458.html");
        urlList.add("http://product.dangdang.com/23566280.html");
        urlList.add("http://product.dangdang.com/21086025.html");
        urlList.add("http://product.dangdang.com/27880773.html");
        urlList.add("http://product.dangdang.com/23835390.html");
        urlList.add("http://product.dangdang.com/23990140.html");
        urlList.add("http://product.dangdang.com/27904794.html");
        urlList.add("http://product.dangdang.com/1419393425.html");
        urlList.add("http://product.dangdang.com/27868279.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/25289538.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/26515681.html");
        urlList.add("http://product.dangdang.com/23579654.html");
        urlList.add("http://product.dangdang.com/25142121.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/27885398.html");
        urlList.add("http://product.dangdang.com/1444703627.html");
        urlList.add("http://product.dangdang.com/25252408.html");
        urlList.add("http://product.dangdang.com/27895103.html");
        urlList.add("http://product.dangdang.com/25124059.html");
        urlList.add("http://product.dangdang.com/24105221.html");
        urlList.add("http://product.dangdang.com/25138856.html");
        urlList.add("http://product.dangdang.com/26923356.html");
        urlList.add("http://product.dangdang.com/25301747.html");
        urlList.add("http://product.dangdang.com/25220925.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/25332466.html");
        urlList.add("http://product.dangdang.com/27867305.html");
        urlList.add("http://product.dangdang.com/1513632609.html");
        urlList.add("http://product.dangdang.com/23444350.html");
        urlList.add("http://product.dangdang.com/25308985.html");
        urlList.add("http://product.dangdang.com/23444350.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/25119332.html");
        urlList.add("http://product.dangdang.com/27880025.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/1513632599.html");
        urlList.add("http://product.dangdang.com/24144615.html");
        urlList.add("http://product.dangdang.com/27878722.html");
        urlList.add("http://product.dangdang.com/1485472785.html");
        urlList.add("http://product.dangdang.com/1399671724.html");
        urlList.add("http://product.dangdang.com/25298374.html");
        urlList.add("http://product.dangdang.com/27905656.html");
        urlList.add("http://product.dangdang.com/27892021.html");
        urlList.add("http://product.dangdang.com/1449761223.html");
        urlList.add("http://product.dangdang.com/22783643.html");
        urlList.add("http://product.dangdang.com/25260395.html");
        urlList.add("http://product.dangdang.com/23909227.html");
        urlList.add("http://product.dangdang.com/23204520.html");
        urlList.add("http://product.dangdang.com/25478395.html");
        urlList.add("http://product.dangdang.com/26439803.html");
        urlList.add("http://product.dangdang.com/26922482.html");
        urlList.add("http://product.dangdang.com/25243843.html");
        urlList.add("http://product.dangdang.com/1511521452.html");
        urlList.add("http://product.dangdang.com/26439803.html");
        urlList.add("http://product.dangdang.com/1429041204.html");
        urlList.add("http://product.dangdang.com/22819334.html");
        urlList.add("http://product.dangdang.com/25278075.html");
        urlList.add("http://product.dangdang.com/25236263.html");
        urlList.add("http://product.dangdang.com/23513375.html");
        urlList.add("http://product.dangdang.com/25211578.html");
        urlList.add("http://product.dangdang.com/26486620.html");
        urlList.add("http://product.dangdang.com/27880909.html");
        urlList.add("http://product.dangdang.com/23720715.html");
        urlList.add("http://product.dangdang.com/1419394225.html");
        urlList.add("http://product.dangdang.com/27860488.html");
        urlList.add("http://product.dangdang.com/25478395.html");
        urlList.add("http://product.dangdang.com/1310072399.html");
        urlList.add("http://product.dangdang.com/23417701.html");
        urlList.add("http://product.dangdang.com/23271503.html");
        urlList.add("http://product.dangdang.com/25149907.html");
        urlList.add("http://product.dangdang.com/26439803.html");
        urlList.add("http://product.dangdang.com/1018361210.html");
        urlList.add("http://product.dangdang.com/26513230.html");
        urlList.add("http://product.dangdang.com/0.html");
        urlList.add("http://product.dangdang.com/25261323.html");
        urlList.add("http://product.dangdang.com/23645623.html");
        urlList.add("http://product.dangdang.com/25173688.html");
        urlList.add("http://product.dangdang.com/25216727.html");
        urlList.add("http://product.dangdang.com/1250968014.html");
        urlList.add("http://product.dangdang.com/25171016.html");
        urlList.add("http://product.dangdang.com/24030562.html");
        urlList.add("http://product.dangdang.com/25234508.html");
        urlList.add("http://product.dangdang.com/27855831.html");
        urlList.add("http://product.dangdang.com/1500781207.html");
        urlList.add("http://product.dangdang.com/1500781207.html");
        urlList.add("http://product.dangdang.com/25137790.html");
        urlList.add("http://product.dangdang.com/25259168.html");
        urlList.add("http://product.dangdang.com/23593354.html");
        urlList.add("http://product.dangdang.com/25536535.html");
        urlList.add("http://product.dangdang.com/26482259.html");
        urlList.add("http://product.dangdang.com/25259302.html");
        urlList.add("http://product.dangdang.com/27892079.html");
        urlList.add("http://product.dangdang.com/1172294919.html");

        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?acce.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");
        urlList.add("http://mapi7.dangdang.com/index.php?a=we.html");

        for(String url : urlList) {
            dangDangTask.run(url);
            log.info("craw url :"+url);
        }
*/

        /*
        HttpClientFetcher httpClientFetcher = new HttpClientFetcher();
        JsoupExctrator jsoupExctrator = new JsoupExctrator();
        String categoryUrl = "http://db.auto.sina.com.cn/list-0-1-0-0-0-0-0-0-9-0-1.html";
        log.info(httpClientFetcher.sendCallUrl(categoryUrl));


//        jsoupExctrator.init(httpClientFetcher.sendGetRequest(categoryUrl));
//        log.info(jsoupExctrator.select("#J_motoDataMain > div.content > div.y-tuku235.seek-list > ul > li:nth-child(1)"));
*/
/*

        SinaCar sinaCar = new SinaCar();
        List<String[]> catgoryList = new ArrayList<>();
//        new String[]{"入口url","类型名称"}
        catgoryList.add(new String[]{"http://db.auto.sina.com.cn/list-0-1-0-0-0-0-0-0-9-0-1.html","两厢"});

        for(String[] catgory : catgoryList){
            sinaCar.run(catgory[0],catgory[1]);
        }
*/


/*
2019年9月5日 19点32分

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


//布卡漫画 按照分类抓取
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

// 动漫之家 爬取测试

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
