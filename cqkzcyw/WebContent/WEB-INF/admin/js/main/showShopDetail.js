var shop_id = '';
$(document).ready(function () {
	shop_id =  GetQueryString('shop_id');
	getShopDetail();	
});

function getShopDetail() {
	  var registClient = {
	    onComplete: function (args) {
	        $().html(args);
	    },
	    onError: function (error) {
	      return;
	    },
	    onException: function (status, errorInfo, hint) {
	      return;
	    }
	  };
	  WebUtil.doPost(URLS.URL_API_HOST + 'rest/shop/getShopDetail', {
		  shop_id:shop_id
	  }, false, registClient);
};

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}