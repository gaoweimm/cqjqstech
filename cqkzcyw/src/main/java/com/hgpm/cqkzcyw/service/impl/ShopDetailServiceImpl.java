package com.hgpm.cqkzcyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.hgpm.cqkzcyw.dao.interfaces.ShopDetailDao;
import com.hgpm.cqkzcyw.entity.ShopDetail;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.ShopDetailService;

import sun.misc.BASE64Encoder;

public class ShopDetailServiceImpl extends BaseService implements ShopDetailService{

	@Autowired
	private ShopDetailDao shopDetailDao;
	@Override
	public Integer saveShopDetail(ShopDetail shopDetail,MultipartFile[] file) {				
		if(!file[0].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[0].getBytes());
				shopDetail.setDetail_pic1(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[1].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[1].getBytes());
			
				shopDetail.setDetail_pic2(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[2].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[2].getBytes());
				shopDetail.setDetail_pic3(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[3].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[3].getBytes());
				shopDetail.setDetail_pic4(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[4].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[4].getBytes());
				shopDetail.setDetail_pic5(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		
		return shopDetailDao.saveShopDetail(shopDetail);
	}
	@Override
	public ShopDetail findById(Integer id) {
		
		return shopDetailDao.findById(id);
	}
	@Override
	public List<ShopDetail> findAll() {
		return shopDetailDao.findAll();
	}
	@Override
	public List<ShopDetail> findByShopId(Integer shopId) {
		return shopDetailDao.findByShopId(shopId);
	}
	@Override
	public void deleteByShopId(Integer shopId) {
		shopDetailDao.deleteByShopId(shopId);
	}

}
