$(document).ready(function () {
//	$("#merchants").click(function(){
		getShopAll();
//	});
});
//+ URLS.URL_API_HOST + 'rest/shop/getShopDetail?shop_id='
function getShopAll() {
	  var show_shop = '';
	  var nDate = '';
	  var registClient = {
	    onComplete: function (args) {
	      console.info(args.shop.length);
	      for (var i = 0; i < args.shop.length; i++) {
	        show_shop = show_shop + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
	        '<td>' + args.shop[i].shop_id + '</td>' +
	        '<td>' + args.shop[i].shop_name + '</td>' +
	        '<td>' + args.shop[i].shop_address + '</td>' +
	        '<td>' + args.shop[i].contact_person1 + '</td>' +
	        '<td>' + args.shop[i].contact_person2 + '</td>' +
	        '<td>' + args.shop[i].contact_qq + '</td>' +
	        '<td>' + args.shop[i].contact_email + '</td>' +
	        '<td>' + args.shop[i].contact_phone + '</td>' +
	        '<td>' + args.shop[i].contact_number + '</td>' +
	        '<td>' + ' <a href='+'showShopDetail.html?shop_id='+args.shop[i].shop_id+' class=\'tablelink\'>查看</a>  '+
	        '  <a href='+ URLS.URL_API_HOST + 'rest/shop/deleteShopDetail?shop_id='+args.shop[i].shop_id+' class=\'tablelink\'>删除</a>   ' +
	        '</td></tr>';
	        $('#tbody_show').html(show_shop);
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

