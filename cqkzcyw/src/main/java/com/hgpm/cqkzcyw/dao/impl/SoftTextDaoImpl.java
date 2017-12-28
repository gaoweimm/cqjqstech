package com.hgpm.cqkzcyw.dao.impl;

import java.util.List;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.SoftTextDao;
import com.hgpm.cqkzcyw.entity.SoftText;

public class SoftTextDaoImpl extends BaseDao implements SoftTextDao{

	@Override
	public Integer saveSoftText(SoftText softText) {
		
		return (Integer) super.save(softText);
	}

	@Override
	public SoftText findById(Integer id) {
		
		return super.get(SoftText.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SoftText> findAll() {
		String hql = "from SoftText";
		return super.list(hql, null);
	}

	@Override
	public void deleteById(Integer id) {
		super.delete(SoftText.class, id);
	}

	@Override
	public void updateSoftText(SoftText softText) {
		
		super.update(softText);
	}

}
