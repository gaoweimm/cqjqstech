package com.hgpm.cqkzcyw.dao.impl;

import java.util.List;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.CommentDao;
import com.hgpm.cqkzcyw.entity.Comment;

public class CommentDaoImpl extends BaseDao implements CommentDao{

	@Override
	public Integer saveComment(Comment comment) {
		
		return (Integer) super.save(comment);
	}

	@Override
	public Comment findById(Integer id) {
		
		return super.get(Comment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() {
		String hql = "from Comment order by id desc";
		return super.list(hql, null);
	}

	@Override
	public void deleteById(Integer id) {
		super.delete(Comment.class, id);
	}

}
