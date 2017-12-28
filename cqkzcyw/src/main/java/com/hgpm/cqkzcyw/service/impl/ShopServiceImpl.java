package com.hgpm.cqkzcyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgpm.cqkzcyw.dao.interfaces.ShopDao;
import com.hgpm.cqkzcyw.entity.Shop;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.ShopService;

public class ShopServiceImpl extends BaseService implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Override
	public List<Shop> findAll() {

		return shopDao.findAll();
	}

	@Override
	public Integer saveShop(Shop shop) {

		return shopDao.saveShop(shop);
	}

	@Override
	public Shop findById(Integer id) {

		return shopDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		shopDao.deleteById(id);
	}
}
