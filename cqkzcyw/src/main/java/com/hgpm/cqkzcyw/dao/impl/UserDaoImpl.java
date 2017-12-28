package com.hgpm.cqkzcyw.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.UserDao;
import com.hgpm.cqkzcyw.entity.Userinfo;

public class UserDaoImpl extends BaseDao implements UserDao {
	
//	@Autowired
//	private BaseDao baseDao;
	
	public List<Map<String, Object>> list(String name, int start, int size, String order) {
		List<Object> param = new ArrayList<Object>();
		String sql = "select u.* from userinfo u where 1=1 ";
		if (null != name && name.trim().length() > 0) {
			sql += " and u.name like ? ";
			param.add("%" + name + "%");
		}
		if (null == order || order.length() == 0) {
			order = " birthday asc";
		}
		return super.listByNative(sql, param.toArray(), start, size, order);
	}

	public int count(String name, int start, int size, String order) {
		List<Object> param = new ArrayList<Object>();
		String sql = "select count(*) from userinfo u where 1=1 ";
		if (null != name && name.trim().length() > 0) {
			sql += " and u.name like ? ";
			param.add("%" + name + "%");
		}
		return super.countByNative(sql, param.toArray());
	}

	@SuppressWarnings("unchecked")
	public Userinfo getUserinfoByOper_no(String oper_no) {
		String hql = "select u from Userinfo u where u.oper_no = ? ";
		List<Userinfo> list = super.list(hql, new Object[] {oper_no});
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> getUserinfoAll() {
		List<Userinfo> list = super.getSession().createQuery("from Userinfo").list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> findByOperType(String oper_type) {
		String hql = "select u from Userinfo u where u.oper_type = ? ";
		List<Userinfo> list = super.list(hql,new Object[]{oper_type});
		return list; 
	}

	@Override
	public void deleteById(Integer id) {

		delete(Userinfo.class, id);
	}

	@Override
	public Userinfo findByUserinfoId(Integer oper_id) {
		return super.get(Userinfo.class, oper_id);
	}

	@Override
	public void updateUserInfo(Userinfo userinfo) {
		super.update(userinfo);
	}

}
