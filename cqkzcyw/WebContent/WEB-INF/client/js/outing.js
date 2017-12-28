var shop_id = '';
var oper_no = '';
$(document).ready(function() {
	var detail_id = GetQueryString('detail_id');
	shop_id = GetQueryString('shop_id');
	oper_no = $.session.get('oper_no');
	$('#userinfo_oper_no').text("欢迎  "+oper_no+" 登录");
	getActivityDetailById(detail_id);
});

function getActivityDetailById(detail_id) {
	var show_activityDetailList = '';
	var registClient = {
		onComplete : function(args) {
			show_activityDetailList = show_activityDetailList 
						+ '<div class="text_middle">'
						+ args.activityDetail.detail_top
						+ '</div> '
						+ '<div class="padding_blank10"></div>'
						+ '<div class="outing_text">'
						+ args.activityDetail.detail_introduction
						+ '</div> '
						+ '<img class="travel_route_browse_img" src="data:image/png;base64,'
						+ args.activityDetail.detail_pic1 + '" />'
			$('#outing_content').append(show_activityDetailList);
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};

	WebUtil.doPost(
			
			URLS.URL_API_HOST + 'rest/activityDetail/findByActivityDetailId', {
				shop_id:shop_id,
				detail_id:detail_id
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