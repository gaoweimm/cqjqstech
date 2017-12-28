package com.hgpm.cqkzcyw.dao.impl;

import java.util.List;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.ShopDetailDao;
import com.hgpm.cqkzcyw.entity.ShopDetail;

public class ShopDetailDaoImpl extends BaseDao implements ShopDetailDao{

	@Override
	public Integer saveShopDetail(ShopDetail shopDetail) {
		return (Integer) super.save(shopDetail);
	}

	@Override
	public ShopDetail findById(Integer id) {
		
		return super.get(ShopDetail.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopDetail> findAll() {
		String hql = "from ShopDetail";
		return super.list(hql, null);
	}

	@Override
	public void deleteById(Integer id) {
		super.delete(ShopDetail.class, id);
	}

	@Override
	public List<ShopDetail> findByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		String hql = "from ShopDetail where shop_id=?";
		List<ShopDetail> list = super.list(hql, new Object[]{shopId});
		return list;
	}

	@Override
	public void deleteByShopId(Integer shopId) {
		String hql = "delete ShopDetail where shop_id=?";
		super.delete(hql, new Object[]{shopId});
	}

}
