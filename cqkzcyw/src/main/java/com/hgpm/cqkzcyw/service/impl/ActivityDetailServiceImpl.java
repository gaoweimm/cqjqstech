package com.hgpm.cqkzcyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.hgpm.cqkzcyw.dao.interfaces.ActivityDetailDao;
import com.hgpm.cqkzcyw.entity.ActivityDetail;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.ActivityDetailService;

import sun.misc.BASE64Encoder;

public class ActivityDetailServiceImpl extends BaseService implements ActivityDetailService {

	@Autowired
	private ActivityDetailDao activityDetailDao;
	@Override
	public Integer saveActivityDetail(ActivityDetail activityDetail,MultipartFile[] file) {
		if(!file[0].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[0].getBytes());
				activityDetail.setDetail_pic1(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[1].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[1].getBytes());
			
				activityDetail.setDetail_pic2(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[2].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[2].getBytes());
				activityDetail.setDetail_pic3(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[3].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[3].getBytes());
				activityDetail.setDetail_pic4(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(!file[4].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[4].getBytes());
				activityDetail.setDetail_pic5(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		
		return activityDetailDao.saveActivityDetail(activityDetail);
	}

	@Override
	public ActivityDetail findById(Integer id) {
		
		return activityDetailDao.findById(id);
	}

	@Override
	public List<ActivityDetail> findAll() {
		
		return activityDetailDao.findAll();
	}

	@Override
	public void updateActivityDetail(ActivityDetail activityDetail,MultipartFile[] file) {
		activityDetailDao.updateActivityDetail(activityDetail);
		
	}

	@Override
	public void deleteByActivityDetailId(Integer id) {
		activityDetailDao.deleteById(id);
		
	}

	@Override
	public List<ActivityDetail> findByDetailType(Integer detail_type) {
		return activityDetailDao.findByDetailType(detail_type);
	}

}
