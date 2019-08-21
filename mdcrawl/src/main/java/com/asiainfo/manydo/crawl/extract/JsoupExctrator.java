package com.asiainfo.manydo.crawl.extract;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupExctrator  implements Exctrator {

    private Document doc;

    @Override
    public void init(String html) {
        doc = Jsoup.parse(html);
    }

    @Override
    public String select(String cssQuery) {
        return doc.select(cssQuery).text();
    }

    public  Elements selectElements(String cssQuery){
        return doc.select(cssQuery);
    }

    public String selectStringByElementTxt(Element element,String cssQuery){
        return element.select(cssQuery).text();
    }
    public String selectStringByElementAttr(Element element,String cssQuery,String attr){
        return element.select(cssQuery).attr(attr);
    }
    public  Element selectElement(String cssQuery){
        return doc.select(cssQuery).get(1);
    }

    public String selectById(String id) {
        return doc.select("div[id="+id+"]").toString();
    }

    public String selectGetTest(){
        Elements elements = doc.select("div[id=iqiyi-main]");
        Element div = elements.select("div").get(1);
        String page_info = div.attr(":page-info");
        return page_info;
    }

    public List<String []> selectGetTest2(){
        List<String[]> list = new ArrayList<>();
        Elements ul = doc.select("#widget-tab-3 > div.piclist-wrapper > div > ul");
        Elements li = ul.get(0).select("li");

        for(Element element:li){
            String url = element.select("div.site-piclist_pic > a").attr("href");
            String title = element.select("div.site-piclist_info > p.site-piclist_info_title > a").text();
            String[] str = new String[2];
            str[0] = title;
            str[1] ="https:"+url;
            list.add(str);
        }



//        String li0 = li.get(0).toString();
//        Map map = new HashMap();
//        map.put("li0",li0);
//        Map map2 = new HashMap();
//        map2.put("li_size",li.size());
//        list.add(map);
//        list.add(map2);
        return list;
    }

    @Override
    public String selectUrl(String cssQuery) {
        return doc.select(cssQuery).get(0).attr("href");
    }
//
//    public String selectById(String id) {
//        return doc.select(id).text();
//    }
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
