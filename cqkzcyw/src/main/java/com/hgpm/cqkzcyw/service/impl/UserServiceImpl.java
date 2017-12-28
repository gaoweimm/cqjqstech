package com.hgpm.cqkzcyw.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.UserDao;
import com.hgpm.cqkzcyw.entity.Userinfo;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.UserService;
import com.hgpm.cqkzcyw.util.StringUtil;

public class UserServiceImpl extends BaseService implements UserService{
	@Autowired
	private BaseDao baseDao ;
	@Autowired
	private UserDao userDao;
	/**
	 * list
	 * @param name
	 * @param start
	 * @param size
	 * @param order
	 * @return
	 */
	public String list(String name,int start, int size, String order){
		List<Map<String,Object>> list =userDao.list(name,start, size, order); 
		int count = count(name,start, size, order);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String s = gson.toJson(map);
		return s;
	}
	/**
	 * save
	 * @param userinfo
	 * @return
	 */
	public String save(Userinfo userinfo) {
		String result = null;
		Date date = new Date();
		userinfo.setCreate_date(date);
//		userinfo.setOper_pwd("123456");
		super.save(userinfo);
		result = "{\"success\":true,\"msg\":\"������ɫ�ɹ�\"}";
		return result ;
	}
	/**
	 * count
	 * @param name
	 * @param start
	 * @param size
	 * @param order
	 * @return
	 */
	public int count(String name,int start, int size, String order){
		return userDao.count(name,start, size, order);
	}
	/**
	 * getuserbyname
	 * @param name
	 * @return
	 */
	public Userinfo getUserinfoByOper_no(String name) {
		return userDao.getUserinfoByOper_no(name);
	}
	/**
	 * update
	 * @param request
	 * @param userinfo
	 * @param id
	 * @return
	 */
	public String update(HttpServletRequest request, Userinfo userinfo,
			Integer id) {
		Userinfo userinfoOld = super.get(Userinfo.class, id);
		if(null != userinfo){
			StringUtil.requestToObject(request, userinfoOld);
		}
		super.update(userinfoOld);
		String result = "{\"success\":true,\"msg\":\"���³ɹ���\"}";
		return result;
	}
	/**
	 * delete
	 * @param id
	 */
	public void delete(Serializable id){
		baseDao.delete(Userinfo.class,id);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<Userinfo> getUserinfoAll() {
		return userDao.getUserinfoAll();
	}
	@Override
	public List<Userinfo> findByOperType(String oper_type) {
		
		return userDao.findByOperType(oper_type);
	}
	@Override
	public Userinfo findByUserinfoId(Integer oper_id) {
		return userDao.findByUserinfoId(oper_id);
	}
	@Override
	public void updateUserinfo(Userinfo userinfo) {
		Date date = new Date();
		userinfo.setCreate_date(date);
		userDao.updateUserInfo(userinfo);
	}
	
}
