package com.hgpm.cqkzcyw.web.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hgpm.cqkzcyw.container.ControllerMapping;
import com.hgpm.cqkzcyw.container.UrlsMapping;
import com.hgpm.cqkzcyw.entity.Comment;
import com.hgpm.cqkzcyw.service.interfaces.CommentService;
import com.hgpm.cqkzcyw.util.Message;

@Controller
@RequestMapping(value = ControllerMapping.COMMENT)
public class CommentRest {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = UrlsMapping.SAVE_COMMENT, method = RequestMethod.POST)
	public ModelAndView saveComment(Comment comment,@RequestParam("file") MultipartFile[] file){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showCommentList.html");
		Integer result = commentService.saveComment(comment,file);
		return modelAndView;
	}
	@RequestMapping(value = "saveCommentClient", method = RequestMethod.POST)
	@ResponseBody
	public Message saveCommentClient(Comment comment){
		comment.setCreate_date(new Date());
		Integer result = commentService.saveComment(comment,null);
		return Message.success("shopRest.find.success");
	}
	@RequestMapping(value = UrlsMapping.FIND_COMMENT,method = RequestMethod.POST)
	@ResponseBody
	public Message findComment(Comment comment){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Comment> list = commentService.findAll();
		map.put("commentList", list);
		return Message.success("shopRest.find.success",map);
		
	}
	
	@RequestMapping(value = UrlsMapping.FIND_BY_COMMENT_ID,method = RequestMethod.POST)
	public Message findByCommentId(Comment comment){
		Map<String,Object> map = new HashMap<String, Object>();
		Comment result = commentService.findById(comment.getComment_id());
		map.put("comment", result);
		return Message.success("shopRest.find.success",map);
	}
	@RequestMapping(value = "deleteComment", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteShopDetail(Comment comment){
		ModelAndView mv = new ModelAndView("redirect:/admin/html/showCommentList.html");
		commentService.deleteById(comment.getComment_id());
		return mv;
	} 
}
