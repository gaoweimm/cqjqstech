package com.hgpm.cqkzcyw.web.rest;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hgpm.cqkzcyw.container.ControllerMapping;
import com.hgpm.cqkzcyw.container.UrlsMapping;
import com.hgpm.cqkzcyw.entity.Userinfo;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.UserService;
import com.hgpm.cqkzcyw.util.Message;
import com.hgpm.cqkzcyw.util.StringUtil;

@Controller
@RequestMapping(value=ControllerMapping.USERINFO)
public class UserinfoRest {
	@Autowired
	private UserService userService;
	@Autowired
	private BaseService baseService;
	private static Log log = LogFactory.getLog(UserinfoRest.class);
	
	/**
	 * index --list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value=UrlsMapping.LOGIN,method = RequestMethod.POST)
	@ResponseBody
	public Message login(Userinfo userinfo)throws Exception{
		Message message = new Message();
		Map<String,Object> map = new HashMap<String,Object>();
		log.info(userinfo);
		Userinfo result = new Userinfo();
		try {
			result = userService.getUserinfoByOper_no(userinfo.getOper_no());
			if(result!=null&&result.getOper_pwd().equals(userinfo.getOper_pwd())){
//				message.addArg("userinfo",  result);
				map.put("user", result);
				return Message.success("userRest.login.success",map);
			}
		} catch (Exception e) {
			return Message.error("userRest.login.error",e.getMessage());
		}
		
		return message;
	}
	@RequestMapping(value=UrlsMapping.SAVE_USERIFO,method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveUserinfo(Userinfo userinfo ,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("redirect:/admin/html/right.html");
		userService.save(userinfo);
		return mv;
	}
	@RequestMapping(value=UrlsMapping.DELETE_USERINFO_BY_ID,method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteUserinfoById(Userinfo userinfo,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("redirect:/admin/html/right.html");
		userService.delete(userinfo.getOper_id());
		return mv;
	}
	
	@RequestMapping(value=UrlsMapping.UPDATE_USERINFO,method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateUserinfoById(Userinfo userinfo,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("redirect:/admin/html/right.html");
		userService.updateUserinfo(userinfo);
		return mv;
	}
	
	@RequestMapping(value=UrlsMapping.FIND_BY_USERINFO_ID,method = RequestMethod.POST)
	@ResponseBody
	public Userinfo findByUserinfoId(Userinfo userinfo)throws Exception{
			
		return userService.findByUserinfoId(userinfo.getOper_id());
	}
	
	
	@RequestMapping(value=UrlsMapping.GET,method = RequestMethod.POST)
	@ResponseBody
	public Message get(Userinfo userinfo)throws Exception{
//		Message message = new Message();
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Userinfo> result = userService.getUserinfoAll();
		map.put("userAll", result);
		log.info(result);
		return Message.success("userRest.login.success",map);
	}
	@RequestMapping(value=UrlsMapping.REGISTER_USERINFO,method=RequestMethod.POST)
	@ResponseBody
	public Message registerUserinfo(Userinfo userinfo){		
		userinfo.setOper_flag("0");
		String result = userService.save(userinfo);
		return Message.success("userRest.login.success");
	}
	
	@RequestMapping(value=UrlsMapping.CLIENT_LOGIN,method=RequestMethod.POST)
	@ResponseBody
	public Message clientLogin(Userinfo userinfo){		
		Map<String,Object> map = new HashMap<String,Object>();
		Userinfo result = null;
		try {
			result = userService.getUserinfoByOper_no(userinfo.getOper_no());
			if(result!=null&&result.getOper_pwd().equals(userinfo.getOper_pwd())){
				map.put("userinfo", result);
				return Message.success("userRest.login.success",map);
			}
		} catch (Exception e) {
			return Message.error("userRest.login.error");
		}
		return Message.error("userRest.login.error");
	}
	
	
	@RequestMapping(value=UrlsMapping.GET_OPER_BYTYPE,method = RequestMethod.GET)
	@ResponseBody
	public Message findByOperType(Userinfo userinfo)throws Exception{
//		Message message = new Message();
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Userinfo> result = userService.findByOperType(userinfo.getOper_type());
		map.put("userinfo", result);
		log.info(result);
		return Message.success("userRest.login.success",map);
	}
	/**
	 * list method
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public List<String> list(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		int start = ServletRequestUtils.getIntParameter(request, "page", 1)-1;
		int size = ServletRequestUtils.getIntParameter(request, "rows", 0);
		String name = ServletRequestUtils.getStringParameter(request, "name","");
		String order = StringUtil.getOrderString(request);	//取得排序参数
		
		String result = null;
		try{
			result = userService.list(name,start, size, order);
		}catch (Exception e) {
			result = "";
		}
		String sortName = ServletRequestUtils.getStringParameter(request, "sort", "");
		String sortOrder = ServletRequestUtils.getStringParameter(request, "order", "");
		Map<String, Object> searchMap = new HashMap<String,Object>();
		searchMap.put("pageNumber", start+1);
		searchMap.put("rows", size);
		searchMap.put("sortName", sortName);
		searchMap.put("sortOrder", sortOrder);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String s = gson.toJson(searchMap);
		s = URLEncoder.encode(s,"UTF-8"); 
		
		StringUtil.writeToWeb(result, "html", response);
		return null;
	}
	/**
	 * gotoAdd --page
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/gotoAdd")
	public String gotoAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return "views/user/add";
	}
	/**
	 * add --method
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add")
	public String add(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		String result = null;
		Userinfo userinfo = (Userinfo)StringUtil.requestToObject(request, Userinfo.class);
		Userinfo dbUserinfo =  userService.getUserinfoByOper_no(userinfo.getOper_name());
		if(dbUserinfo!=null){
			result = "{\"success\":false,\"msg\":\"名称已存在！\"}";
			StringUtil.writeToWeb(result, "html", response);
			return null;
		}
		try{
			if(userinfo.getOper_name().trim().length()<0){
				result = "{\"success\":false,\"msg\":\"名称不能为空！\"}";
				StringUtil.writeToWeb(result, "html", response);
				return null;
			}else if(null == userinfo.getOper_flag()){
				result = "{\"success\":false,\"msg\":\"年龄参数有误！\"}";
				StringUtil.writeToWeb(result, "html", response);
				return null;
			}else{
				result = userService.save(userinfo);
			}
		}catch(Exception e){
			result = "{\"success\":false,\"msg\":\"系统错误，请稍忙再试！\"}";
		}
		StringUtil.writeToWeb(result, "html", response);
		return null;
	}
	/**
	 * gotoModify --page
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/gotoModify")
	public String gotoModify(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		Integer id = ServletRequestUtils.getIntParameter(request,"id");
		Userinfo userinfo = baseService.get(Userinfo.class,id);
		request.setAttribute("userinfo", userinfo);
			return "views/user/modify";
	}
	/**
	 * modify --method
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id = ServletRequestUtils.getIntParameter(request, "id");
		Userinfo dbUserinfo = baseService.get(Userinfo.class, id);
		Userinfo userinfo = (Userinfo) StringUtil.requestToObject(request, Userinfo.class);
		String result;
		if(!dbUserinfo.getOper_name().equals(userinfo.getOper_name())){
			Userinfo hasUserinfo = userService.getUserinfoByOper_no(userinfo.getOper_name());
			if(hasUserinfo!=null){
				result = "{\"success\":false,\"msg\":\"角色名称已存在！\"}";
				StringUtil.writeToWeb(result, "html", response);
				return null;
			}
		}
		try{
			result = userService.update(request,userinfo, id);
		}catch (Exception e ){
			result = "{\"success\":false,\"msg\":\"系统错误，请稍忙再试！\"}";
		}
		StringUtil.writeToWeb(result, "html", response);
		return null;
	}
	/**
	 * delete --method
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Integer id = ServletRequestUtils.getIntParameter(request, "id");
		
		try{
			if(null != id){
				userService.delete(id);
			}
			String result = "{\"success\":true,\"msg\":\"删除成功\"}";
			StringUtil.writeToWeb(result, "html", response);
			return null;
		} catch (Exception e) {
			String result = "{\"success\":false,\"msg\":\"删除失败，请稍忙再试！\"}";
			StringUtil.writeToWeb(result, "html", response);
			return null;
		}
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}