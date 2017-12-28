$(document).ready(function () {
	var oper_type = $.session.get('oper_type');
	if(oper_type == 3){
		$("#ordinary").addClass("active");
		$("#administraor").hide();
		$("#merchant").hide();
	}else if(oper_type == 2){
		$("#merchant").addClass("active");
		$("#administraor").hide();
	}
	$("#one").click(function(){
		$.session.set('oper_type', '1');
	});
	$("#two").click(function(){
		$.session.set('oper_type', '2');
	});
	$("#three").click(function(){
		$.session.set('oper_type', '3');
	});

});

