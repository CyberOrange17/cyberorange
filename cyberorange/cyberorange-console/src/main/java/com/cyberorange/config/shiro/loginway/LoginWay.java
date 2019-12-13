package com.cyberorange.config.shiro.loginway;

import com.cyberorange.config.shiro.LoginUserToken;
import com.cyberorange.myenum.LoginType;
import com.cyberorange.primary.entity.LoginUserEntity;

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
	 * 获取MD5加密后密码
	 * 
	 * @param password
	 * @return
	 */
	String passwordForMD5(String password);
}
