package com.nogame.config.shiro.loginway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nogame.client.primary.LoginUserClient;
import com.nogame.config.shiro.UserToken;
import com.nogame.myenum.LoginType;
import com.nogame.primary.entity.LoginUserEntity;
import com.nogame.utils.string.MD5;

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

	private UserToken token;

	@Override
	public LoginType loginType() {
		return loginType;
	}

	@Override
	public void initByToken(UserToken token) {
		this.token = token;
	}

	@Override
	public boolean requriedPassword() {
		return loginType.isRequriedPassword();
	}

	@Override
	public LoginUserEntity getUser() {
		return loginUserClient.getUserByAccount(token.getUsername());
	}

	@Override
	public boolean isPasswordMatch(String password) {
		String tokenPassword = MD5.md5(new String(token.getPassword()));
		return tokenPassword.equals(password);
	}
}
