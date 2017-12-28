$(document).ready(function () {
//	$("#merchants").click(function(){
	getUserinfoAll();
//	});
});

function getUserinfoAll() {
	  var show_shop = '';
	  var nDate = '';
	  var registClient = {
	    onComplete: function (args) {
	      console.info(args.shop.length);
	      for (var i = 0; i < args.shop.length; i++) {
	          show_userinfo = show_userinfo + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
	          '<td>' + args.userinfo[i].oper_no + '</td>' +
	          '<td>' + args.userinfo[i].oper_name + '</td>' +
	          '<td>' + args.userinfo[i].oper_qq + '</td>' +
	          '<td>' + args.userinfo[i].oper_phone + '</td>' +
	          '<td>' + Format(nDate,"yyyy-MM-dd HH:mm") + '</td>' +
	          '<td>' + args.userinfo[i].oper_flag + '</td><td>' +
	          '<td>' + ' <a href='+ URLS.URL_API_HOST + 'rest/userinfo/getUserinfo?oper_id='+args.userinfo[i].shop_id+' class=\'tablelink\'>修改</a>  '+
		        '  <a href='+ URLS.URL_API_HOST + 'rest/shop/deleteUserinfo?oper_id='+args.userinfo[i].shop_id+' class=\'tablelink\'>删除</a>   ' +
		        '</td></tr>';
	          $('#tbody_show').html(show_userinfo);
	      }
	    },
	    onError: function (error) {
	      return;
	    },
	    onException: function (status, errorInfo, hint) {
	      return;
	    }
	  };
	  WebUtil.doGet(URLS.URL_API_HOST + 'rest/shop/getShop', {
	  }, true, registClient);
};