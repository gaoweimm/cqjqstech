package com.hgpm.cqkzcyw.service.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hgpm.cqkzcyw.entity.ActivityDetail;

public interface ActivityDetailService {
	Integer saveActivityDetail(ActivityDetail activityDetail ,MultipartFile[] file);
	ActivityDetail findById(Integer id);
	List<ActivityDetail> findAll();
	void updateActivityDetail(ActivityDetail activityDetail ,MultipartFile[] file);
	void deleteByActivityDetailId(Integer id);
	List<ActivityDetail> findByDetailType(Integer detail_type);
}
