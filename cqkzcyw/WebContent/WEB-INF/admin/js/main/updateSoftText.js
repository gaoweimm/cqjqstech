$(document).ready(function () {
	var soft_text_id = GetQueryString('soft_text_id');
	var soft_top = GetQueryString('soft_top');
	var soft_text_body = GetQueryString('soft_text_body');
	var soft_text_type = GetQueryString('soft_text_type');
	$('#soft_text_id').val(soft_text_id);
	$('#soft_top').val(soft_top);
	$('#soft_text_body').val(soft_text_body);
	$('#soft_text_type').val(soft_text_type);
});


function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}