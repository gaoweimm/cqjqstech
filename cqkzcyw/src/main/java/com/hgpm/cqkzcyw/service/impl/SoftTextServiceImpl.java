package com.hgpm.cqkzcyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgpm.cqkzcyw.dao.interfaces.SoftTextDao;
import com.hgpm.cqkzcyw.entity.SoftText;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.SoftTextService;

public class SoftTextServiceImpl extends BaseService implements SoftTextService {

	@Autowired
	private SoftTextDao softTextDao;
	@Override
	public Integer saveSoftText(SoftText softText) {

		return softTextDao.saveSoftText(softText);
	}

	@Override
	public SoftText findById(Integer id) {
		
		return softTextDao.findById(id);
	}

	@Override
	public List<SoftText> findAll() {

		return softTextDao.findAll();
	}

	@Override
	public void updateSoftText(SoftText softText) {
		softTextDao.updateSoftText(softText);
	}

	@Override
	public void deleteById(Integer id) {
		softTextDao.deleteById(id);
	}

}
