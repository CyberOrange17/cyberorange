package com.cyberorange.config.shiro.loginway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyberorange.client.primary.LoginUserClient;
import com.cyberorange.config.shiro.LoginUserToken;
import com.cyberorange.myenum.LoginType;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.utils.string.MD5;

/**
 * 账号密码登录方式
 * 
 * @author 黄传举
 */
@Component
public class NomalLogin implements LoginWay {

	@Autowired
	private LoginUserClient loginUserClient;

	private LoginType loginType = LoginType.NORMAL;

	private LoginUserToken token;

	@Override
	public LoginType loginType() {
		return loginType;
	}

	@Override
	public void initByToken(LoginUserToken token) {
		this.token = token;
	}

	@Override
	public boolean requriedPassword() {
		return loginType.isRequriedPassword();
	}

	@Override
	public LoginUserEntity getLoginUser() {
		return loginUserClient.getUserByAccount(token.getUsername());
	}

	@Override
	public boolean isPasswordMatch(String password) {
		String tokenPassword = MD5.md5(new String(token.getPassword()));
		return tokenPassword.equals(password);
	}
}