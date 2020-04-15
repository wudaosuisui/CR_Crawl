package com.asiainfo.cr.crawl.store.dao;


import com.asiainfo.cr.crawl.store.pojo.Urls;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UrlsDao extends MongoRepository<Urls, ObjectId> {

	@SuppressWarnings("unchecked")
	public Urls insert(Urls urls);

	@Query("{\"task_id\": ?0 , \"excute_id\": ?1, \"excute_uuid\": ?2, \"url_seq\": ?3}")
	public List<Urls> findBy4(Integer taskId, Integer excuteId, String excuteUuid, Integer urlSeq);

	@DeleteQuery("{\"task_id\": ?0 }")
	public void delete(Integer taskId);

}