$(document).ready(function () {
//	$("#merchants").click(function(){
		getCommentList();
//	});
});
//+ URLS.URL_API_HOST + 'rest/shop/getShopDetail?shop_id='
function getCommentList() {
	  var show_commentList = '';
	  var nDate = '';
	  var registClient = {
	    onComplete: function (args) {
	      for (var i = 0; i < args.commentList.length; i++) {
	    	  show_commentList = show_commentList + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
	        '<td>' + args.commentList[i].comment_id + '</td>' +
	        '<td>' + args.commentList[i].comment_text + '</td>' +
	        '<td>' + args.commentList[i].comment_level + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.commentList[i].pic1 + '" />' + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.commentList[i].pic2 + '" />' + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.commentList[i].pic3 + '" />' + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.commentList[i].pic4 + '" />' + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.commentList[i].pic5 + '" />' + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.commentList[i].pic6 + '" />' + '</td>' +
	        '<td>' + ' <a href='+'updateCommentList.html?comment_id='+args.commentList[i].message_id+' class=\'tablelink\'>修改</a>  '+
	        '  <a href='+ URLS.URL_API_HOST + 'rest/comment/deleteComment?comment_id='+args.commentList[i].comment_id+' class=\'tablelink\'>删除</a>   ' +
	        '</td></tr>';
	        $('#tbody_show').html(show_commentList);
	      }
	    },
	    onError: function (error) {
	      return;
	    },
	    onException: function (status, errorInfo, hint) {
	      return;
	    }
	  };
	  WebUtil.doPost(URLS.URL_API_HOST + 'rest/comment/findComment', {
	  }, true, registClient);
};

