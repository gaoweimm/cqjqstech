$(document).ready(function () {
//	$("#merchants").click(function(){
		getSoftTextList();
//	});
});
//+ URLS.URL_API_HOST + 'rest/shop/getShopDetail?shop_id='
function getSoftTextList() {
	  var show_soft_textList = '';
	  var nDate = '';
	  var registClient = {
	    onComplete: function (args) {
	      for (var i = 0; i < args.softTextList.length; i++) {
	    	  show_soft_textList = show_soft_textList + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
	        '<td>' + args.softTextList[i].soft_text_id + '</td>' +
	        '<td>' + args.softTextList[i].soft_top + '</td>' +
	        '<td>' + args.softTextList[i].soft_text_body + '</td>' +
	        '<td>' + args.softTextList[i].soft_text_type + '</td>' +
	        '<td>' + ' <a href='+'updateSoftText.html?soft_text_id='+args.softTextList[i].soft_text_id+
	        '&soft_top='+args.softTextList[i].soft_top+
	        '&soft_text_body='+args.softTextList[i].soft_text_body+
	        '&soft_text_type='+args.softTextList[i].soft_text_type+
	        ' class=\'tablelink\'>修改</a>  '+
	        '  <a href='+ URLS.URL_API_HOST + 'rest/softText/deleteSoftText?soft_text_id='+args.softTextList[i].soft_text_id+' class=\'tablelink\'>删除</a>   ' +
	        '</td></tr>';
	        $('#tbody_show').html(show_soft_textList);
	      }
	    },
	    onError: function (error) {
	      return;
	    },
	    onException: function (status, errorInfo, hint) {
	      return;
	    }
	  };
	  WebUtil.doPost(URLS.URL_API_HOST + 'rest/softText/findSoftText', {
	  }, true, registClient);
};

