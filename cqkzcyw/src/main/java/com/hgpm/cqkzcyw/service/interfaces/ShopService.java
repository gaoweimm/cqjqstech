package com.hgpm.cqkzcyw.service.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.Shop;

public interface ShopService {
	List<Shop> findAll();
	Integer saveShop(Shop shop);
	Shop findById(Integer id);
	void deleteById(Integer id);
}
