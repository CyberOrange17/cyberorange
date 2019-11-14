package com.nogame.config.shiro;

import java.util.Map;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.nogame.config.shiro.loginway.LoginWay;
import com.nogame.myenum.LoginType;
import com.nogame.utils.SpringContextUtils;

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
	 * @param loginType
	 * @return
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
