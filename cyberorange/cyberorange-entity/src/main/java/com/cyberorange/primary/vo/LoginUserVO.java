package com.cyberorange.primary.vo;

import java.io.Serializable;

import com.cyberorange.myenum.LoginType;

public class LoginUserVO  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
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

    /**
     * 登录方式
     */
    private LoginType loginType;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
}