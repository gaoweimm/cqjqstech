package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.hgpm.cqkzcyw.entity.Userinfo;

public interface UserDao {

	List<Map<String, Object>> list(String name, int start, int size, String order);

	int count(String name, int start, int size, String order);

	Userinfo getUserinfoByOper_no(String oper_no);

	List<Userinfo> getUserinfoAll();

	List<Userinfo> findByOperType(String oper_type);
	
	void deleteById(Integer id);
	
	Userinfo findByUserinfoId(Integer oper_id);
	
	void updateUserInfo(Userinfo userinfo);
}
