package com.hgpm.cqkzcyw.container;

/**
 * url请求方法映射
 * 命名规则：控制器对应的方法名称，多个单词用下划线连接
 * */
public class UrlsMapping {
	
	public static final String LOGIN = "login";
	/**主页面*/
	public static final String INDEX = "index";
	public static final String GET = "get";
	public static final String GET_OPER_BYTYPE = "getByOperType";
	public static final String GET_SHOP = "getShop";
	public static final String SAVE_SHOP = "saveShop";

	public static final String FIND_ACTIVITY_DETAIL = "findActivityDetail";
	public static final String SAVE_ACTIVITY_DETAIL = "saveActivityDetail";
	public static final String FIND_BY_ACTIVITY_DETAIL_ID = "findByActivityDetailId";
	public static final String UPDATE_ACTIVITY_DETAIL = "updateActivityDetail";
	public static final String DELETE_ACTIVITY_DETAIL = "deleteActivityDetail";
	public static final String FIND_BY_ACTIVITY_DETAIL_TYPE = "findByActivityDetailType";
	
	public static final String FIND_COMMENT = "findComment";
	public static final String FIND_BY_COMMENT_ID = "findByCommentId";
	public static final String SAVE_COMMENT = "saveComment";
	
	public static final String FIND_NOTICE_MESSAGE = "findNoticeMessage";
	public static final String FIND_BY_NOTICE_MESSAGE_ID = "findByNoticeMessageId";
	public static final String SAVE_NOTICE_MESSAGE = "saveNoticeMessage";
	public static final String UPDATE_NOTICE_MESSAGE = "updateNoticeMessage";
	public static final String DELETE_NOTICE_MESSAGE = "deleteNoticeMessage";
	
	public static final String FIND_SOFT_TEXT = "findSoftText";
	public static final String FIND_BY_SOFT_TEXT_ID = "findBySoftTextId";
	public static final String SAVE_SOFT_TEXT = "saveSoftText";
	public static final String UPDATE_SOFT_TEXT = "updateSoftText";
	public static final String DELETE_SOFT_TEXT = "deleteSoftText";
	
	public static final String FIND_USERINFO = "findUserinfo";
	public static final String FIND_BY_USERINFO_ID = "findByUserinfoId";
	public static final String DELETE_USERINFO_BY_ID = "deleteUserinfoById";
	public static final String SAVE_USERIFO = "saveUserinfo";
	public static final String UPDATE_USERINFO = "updateUserinfo";
	public static final String REGISTER_USERINFO = "resgisterUserinfo" ;
	public static final String CLIENT_LOGIN = "clientLogin";
}
