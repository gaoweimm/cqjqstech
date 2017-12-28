var oper_no = '';
var soft_text_id=''
$(document).ready(function() {
	soft_text_id = GetQueryString('soft_text_id');
	oper_no = $.session.get('oper_no');
	$('#userinfo_oper_no').text("欢迎  "+oper_no+" 登录");
	if(oper_no == null){
		window.location.href = "login.html";
		alert("请先登录！");
	}else{		
		getSoftText();
	}	
});

function getSoftText(){
	var showSoftText = '';
	var registClient = {
		
		onComplete : function(args) {
			showSoftText = showSoftText 
			+ '<div class="text_middle">'
			+ args.softText.soft_top
			+ '</div> '
			+ '<div class="padding_blank10"></div>'
			+ '<div class="outing_text">'
			+ args.softText.soft_text_body
			+ '</div> '
			$('#softText_content').append(showSoftText);
			$('#location').append(args.softText.soft_top);
			
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};
	WebUtil.doPost(URLS.URL_API_HOST + 'rest/softText/findBySoftTextId', {
		soft_text_id:soft_text_id
	}, false,
			registClient);	
}
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}