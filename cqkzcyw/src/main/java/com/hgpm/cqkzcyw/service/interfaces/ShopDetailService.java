package com.hgpm.cqkzcyw.service.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hgpm.cqkzcyw.entity.ShopDetail;

public interface ShopDetailService {
	
	Integer saveShopDetail(ShopDetail shopDetail,MultipartFile[] file);
	ShopDetail findById(Integer id);
	List<ShopDetail> findAll();
	List<ShopDetail> findByShopId(Integer shopId);
	void deleteByShopId(Integer shopId);
}
