package com.asiainfo.manydo.crawl.dao.pojo;

public class MhReshourse {
    private Integer id;

    private String reId;

    private String map;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReId() {
        return reId;
    }

    public void setReId(String reId) {
        this.reId = reId == null ? null : reId.trim();
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map == null ? null : map.trim();
    }

    public MhReshourse() {
    }

    public MhReshourse(String reId, String map) {
        this.reId = reId;
        this.map = map;
    }
}