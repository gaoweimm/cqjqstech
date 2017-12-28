$(document).ready(function () {
	var message_id = GetQueryString('message_id');
	var notice_top = GetQueryString('notice_top');
	var notice_message_body = GetQueryString('notice_message_body');
	var notice_message_type = GetQueryString('notice_message_type');
	$('#message_id').val(message_id);
	$('#notice_top').val(notice_top);
	$('#notice_message_body').val(notice_message_body);
	$('#notice_message_type').val(notice_message_type);
});


function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}