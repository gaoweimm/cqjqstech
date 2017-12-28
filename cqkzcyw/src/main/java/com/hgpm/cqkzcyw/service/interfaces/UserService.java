package com.hgpm.cqkzcyw.service.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hgpm.cqkzcyw.entity.Userinfo;

public interface UserService {

	String list(String name, int start, int size, String order);

	String save(Userinfo userinfo);

	int count(String name, int start, int size, String order);

	Userinfo getUserinfoByOper_no(String name);

	String update(HttpServletRequest request, Userinfo userinfo, Integer id);

	void delete(Serializable id);

	List<Userinfo> getUserinfoAll();

	List<Userinfo> findByOperType(String oper_type);
	
	Userinfo findByUserinfoId(Integer oper_id);

	void updateUserinfo(Userinfo userinfo);
}
