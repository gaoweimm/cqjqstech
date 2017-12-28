$(document).ready(function () {
//	$("#merchants").click(function(){
		getNoticeMessageList();
//	});
});
//+ URLS.URL_API_HOST + 'rest/shop/getShopDetail?shop_id='
function getNoticeMessageList() {
	  var show_notice_messageList = '';
	  var nDate = '';
	  var registClient = {
	    onComplete: function (args) {
	      for (var i = 0; i < args.noticeMessageList.length; i++) {
	    	 show_notice_messageList = show_notice_messageList + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
	        '<td>' + args.noticeMessageList[i].message_id + '</td>' +
	        '<td>' + args.noticeMessageList[i].notice_top + '</td>' +
	        '<td>' + args.noticeMessageList[i].notice_message_body + '</td>' +
	        '<td>' + args.noticeMessageList[i].notice_message_type + '</td>' +
	        '<td>' + ' <a href='+'updateNoticeMessage.html?message_id='+args.noticeMessageList[i].message_id+
	        '&notice_top='+args.noticeMessageList[i].notice_top+
	        '&notice_message_body='+args.noticeMessageList[i].notice_message_body+
	        '&notice_message_type='+args.noticeMessageList[i].notice_message_type+
	        ' class=\'tablelink\'>修改</a>  '+
	        '  <a href='+ URLS.URL_API_HOST + 'rest/noticeMessage/deleteNoticeMessage?message_id='+args.noticeMessageList[i].message_id+' class=\'tablelink\'>删除</a>   ' +
	        '</td></tr>';
	        $('#tbody_show').html(show_notice_messageList);
	      }
	    },
	    onError: function (error) {
	      return;
	    },
	    onException: function (status, errorInfo, hint) {
	      return;
	    }
	  };
	  WebUtil.doPost(URLS.URL_API_HOST + 'rest/noticeMessage/findNoticeMessage', {
	  }, true, registClient);
};

