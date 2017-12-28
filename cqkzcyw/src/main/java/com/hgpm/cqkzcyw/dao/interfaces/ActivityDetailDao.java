package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.ActivityDetail;

public interface ActivityDetailDao {
	Integer saveActivityDetail(ActivityDetail activityDetail);
	ActivityDetail findById(Integer id);
	List<ActivityDetail> findAll();
	void deleteById(Integer id);
	void updateActivityDetail(ActivityDetail activityDetail);
	List<ActivityDetail> findByDetailType(Integer detail_type);
}
