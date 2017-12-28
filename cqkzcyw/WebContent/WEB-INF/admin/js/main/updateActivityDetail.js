$(document).ready(function () {
	var detail_id = GetQueryString('detail_id');
	var detail_top = GetQueryString('detail_top');
	var detail_name = GetQueryString('detail_name');
	var detail_introduction = GetQueryString('detail_introduction');
	var detail_sale = GetQueryString('detail_sale');
	var detail_traffic = GetQueryString('detail_traffic');
	var detail_contact = GetQueryString('detail_contact');
	var detail_pic1 = GetQueryString('detail_pic1');
	var detail_pic2 = GetQueryString('detail_pic2');
	var detail_pic3 = GetQueryString('detail_pic3');
	var detail_pic4 = GetQueryString('detail_pic4');
	var detail_pic5 = GetQueryString('detail_pic5');
	$('#detail_id').val(detail_id);
	$('#detail_top').val(detail_top);
	$('#detail_name').val(detail_name);
	$('#detail_introduction').val(detail_introduction);
	$('#detail_sale').val(detail_sale);
	$('#detail_traffic').val(detail_traffic);
	$('#detail_contact').val(detail_contact);
	$('#detail_pic1').val(detail_pic1);
//	$('#detail_pic2').val(detail_pic2);
//	$('#detail_pic3').val(detail_pic3);
//	$('#detail_pic4').val(detail_pic4);
//	$('#detail_pic5').val(detail_pic5);
});


function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}