package com.nogame.myenum;

/**
 * 	登录类型
 * @author 黄传举
 */
public enum LoginType {
	
	NORMAL(0, true, "账号"),
	QQ(1, false, "QQ");
	
	private LoginType(int code, boolean requriedPassword, String name) {
		this.code = code;
		this.requriedPassword = requriedPassword;
		this.name = name;
	}
	
	private int code;//编码
	private boolean requriedPassword;//是否需要密码
	private String name;//名称

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isRequriedPassword() {
		return requriedPassword;
	}

	public void setRequriedPassword(boolean requriedPassword) {
		this.requriedPassword = requriedPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
