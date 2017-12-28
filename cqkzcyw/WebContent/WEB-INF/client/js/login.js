var oper_pwd = '';
var oper_no = '';
$(document).ready(function() {
	$('#login').bind('click',function(){
		oper_pwd = $('#oper_pwd').val();
		oper_no = $('#oper_no').val();
		if(check()){
			login() 
		}
	});
});

function check(){
	if(oper_no === ""){
		alert("请输入账号！");
		return false;
	}
	if(oper_pwd === ""){
		alert("密码不能为空！！");
		return false;
	}
	return true;
}

function login() {
	
	var registClient = {
		onComplete : function(args) {
			window.location.href = "main.html";
			$.session.set('oper_no', args.userinfo.oper_no);
		},
		onError : function(error) {
			alert("用户不存在或者用户名和密码不匹配！！");
			return;
		},
		onException : function(status, errorInfo, hint) {
			alert("登录异常！！" + errorInfo);
			return;
		}
	};

	WebUtil.doPost(
			
			URLS.URL_API_HOST + 'rest/userinfo/clientLogin', {				
				oper_no:oper_no,	
				oper_pwd:oper_pwd		
			},
			true, registClient);
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}