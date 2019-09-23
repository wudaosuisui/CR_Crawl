package com.asiainfo.manydo.crawl.worktask;

public abstract class CrawlTask implements Runnable {

    public String formalStrP(String strTitle){
//        strTitle.replace("\""," ");
//        strTitle.replace("|"," ");
        return strTitle.replace("|"," ").replace("\""," ");
    }
}
