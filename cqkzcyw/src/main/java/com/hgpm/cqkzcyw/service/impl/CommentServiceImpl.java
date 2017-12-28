package com.hgpm.cqkzcyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.hgpm.cqkzcyw.dao.interfaces.CommentDao;
import com.hgpm.cqkzcyw.entity.Comment;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.CommentService;

import sun.misc.BASE64Encoder;

public class CommentServiceImpl extends BaseService implements CommentService{

	@Autowired
	private CommentDao commentDao;
	@Override
	public Integer saveComment(Comment comment,MultipartFile[] file) {
		if(file!=null&&!file[0].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[0].getBytes());
				comment.setPic_1(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(file!=null&&!file[1].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[1].getBytes());
			
				comment.setPic_2(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(file!=null&&!file[2].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[2].getBytes());
				comment.setPic_3(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(file!=null&&!file[3].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[3].getBytes());
				comment.setPic_4(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(file!=null&&!file[4].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[4].getBytes());
				comment.setPic_5(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		if(file!=null&&!file[5].isEmpty()){
			try {
				BASE64Encoder encoder = new BASE64Encoder();  
				// 通过base64来转化图片
				String data = encoder.encode(file[5].getBytes());
				comment.setPic_6(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}

		return commentDao.saveComment(comment);
	}

	@Override
	public Comment findById(Integer id) {

		return commentDao.findById(id);
	}

	@Override
	public List<Comment> findAll() {

		return commentDao.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		commentDao.deleteById(id);
	}

}
