$(document).ready(function () {
	var username = $.session.get('oper_name');
	$('#username').text(username);
});
