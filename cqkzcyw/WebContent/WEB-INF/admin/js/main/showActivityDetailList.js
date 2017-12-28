$(document).ready(function () {
//	$("#merchants").click(function(){
		getActivityDetailList();
//	});
});
//+ URLS.URL_API_HOST + 'rest/shop/getShopDetail?shop_id='
function getActivityDetailList() {
	  var show_activityDetailList = '';
	  var nDate = '';
	  var registClient = {
	    onComplete: function (args) {
	      for (var i = 0; i < args.activityDetailList.length; i++) {
	    	  show_activityDetailList = show_activityDetailList + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
	        '<td>' + args.activityDetailList[i].detail_id + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_top + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_name + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_introduction + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_sale + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_traffic + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_contact + '</td>' +
	        '<td>' + args.activityDetailList[i].detail_type + '</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.activityDetailList[i].detail_pic1 + '" />'+'</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.activityDetailList[i].detail_pic2 + '" />'+'</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.activityDetailList[i].detail_pic3 + '" />'+'</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.activityDetailList[i].detail_pic4 + '" />'+'</td>' +
	        '<td>' + '<img src="data:image/png;base64,'+args.activityDetailList[i].detail_pic5 + '" />'+'</td>' +
	        '<td>' + ' <a href='+'updateActivityDetail.html?detail_id='+args.activityDetailList[i].detail_id+
	        '&detail_top='+args.activityDetailList[i].detail_top+
	        '&detail_name=' +args.activityDetailList[i].detail_name+
	        '&detail_introduction='+args.activityDetailList[i].detail_introduction+
	        '&detail_sale='+args.activityDetailList[i].detail_traffic+
	        '&detail_traffic='+args.activityDetailList[i].detail_traffic+
	        '&detail_contact='+args.activityDetailList[i].detail_contact+
	        '&detail_pic1='+args.activityDetailList[i].detail_pic1+
//	        '&detail_pic2='+args.activityDetailList[i].detail_pic2+
//	        '&detail_pic3='+args.activityDetailList[i].detail_pic3+
//	        '&detail_pic4='+args.activityDetailList[i].detail_pic4+
//	        '&detail_pic5='+args.activityDetailList[i].detail_pic5+
	        ' class=\'tablelink\'>修改</a>  '+
	        '  <a href='+ URLS.URL_API_HOST + 'rest/activityDetail/deleteActivityDetail?detail_id='+args.activityDetailList[i].detail_id+' class=\'tablelink\'>删除</a>   ' +
	        '</td></tr>';
	        $('#tbody_show').html(show_activityDetailList);
	      }
	    },
	    onError: function (error) {
	      return;
	    },
	    onException: function (status, errorInfo, hint) {
	      return;
	    }
	  };
	  WebUtil.doPost(URLS.URL_API_HOST + 'rest/activityDetail/findActivityDetail', {
	  }, true, registClient);
};

