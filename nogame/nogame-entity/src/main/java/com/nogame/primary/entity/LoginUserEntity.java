package com.nogame.primary.entity;

/**
 * 登录信息
 * @author 黄传举
 */
public class LoginUserEntity{
	
	private Long id;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * QQ
	 */
	private String qq;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
