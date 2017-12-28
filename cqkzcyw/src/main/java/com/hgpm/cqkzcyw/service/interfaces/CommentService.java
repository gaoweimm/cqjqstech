package com.hgpm.cqkzcyw.service.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hgpm.cqkzcyw.entity.Comment;

public interface CommentService {
	Integer saveComment(Comment comment,MultipartFile[] file);
	Comment findById(Integer id);
	List<Comment> findAll();
	void deleteById(Integer id);
}
