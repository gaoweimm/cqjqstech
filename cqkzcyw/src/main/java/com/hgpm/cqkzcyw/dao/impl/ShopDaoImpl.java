package com.hgpm.cqkzcyw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.ShopDao;
import com.hgpm.cqkzcyw.entity.Shop;

@Repository
public class ShopDaoImpl extends BaseDao implements ShopDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> findAll() {
		String hql = "from Shop";
		List<Shop> list = super.list(hql, null);
		return list;
	}

	@Override
	public Integer saveShop(Shop shop) {
		
		return (Integer) super.save(shop);
	}

	@Override
	public Shop findById(Integer id) {
		
		return super.get(Shop.class, id);
	}

	@Override
	public void deleteById(Integer id) {
		super.delete(Shop.class, id);
	}	
	
} 
