package com.cyberorange.commom.myenum;

/**
 * 响应码
 * @author 黄传举
 */
public enum ResponseCode {
	
	
	succeed(200,"成功"),
	failed(500,"失败"),
	
	processed(201,"已处理"),
	
	erroRequest(400,"错误请求"),
	unauthorized(401,"未授权"),
	notfound(404,"未找到"),
	repeat(409,"冲突重复");
	
	private int code;
	private String name;
	
	private ResponseCode(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
