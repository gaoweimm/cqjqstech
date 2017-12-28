var oper_no = '';
$(document).ready(function() {
	//oper_no = $.session.get('oper_no');
	//$('#userinfo_oper_no').text("欢迎  "+oper_no+" 登录");
	//if(oper_no == null){
	//	window.location.href = "login.html";
	//	alert("请先登录！");
	//}else{		
		Agritainment();
		getShopAll();
		getActivityDetailList();
		getShopDetailList();
		getNoticeMessage();
		getSoftText();
		URLS.URL_API_HOST = "123";
	//}	
});
$(function(){
	$("div.list_lh").myScroll({
		speed:40, //数值越大，速度越慢
		rowHeight:34 //li的高度
	});
});
var curOpac = 0;
var filterTimer;
var isIE = /internet explorer/i.test(window.navigator.appName);

function MyScroll(cnt, control) {
	this.data = []; // 存放图片路径
	this.interval = 3000; // 过渡一次的间隔时间(过渡时间+图片显示时间)
	this.timer; // 定时器：控制当前显示的图片
	this.container = cnt;
	this.curFrame = 0;
	this.oldFrame = 0;
	this.controls = control; // 按钮集合
	Global = this; // 获取对象的指针

	this.run = function() {
		this.timer = window.setInterval("Global.showFrame()", this.interval);
	}

	// 按钮的处理程序
	this.go = function(i) {
		curOpac = 0; // 透明度归0
		this.curFrame = i; // 当前要过渡的图片
		this.stop(); // 清空计时器
		this.showFrame(); // 当前图片过渡
		this.run(); // 循环播放
	}

	this.stop = function() {
		window.clearInterval(this.timer);
		window.clearInterval(filterTimer);
	}

	this.showFrame = function() {
		$("#cnt").attr('src', this.data[this.curFrame]);

		if (this.oldFrame >= 0)
			$(".banner_lamp").eq(this.oldFrame).removeClass('banner_lamp_cur');
		$(".banner_lamp").eq(this.curFrame).addClass('banner_lamp_cur');

		// if(isIE)
		$("#cnt").attr('filter', "alpha(opacity=0)");
		// else $("#cnt").attr('-moz-opacity', "0");

		filterTimer = window.setInterval("blend()", 100);

		this.oldFrame = this.curFrame;
		this.curFrame++;
		if (this.curFrame == this.data.length) {
			this.curFrame = 0;
		}

	}
}
// 增加透明度
function blend() {
	curOpac += 10;

	// if(isIE)
	$("#cnt").attr('filter', "alpha(opacity='" + curOpac + "')");
	// else $("#cnt").attr('-moz-opacity', curOpac/100.0);

	if (curOpac == 100) {
		curOpac = 0;
		window.clearInterval(filterTimer);
	}
}
// 开始

function startIt() {
	var imgArr = [];
	// 创建4个图片对象保存图片路径
	for (var i = 0; i < 4; i++) {
		imgArr[i] = new Image();
		imgArr[i].src = "../img/banner_0" + (i + 1) + ".jpg";
	}

	var controlArr = $(".banner_lamp");
	for (var i = 0; i < controlArr.length; i++) {
		controlArr[i].tag = i;
		controlArr[i].onclick = function() {
			myScroll.go(this.tag);
		}
	}
	// for(var i= (controlArr.length - 1);i<=0;i--){
	// controlArr[i].tag = i;
	// controlArr[i].onclick = function(){
	// myScroll.go(this.tag);
	// }
	// }

	var myScroll = new MyScroll($("cnt"), controlArr);
	myScroll.data.push(imgArr[0].src);
	myScroll.data.push(imgArr[1].src);
	myScroll.data.push(imgArr[2].src);
	myScroll.data.push(imgArr[3].src);

	myScroll.go(0);
}
function Agritainment() {
	$("#test").bind("click", function(e) {
		location.href = URLS.URL_API_HOST + "client/html/travelRoute.html";
	});
}

function getNoticeMessage(){
	var showNoticeMessage = '';
	var registClient = {
		onComplete : function(args) {
			console.info(args.noticeMessageList.length);
			for (var i = 0; i < args.noticeMessageList.length; i++) {
				showNoticeMessage = showNoticeMessage + "<li>消息： "
						+ args.noticeMessageList[i].notice_message_body + "</li>";
			}
			$('#msg').append(showNoticeMessage);
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};
	WebUtil.doPost(URLS.URL_API_HOST + 'rest/noticeMessage/findNoticeMessage', {}, false,
			registClient);	
}

function getShopAll() {
	var show_shop = '';
	var nDate = '';
	var registClient = {
		onComplete : function(args) {
			console.info(args.shop.length);
			for (var i = 0; i < args.shop.length; i++) {
				show_shop = show_shop + "<li  class = ' net_recommend_row'> "
						+ args.shop[i].shop_name + "</li>";
				$('#shop').html(show_shop);
			}
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};
	WebUtil.doGet(URLS.URL_API_HOST + 'rest/shop/getShop', {}, false,
			registClient);
};

function getActivityDetailList() {
	var show_activityDetailList = '';
	var registClient = {
		onComplete : function(args) {
			for (var i = 0; i < args.activityDetailList.length; i++) {
				show_activityDetailList = show_activityDetailList
						+ '<a href=outing.html?detail_id='
						+ args.activityDetailList[i].detail_id
						+ '&shop_id='
						+ args.activityDetailList[i].shop_id
						+ ' <div class="outing_box">'
						+ '<img style="width: 170px;height: 136px" src="data:image/png;base64,'
						+ args.activityDetailList[i].detail_pic1 + '" />'
						+ '<div>' + args.activityDetailList[i].detail_top
						+ '</div>' + '</div>' + '</a>';
			}
			$('#outing').append(show_activityDetailList);

		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};
	WebUtil.doPost(URLS.URL_API_HOST + 'rest/activityDetail/findActivityDetail',
			{}, true, registClient);
};

function getShopDetailList() {
	var show_shopDetailList = '';
	var registClient = {
		onComplete : function(args) {
			for (var i = 0; i < args.shopDetailList.length; i++) {

				show_shopDetailList = show_shopDetailList
						+ ' <div class="travel_route_row">'
						+ '<a href=travelRoute.html?detail_id='
						+ args.shopDetailList[i].detail_id + '&shop_id='
						+ args.shopDetailList[i].shop_id + '>'
						+ '<img class="row_img" src="data:image/png;base64,'
						+ args.shopDetailList[i].detail_pic1 + '" />'
						+ '<div class="row_info">'
						+ '<div class="row_info_title">'
						+ args.shopDetailList[i].detail_top + '</div>'
						+ '<div class="row_info_text">'
						+ args.shopDetailList[i].detail_introduction.substr(0,50) + '</div>'
						+ '</div>' + '<div class="row_price"><span>￥</span>'
						+ args.shopDetailList[i].detail_sale + '</div>'
						+ '</a>' + '</div>';

			}
			$('#travel_route').append(show_shopDetailList);

		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};
	WebUtil.doPost(URLS.URL_API_HOST + 'rest/shop/getShopDetail', {}, false,
			registClient);
};

function getSoftText(){
	var showSoftText1 = '';
	var showSoftText2 = '';
	var registClient = {
		onComplete : function(args) {
			console.info(args.softTextList.length);
			for (var i = 0; i < args.softTextList.length; i++) {
				if(args.softTextList[i].soft_text_type=='1'){
					showSoftText1 = showSoftText1 + 
					"<li class='farm_trends_row'><span class='icon_li'></span>" +
					"<a	href='softText.html\?soft_text_id="+args.softTextList[i].soft_text_id+"'>"+ args.softTextList[i].soft_top + "</a></li>";
				}
				if(args.softTextList[i].soft_text_type=='2'){
					showSoftText2 = showSoftText2 + 
					"<li class='farm_trends_row'><span class='icon_li'></span>" +
					"<a	href='softText.html\?soft_text_id="+args.softTextList[i].soft_text_id+"'>"+ args.softTextList[i].soft_top + "</a></li>";
				}
			}
			$('#softText1').append(showSoftText1);
			$('#softText2').append(showSoftText2);
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};
	WebUtil.doPost(URLS.URL_API_HOST + 'rest/softText/findSoftText', {}, false,
			registClient);	
};
window.onload = startIt;