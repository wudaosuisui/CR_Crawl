package com.asiainfo.manydo.crawl.extract;

import lombok.extern.slf4j.Slf4j;

/*
* 工厂应该是单例模式的 ！
* */
@Slf4j
public class ExctratorFactory {

    private static ExctratorFactory exctratorFactory = new ExctratorFactory();

    public static ExctratorFactory getInstance() {
        return exctratorFactory;
    }

    /*
    * 输入关键字 获取对应解析器
    * */
    public  static Exctrator getExctrator(String excName){
        switch(excName)
        {
            case "JsonExctrator" :
                return new JsonExctrator();
            case "JsoupExctrator" :
                return new JsoupExctrator();
            default :
                log.error(" excName is Wrong : "+ excName);
                return null;
        }

//        if(excName.equals("JsonExctrator")){
//            return  new JsonExctrator();
//        }else if(excName.equals("JsoupExctrator")){
//            return  new JsoupExctrator();
//        }else{
//            return null;
//        }

//        if(excName.indexOf("Json")>0){
//            return  new JsonExctrator();
//        }else if(excName.indexOf("Jsoup")>0){
//            return  new JsoupExctrator();
//        }else{
//            return null;
//        }
    }

}
