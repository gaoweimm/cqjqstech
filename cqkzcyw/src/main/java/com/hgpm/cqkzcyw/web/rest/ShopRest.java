package com.hgpm.cqkzcyw.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.hgpm.cqkzcyw.entity.Shop;
import com.hgpm.cqkzcyw.entity.ShopDetail;
import com.hgpm.cqkzcyw.service.interfaces.ShopDetailService;
import com.hgpm.cqkzcyw.service.interfaces.ShopService;
import com.hgpm.cqkzcyw.util.Message;

@Controller
@RequestMapping(value=ControllerMapping.SHOP)
public class ShopRest {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopDetailService shopDetailService;
	
	@RequestMapping(value = UrlsMapping.GET_SHOP ,method = RequestMethod.GET)
	@ResponseBody
	public Message getShop(Shop shop) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Shop> list = shopService.findAll();
		map.put("shop", list);
		return Message.success("shopRest.find.success", map);

	}
	
	@RequestMapping(value = UrlsMapping.SAVE_SHOP, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveShop(@RequestParam("file") MultipartFile[] file, HttpServletRequest request, Shop shop,ShopDetail shopDetail) {
		ModelAndView mv = new ModelAndView("redirect:/admin/html/shopList.html");
		Map<String, Object> map = new HashMap<String, Object>();
		Integer shop_id = shopService.saveShop(shop);		
		shopDetail.setShop_id(shop_id);
		shopDetail.setDetail_top(shop.getShop_name()+"-"+shopDetail.getDetail_name());
		shopDetailService.saveShopDetail(shopDetail,file);
		map.put("conut", shop_id);
		return mv;

	}
	
	@RequestMapping(value = "getShopDetail", method = RequestMethod.POST)
	@ResponseBody
	public Message getShopDetail(Shop shop,HttpServletRequest request,HttpServletResponse response){
		Message msg = new Message();
		List<ShopDetail> result = null;
		result = shopDetailService.findAll();
		msg.setType(Message.Type.success);
		msg.addArg("shopDetailList", result);
		return msg;
	}
	@RequestMapping(value = "findShopDetail", method = RequestMethod.POST)
	@ResponseBody
	public Message findByShopDetailId(Shop shop,HttpServletRequest request,HttpServletResponse response){
		Message msg = new Message();
		List<ShopDetail> result = null;
		result = shopDetailService.findByShopId(shop.getShop_id());
		msg.setType(Message.Type.success);
		msg.addArg("shopDetail", result.get(0));
		return msg;
	}
	@RequestMapping(value = "deleteShopDetail", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteShopDetail(Shop shop){
		ModelAndView mv = new ModelAndView("redirect:/admin/html/shopList.html");
		shopService.deleteById(shop.getShop_id());
		shopDetailService.deleteByShopId(shop.getShop_id());
		return mv;
	} 
}
