package com.asiainfo.manydo.crawl.tool;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class MyWriteFile {

    BufferedWriter bf;

    public MyWriteFile(String path, String fileName)  {
        try {
            bf = new BufferedWriter(new FileWriter(path + "/" + fileName,true));
        }catch (Exception e){
            log.error(" new BufferedWriter fail !",e);
        }
    }

    public void write(String str) throws IOException {
        bf.write(str);
    }
    public void writeLine(String str) throws IOException {
        bf.write(str+"\r\n");
    }

    public void close() {
        if (bf != null) {
            try {
                bf.close();
            } catch (Exception e) {
                log.error("file close error", e);
            }
        }
    }




//    private Calendar cal = Calendar.getInstance();
//    private String date = ""+cal.get(Calendar.YEAR)+(cal.get(Calendar.MONTH)+1)+cal.get(Calendar.DATE);
//    /*
//    * 获取第一部分爬虫
//    * 正常解析的输出文件对象
//    * 返回一个 File对象？
//    * */
//    public File getCrawlOneWriteFile(CrawlInfoOne crawlInfoOne){
//        String fUrl =  crawlInfoOne.getFurl()+ crawlInfoOne.getWebSiteName()+"种子账号_"+date+".csv";//csv 文件
//        File file = new File(fUrl);
//        return file;
//    }
//
//    /*
//    * 获取第一部分爬虫
//    * 解析失败的输出文件对象
//    * 返回一个 File对象？
//    * */
//    public File getCrawlOneFailFile(CrawlInfoOne crawlInfoOne){
//        String fUrl =  crawlInfoOne.getFurl()+ crawlInfoOne.getWebSiteName()+"种子账号解析失败_"+date+".txt";//csv 文件
//        File file = new File(fUrl);
//        return file;
//    }

}
