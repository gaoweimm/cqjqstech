package com.hgpm.cqkzcyw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.ActivityDetailDao;
import com.hgpm.cqkzcyw.entity.ActivityDetail;
@Repository
public class ActivityDetailDaoImpl extends BaseDao implements ActivityDetailDao{

	@Override
	public Integer saveActivityDetail(ActivityDetail activityDetail) {
		
		return (Integer) super.save(activityDetail);
	}

	@Override
	public ActivityDetail findById(Integer id) {
		
		return super.get(ActivityDetail.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityDetail> findAll() {
		String hql = "from ActivityDetail";
		return super.list(hql, null);
	}

	@Override
	public void deleteById(Integer id) {
		super.delete(ActivityDetail.class, id);
	}

	@Override
	public void updateActivityDetail(ActivityDetail activityDetail) {
		super.update(activityDetail);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityDetail> findByDetailType(Integer detail_type) {
		String hql = "from ActivityDetail where detail_type=?";
		return super.list(hql, new Object[]{detail_type});
	}

}
