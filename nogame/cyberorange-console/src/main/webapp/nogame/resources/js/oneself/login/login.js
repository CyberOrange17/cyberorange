$(function() {
	//登录
	$("#toLogin").unbind("click").bind("click", function() {
		var account = $("#account").val();
		var password = $("#password").val();
		var data = {"account":account,"password":password,"loginType":0};
		$.ajax({
			url : "/loginUser/login.html",
			type : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			success : function(res) {
			}
		});
	});
	//注册验证用户名与邮箱
	$("#register_ccount").unbind("blur").bind("blur", function() {
		var account = $(this).val();
		$.ajax({
			url : "/loginUser/checkRegisterAccount",
			type : "POST",
			data : {
				"account" : account,
			},
			success : function(res) {
			}
		});
	});
});

