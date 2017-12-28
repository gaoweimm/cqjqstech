var oper_name = '';
var oper_pwd = '';
var oper_repwd = '';
var oper_type = '';
var oper_phone = '';
var oper_no = '';
$(document).ready(function() {
	$('#register').bind('click',function(){
		oper_name = $('#oper_name').val();
		oper_pwd = $('#oper_pwd').val();
		oper_repwd = $('#oper_repwd').val();
		oper_type = $('#oper_type').val();
		oper_phone = $('#oper_phone').val();
		oper_no = $('#oper_no').val();
		if(check()){
			register() 
		}
	});
});

function check(){
	if(oper_pwd!=oper_repwd){
		alert("两次输入的密码不一致！");
		return false;
	}
	if(oper_name === ""){
		alert("请输入用户名！");
		return false;
	}	
	if(oper_no === ""){
		alert("请输入账号！");
		return false;
	}
	if(oper_type === "-1"){
		alert("请选择注册类型！");
		return false;
	}
	if(oper_pwd === ""){
		alert("密码不能为空！！");
		return false;
	}
	if(oper_phone === ""){
		alert("请输入手机号码！！");
		return false;
	}
	return true;
}

function register() {
	
	var registClient = {
		onComplete : function(args) {
			alert("注册成功，点击确定跳转到登录界面");
			window.location.href = "login.html";
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};

	WebUtil.doPost(
			
			URLS.URL_API_HOST + 'rest/userinfo/resgisterUserinfo', {
				oper_name:oper_name,
				oper_pwd:oper_pwd,
				oper_type:oper_type,
				oper_phone:oper_phone,
				oper_no:oper_no				
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