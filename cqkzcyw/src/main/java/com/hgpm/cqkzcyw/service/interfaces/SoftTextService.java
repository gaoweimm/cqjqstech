package com.hgpm.cqkzcyw.service.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.SoftText;

public interface SoftTextService {
	Integer saveSoftText(SoftText softText);
	SoftText findById(Integer id);
	List<SoftText> findAll();
	void updateSoftText(SoftText softText);
	void deleteById(Integer id);
}
