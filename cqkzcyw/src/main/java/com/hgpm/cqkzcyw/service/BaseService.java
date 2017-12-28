package com.hgpm.cqkzcyw.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgpm.cqkzcyw.dao.BaseDao;


/**
 * service层的共有父类，提供了箿单的增删改查�??
 *
 */
public class BaseService {
	@Autowired
	private BaseDao baseDao;
	/**
	 * 根据主键，返回实�?
	 * @param id 主键
	 * @return	实体或空（如果没有查到）
	 */
	public <T> T get(Class<T> entityClass, Serializable id){
		return baseDao.get(entityClass, id);
	}
	
	/**
	 * 保存实体对象，返回主�?
	 * @param model
	 * @return
	 */
	public Serializable save(Object model){
		return baseDao.save(model);
	}
	
	/**
	 * 更新实体对象，不返回�?
	 * @param entity
	 */
	public void update(Object model){
		baseDao.update(model);
	}
	
	
	/**
	 * 保存或更�?
	 * @param model 实体�?
	 */
    public void saveOrUpdate(Object model) {
    	baseDao.saveOrUpdate(model);
    }
	/**
	 * 删除指定对象，不返回�?
	 * @param model
	 */
	public void delete(Object model){
		baseDao.delete(model);
	}
	
	/**
	 * 查出承有对豿
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> list(Class<T> entityClass){
		return baseDao.list(entityClass);
	}

	/**
	 * 统计承有对象个敿
	 * @param entityClass
	 * @return
	 */
	public int count(Class<?> entityClass){
		return baseDao.count(entityClass);
	}	
}
