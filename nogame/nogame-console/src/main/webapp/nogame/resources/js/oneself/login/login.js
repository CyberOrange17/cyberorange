
$(function() {
	//登录
	$("#toLogin").unbind("click").bind("click", function() {
		debugger
		var account = $("#account").val();
		var password = $("#password").val();
		$.ajax({
			url : "/user/login.html",
			type : "POST",
			data : {
				"account" : account,
				"password" : password
			},
			success : function(res) {
			}
		});
	});
	//注册验证用户名与邮箱
	$("#register_ccount").unbind("blur").bind("blur", function() {
		debugger
		var account = $(this).val();
		$.ajax({
			url : "/check",
			type : "POST",
			data : {
				"account" : account,
			},
			success : function(res) {
			}
		});
	});

});

