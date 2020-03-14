package com.asiainfo.cr.crawl.store.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

@Document(collection = "Urls")
@Data
@TypeAlias("Urls")
public class Urls {

	@Id
	private String id;

	@Field("task_id")
	private long taskId;

	@Field("excute_id")
	private long excuteId;

	@Field("excute_uuid")
	private String excuteUuid;

	@Field("url_seq")
	private long urlSeq;

	@Field("status")
	private int status;

	@Field("url")
	private String url;

	@Field("err_code")
	private int errCode;

	@Field("depth")
	private int depth;

	@Field("parse_info")
	private Map parseInfo;

	@Field("create_time")
	private Date createTime;

}
