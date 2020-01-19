package com.cyberorange.console.config.shiro.loginway;

import com.cyberorange.commom.myenum.LoginType;
import com.cyberorange.commom.utils.string.MD5;
import com.cyberorange.console.config.shiro.LoginUserToken;
import com.cyberorange.feign.primary.login.LoginUserClient;
import com.cyberorange.primary.entity.LoginUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账号密码登录方式
 * 
 * @author 黄传举
 */
@Component
public class NormalLogin implements LoginWay {

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
	public boolean requiredPassword() {
		return loginType.isRequiredPassword();
	}

	@Override
	public LoginUserEntity getLoginUser() {
		return loginUserClient.getUserByAccount(token.getUsername());
	}

	@Override
	public String passwordForMD5(String password) {
		return MD5.md5(new String(token.getPassword()));
	}
}
