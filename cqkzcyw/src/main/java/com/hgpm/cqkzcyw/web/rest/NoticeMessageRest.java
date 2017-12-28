package com.hgpm.cqkzcyw.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hgpm.cqkzcyw.container.ControllerMapping;
import com.hgpm.cqkzcyw.container.UrlsMapping;
import com.hgpm.cqkzcyw.entity.Comment;
import com.hgpm.cqkzcyw.entity.NoticeMessage;
import com.hgpm.cqkzcyw.service.interfaces.NoticeMessageService;
import com.hgpm.cqkzcyw.util.Message;

@Controller
@RequestMapping(value = ControllerMapping.NOTICE_MESSAGE)
public class NoticeMessageRest {

	@Autowired
	private NoticeMessageService noticeMessageService;
	
	@RequestMapping(value = UrlsMapping.SAVE_NOTICE_MESSAGE, method = RequestMethod.POST)
	public ModelAndView saveNoticeMessage(NoticeMessage noticeMessage){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showNoticeMessageList.html");
		Integer result = noticeMessageService.saveNoticeMessage(noticeMessage);
		return modelAndView;
	}
	
	@RequestMapping(value = UrlsMapping.UPDATE_NOTICE_MESSAGE, method = RequestMethod.POST)
	public ModelAndView updateNoticeMessage(NoticeMessage noticeMessage){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showNoticeMessageList.html");
		noticeMessageService.updateNoticeMessage(noticeMessage);
		return modelAndView;
	}
	
	@RequestMapping(value = UrlsMapping.DELETE_NOTICE_MESSAGE, method = RequestMethod.GET)
	public ModelAndView deleteNoticeMessage(NoticeMessage noticeMessage){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showNoticeMessageList.html");
		noticeMessageService.deleteByNoticeMessageId(noticeMessage.getMessage_id());
		return modelAndView;
	}
	@RequestMapping(value = UrlsMapping.FIND_NOTICE_MESSAGE,method = RequestMethod.POST)
	@ResponseBody
	public Message findNoticeMessage(NoticeMessage noticeMessage){
		Map<String,Object> map = new HashMap<String, Object>();
		List<NoticeMessage> list = noticeMessageService.findAll();
		map.put("noticeMessageList", list);
		return Message.success("userRest.login.success",map);
		
	}
	
	@RequestMapping(value = UrlsMapping.FIND_BY_NOTICE_MESSAGE_ID,method = RequestMethod.POST)
	public Message findByNoticeMessageId(NoticeMessage noticeMessage){
		Map<String,Object> map = new HashMap<String, Object>();
		NoticeMessage result = noticeMessageService.findById(noticeMessage.getMessage_id());
		map.put("noticeMessage", result);
		return Message.success("userRest.login.success",map);
	}
}
