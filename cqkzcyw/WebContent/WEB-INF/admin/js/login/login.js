$(document).ready(function() {
	login();
});

function login() {
	$("#btn_submit").bind("click",function(e) {
		var oper_no = ($("#oper_no").val());
		var oper_pwd = ($("#oper_pwd").val());
		console.info("oper_name: " + oper_no + "  oper_pwd: " + oper_pwd);
		
		var registClient = {
				
				onComplete: function(args) {
					console.info(args);
					$.session.set('oper_type', args.user.oper_type);
					$.session.set('oper_type_temp', args.user.oper_type);
					$.session.set('oper_name', args.user.oper_name);
					$.session.set('oper_qq', args.user.oper_qq);
					$.session.set('oper_phone', args.user.oper_phone);
					$.session.set('oper_no', args.user.oper_no);
					$.session.set('create_date', args.user.create_date);
					$.session.set('oper_flag', args.user.oper_flag);
					location.href=URLS.URL_API_HOST+"admin/html/main.html";
				},
				onError: function(error) {
					alert("用户名或密码错误，请重新登录!");
					$("#oper_no").val("");
					$("#oper_pwd").val("");
					return;
					
				},
				onException: function(status, errorInfo, hint) {
					return;
				
				}
			};	
			WebUtil.doPost(URLS.URL_API_HOST+"rest/userinfo/login", {
				oper_no:oper_no,
				oper_pwd: oper_pwd
			}, true, registClient);
	});
}
