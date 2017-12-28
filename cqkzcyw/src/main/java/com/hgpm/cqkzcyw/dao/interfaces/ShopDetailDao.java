package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.ShopDetail;

public interface ShopDetailDao {
	
	Integer saveShopDetail(ShopDetail shopDetail);
	ShopDetail findById(Integer id);
	List<ShopDetail> findAll();
	void deleteById(Integer id);
	void deleteByShopId(Integer shopId);
	List<ShopDetail> findByShopId(Integer shopId);
}
