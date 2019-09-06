package com.asiainfo.manydo.crawl.task;

public abstract class CrawlTask implements Runnable {

    public String formalTitleP(String strTitle){
        strTitle.replace("\""," ");
        strTitle.replace("|"," ");
        return strTitle;
    }
}
