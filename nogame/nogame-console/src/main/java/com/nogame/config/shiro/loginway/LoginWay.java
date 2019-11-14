package com.nogame.config.shiro.loginway;

import com.nogame.config.shiro.LoginUserToken;
import com.nogame.myenum.LoginType;
import com.nogame.primary.entity.LoginUserEntity;

/**
 * 登录方式
 * 
 * @author 黄传举
 */
public interface LoginWay {

	/**
	 * 登录类型
	 * 
	 * @return
	 */
	LoginType loginType();

	/**
	 * 根据配对的令牌初始化登录方式
	 * 
	 * @param userToken
	 * @return
	 */
	void initByToken(LoginUserToken userToken);

	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	LoginUserEntity getLoginUser();

	/**
	 * 是否免密
	 * 
	 * @return
	 */
	boolean requriedPassword();

	/**
	 * 验证密码
	 * 
	 * @param password
	 * @return
	 */
	boolean isPasswordMatch(String password);
}
