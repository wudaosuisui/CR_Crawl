package com.asiainfo.manydo.crawl.dao.pojo;

import java.util.Date;

public class ErrorMassage {
    private Integer id;

    private String webName;

    private String url;

    private String massage;

    private Date timeStamp;

    public ErrorMassage() {
    }

    public ErrorMassage(String webName, String url, String massage, Date timeStamp) {
        this.webName = webName;
        this.url = url;
        this.massage = massage;
        this.timeStamp = timeStamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName == null ? null : webName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage == null ? null : massage.trim();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}