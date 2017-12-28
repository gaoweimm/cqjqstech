package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.SoftText;

public interface SoftTextDao {
	
	Integer saveSoftText(SoftText softText);
	SoftText findById(Integer id);
	List<SoftText> findAll();
	void deleteById(Integer id);
	void updateSoftText(SoftText softText);
}
