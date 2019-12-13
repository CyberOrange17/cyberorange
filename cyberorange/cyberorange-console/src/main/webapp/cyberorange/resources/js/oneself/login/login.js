$(function() {
	var pass_account = false;
	var pass_email = false;
	var pass_password = false;
	var pass_confirmpassword = false;
	// 登录
	$("#toLoginJs").unbind("click").bind("click", function() {
		var account = $("#account").val();
		var password = $("#password").val();
		var data = {
			"account" : account,
			"password" : password,
			"loginType" : 0
		};
		$.ajax({
			url : "/loginUser/login.html",
			type : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			success : function(res) {
				if(res.status == 200){
					window.location.href = "/cyberorange/views/index.html";
				}
			}
		});
	});
	// 注册
	$("#toRegisterJs").unbind("click").bind("click", function() {
		if (!pass_account && !pass_email && !pass_password && !pass_confirmpassword) {
			return;
		}
		var account = $("#register_ccount").val();
		var email = $("#register_eamil").val();
		var password = $("#register_password").val();
		var data = {
				"account" : account,
				"password" : password,
				"email" : email,
				"loginType" : 0
		};
		$.ajax({
			url : "/loginUser/register",
			type : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			success : function(res) {
			}
		});
	});
	//提示或输入框清空
	$("#register_ccount").unbind("click").bind("click", function() {
		$("#span_account").html("");
	});
	$("#register_eamil").unbind("click").bind("click", function() {
		$("#span_email").html("");
	});
	$("#register_password").unbind("click").bind("click", function() {
		$("#register_password").val("");
		$("#span_password").html("");
	});
	$("#register_confirmpassword").unbind("click").bind("click", function() {
		$("#register_confirmpassword").val("");
		$("#span_confirmpassword").html("");
	});
	// 验证注册账号
	$("#register_ccount").unbind("blur").bind("blur", function() {
		var account = $(this).val();
		if($.trim(account).length > 0){
			var pattern = /[\w\u4E00-\u9FA5]{2,16}$/;
			if((!pattern.test(account)) || account == '__'){
				$("#span_account").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 账号格式有误<font/>");
				return;
			}
			var data = {
					"account" : account
				};
			$.ajax({
				url : "/loginUser/checkRegisterAccount",
				type : "POST",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(data),
				success : function(res) {
					if(res.status == 200){
						$("#span_account").html("<font style='color: rgb(255, 170, 120)'>✔<font/>");
						pass_account = true;
					}else{
						$("#span_account").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 用户已注册<font/>");
					}
				}
			});
		}
	});
	//验证注册邮箱
	$("#register_eamil").unbind("blur").bind("blur", function() {
		var eamil = $(this).val();
		if($.trim(eamil).length>0){
			var pattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
			if(!pattern.test(eamil)){
				$("#span_email").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 邮箱格式有误<font/>");
				return;
			}
			var data = {
					"email" : eamil
				};
			$.ajax({
				url : "/loginUser/checkRegisterEmail",
				type : "POST",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(data),
				success : function(res) {
					if(res.status == 200){
						$("#span_email").html("<font style='color: rgb(255, 170, 120)'>✔<font/>");
						pass_email = true;
					}else{
						$("#span_email").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 邮箱已注册<font/>");
					}
				}
			});
		}
	});
	//验证注册密码
	$("#register_password").unbind("blur").bind("blur", function() {
		var password = $(this).val();
		if($.trim(password).length>0){
			var pattern = /^(\w){6,20}$/;
			if(!pattern.test(password)){
				$("#span_password").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 密码格式有误<font/>");
				return;
			}
			var confirmpassword = $("#register_confirmpassword").val();
			if($.trim(confirmpassword).length>0){
				if(password != confirmpassword){
					$("#span_password").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 两次输入不同<font/>");
					return;
				}else{
					$("#span_confirmpassword").html("<font style='color: rgb(255, 170, 120)'>✔<font/>");
				}
			}
			pass_password = true;
			$("#span_password").html("<font style='color: rgb(255, 170, 120)'>✔<font/>");
		}
	});
	//验证注册确认密码
	$("#register_confirmpassword").unbind("blur").bind("blur", function() {
		var confirmpassword = $(this).val();
		if($.trim(confirmpassword).length>0){
			var password = $("#register_password").val();
			if($.trim(confirmpassword).length>0){
				if(confirmpassword != password){
					$("#span_confirmpassword").html("<font style='color: rgb(255, 100, 100);font-size:10px;'>✘ 两次输入不同<font/>");
					return;
				}else{
					$("#span_password").html("<font style='color: rgb(255, 170, 120)'>✔<font/>");
				}
			}
			pass_confirmpassword = true;
			$("#span_confirmpassword").html("<font style='color: rgb(255, 170, 120)'>✔<font/>");
		}
	});
});

