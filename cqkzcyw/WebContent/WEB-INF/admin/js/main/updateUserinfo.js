$(document).ready(function () {
	var oper_id = GetQueryString('oper_id');
	var oper_name = GetQueryString('oper_name');
	var oper_qq = GetQueryString('oper_qq');
	var oper_no = GetQueryString('oper_no');
	var oper_pwd = GetQueryString('oper_pwd');
	var oper_type = GetQueryString('oper_type');
	var oper_flag = GetQueryString('oper_flag');
	var oper_phone = GetQueryString('oper_phone');
	$('#oper_qq').val(oper_qq);
	$('#oper_no').val(oper_no);
	$('#oper_name').val(oper_name);
	$('#oper_id').val(oper_id);
	$('#oper_pwd').val(oper_pwd);
	$('#oper_type').val(oper_type);
	$('#oper_flag').val(oper_flag);
	$('#oper_phone').val(oper_phone);
});


function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}