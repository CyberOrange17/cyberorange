package com.cyberorange.console.config.shiro;

import com.cyberorange.commom.myenum.LoginType;
import com.cyberorange.console.config.shiro.loginway.LoginWay;
import com.cyberorange.console.utils.SpringContextUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.util.Map;

/**
 * 自定义登录令牌
 * 
 * @author 黄传举
 */
public class LoginUserToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	/**
	 * 登录方式
	 */
	private LoginType loginType;

	public LoginUserToken() {
		super();
	}

	public LoginUserToken(String username, String password, LoginType loginType) {
		super(username, password);
		this.loginType = loginType;
	}

	/**
	 * 根据登录类型获取登录方式
	 * 
	 */
	public LoginWay getLoginWay() {
		Map<String, LoginWay> loginWays = SpringContextUtils.getBeansOfType(LoginWay.class);
		for (LoginWay loginWay : loginWays.values()) {
			if (loginWay.loginType() == loginType) {
				loginWay.initByToken(this);
				return loginWay;
			}
		}
		return null;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
}
