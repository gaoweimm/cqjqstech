package com.hgpm.cqkzcyw.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexRest {
	
	@RequestMapping(value="/")
	public ModelAndView clientIndex(){
		ModelAndView modelAndView = new ModelAndView("redirect:/client/html/main.html");
		return modelAndView;
	}
	@RequestMapping(value="/admin")
	public ModelAndView adminIndex(){
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/html/login.html");
		return modelAndView;
	}
}
