package com.cyberorange.primary.service;

import com.cyberorange.primary.vo.LoginUserVO;

/**
 * 服务接口类
 */
public interface LoginUserCacheService {

	/**
	 * 保存登录信息
	 * @param loginUser
	 * @return token
	 */
	String loginUserInfo(LoginUserVO loginUser);
}