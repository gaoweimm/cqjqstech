package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.Comment;

public interface CommentDao {
	
	Integer saveComment(Comment comment);
	Comment findById(Integer id);
	List<Comment> findAll();
	void deleteById(Integer id);
}
