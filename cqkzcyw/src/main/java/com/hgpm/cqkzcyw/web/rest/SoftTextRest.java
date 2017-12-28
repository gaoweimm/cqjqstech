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
import com.hgpm.cqkzcyw.entity.SoftText;
import com.hgpm.cqkzcyw.service.interfaces.SoftTextService;
import com.hgpm.cqkzcyw.util.Message;

@Controller
@RequestMapping(value = ControllerMapping.SOFT_TEXT)
public class SoftTextRest {

	@Autowired
	private SoftTextService softTextService;
	
	@RequestMapping(value = UrlsMapping.SAVE_SOFT_TEXT, method = RequestMethod.POST)
	public ModelAndView saveSoftText(SoftText softText){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showSoftTextList.html");
		Integer result = softTextService.saveSoftText(softText);
		return modelAndView;
	}
	
	@RequestMapping(value = UrlsMapping.UPDATE_SOFT_TEXT, method = RequestMethod.POST)
	public ModelAndView updateSoftText(SoftText softText){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showSoftTextList.html");
		softTextService.updateSoftText(softText);
		return modelAndView;
	}
	
	@RequestMapping(value = UrlsMapping.DELETE_SOFT_TEXT, method = RequestMethod.GET)
	public ModelAndView deleteSoftText(SoftText softText){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showSoftTextList.html");
		softTextService.deleteById(softText.getSoft_text_id());
		return modelAndView;
	}
	
	@RequestMapping(value = UrlsMapping.FIND_SOFT_TEXT,method = RequestMethod.POST)
	@ResponseBody
	public Message findSoftText(SoftText softText){
		Map<String,Object> map = new HashMap<String, Object>();
		List<SoftText> list = softTextService.findAll();
		map.put("softTextList", list);
		return Message.success("shopRest.find.success",map);
		
	}
	
	@RequestMapping(value = UrlsMapping.FIND_BY_SOFT_TEXT_ID,method = RequestMethod.POST)
	@ResponseBody
	public Message findBySoftTextId(SoftText softText){
		Map<String,Object> map = new HashMap<String, Object>();
		SoftText result = softTextService.findById(softText.getSoft_text_id());
		map.put("softText", result);
		return Message.success("shopRest.find.success",map);
		
	}
}
