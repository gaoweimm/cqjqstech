package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.Shop;

public interface ShopDao {
	
	List<Shop> findAll();
	Integer saveShop(Shop shop);
	Shop findById(Integer id);
	void deleteById(Integer id);
}
