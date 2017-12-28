package com.hgpm.cqkzcyw.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.hgpm.cqkzcyw.entity.ActivityDetail;
import com.hgpm.cqkzcyw.entity.SoftText;
import com.hgpm.cqkzcyw.service.interfaces.ActivityDetailService;
import com.hgpm.cqkzcyw.util.Message;

import sun.misc.BASE64Encoder;

@Controller
@RequestMapping(value = ControllerMapping.ACTIVITY_DETAIL)
public class ActivityDetailRest {

	@Autowired
	private ActivityDetailService activityDetailService;
	
	@RequestMapping(value = UrlsMapping.SAVE_ACTIVITY_DETAIL, method = RequestMethod.POST)
	public ModelAndView saveActivityDetail(@RequestParam("file") MultipartFile[] file, HttpServletRequest request,ActivityDetail activityDetail){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showActivityDetailList.html");
		Map<String, Object> map = new HashMap<String, Object>();		
		Integer result = activityDetailService.saveActivityDetail(activityDetail,file);
		return modelAndView;
	}
	
	@RequestMapping(value = UrlsMapping.UPDATE_ACTIVITY_DETAIL, method = RequestMethod.POST)
	public ModelAndView updateActivityDetail(@RequestParam("file") MultipartFile[] file, HttpServletRequest request,ActivityDetail activityDetail){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showActivityDetailList.html");
		Map<String, Object> map = new HashMap<String, Object>();		
		activityDetailService.updateActivityDetail(activityDetail,file);
		return modelAndView;
	}
	@RequestMapping(value = UrlsMapping.DELETE_ACTIVITY_DETAIL, method = RequestMethod.GET)
	public ModelAndView deleteActivityDetail(ActivityDetail activityDetail){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/showActivityDetailList.html");
		activityDetailService.deleteByActivityDetailId(activityDetail.getDetail_id());
		return modelAndView;
	}
	@RequestMapping(value = UrlsMapping.FIND_ACTIVITY_DETAIL,method = RequestMethod.POST)
	@ResponseBody
	public Message findActivityDetail(ActivityDetail activityDetail){
		Map<String,Object> map = new HashMap<String, Object>();
		List<ActivityDetail> list = activityDetailService.findAll();
		map.put("activityDetailList", list);
		return Message.success("shopRest.find.success",map);
		
	}
	
	@RequestMapping(value = UrlsMapping.FIND_BY_ACTIVITY_DETAIL_ID,method = RequestMethod.POST)
	@ResponseBody
	public Message findByActivityDetailId(ActivityDetail activityDetail){
				
		Map<String,Object> map = new HashMap<String, Object>();
		ActivityDetail result = activityDetailService.findById(activityDetail.getDetail_id());
		map.put("activityDetail", result);
		return Message.success("shopRest.find.success",map);
		
	}
	@RequestMapping(value = UrlsMapping.FIND_BY_ACTIVITY_DETAIL_TYPE,method = RequestMethod.POST)
	@ResponseBody
	public Message findByActivityDetailType(ActivityDetail activityDetail){
				
		Map<String,Object> map = new HashMap<String, Object>();
		List<ActivityDetail> result = activityDetailService.findByDetailType(activityDetail.getDetail_type());
		map.put("activityDetailList", result);
		return Message.success("shopRest.find.success",map);
		
	}
}
