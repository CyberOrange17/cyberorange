$(function() {
	// 跳转到card.html
	$("#toCard").unbind("click").bind("click", function() {
		$.ajax({
			url : "/home/card.html",
			type : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			success : function(res) {
				if(res.status == 200){
					window.location.href = "/home/card.html";
				}
			}
		});
	});
});

