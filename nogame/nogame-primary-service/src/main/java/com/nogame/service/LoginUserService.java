package com.nogame.service;

import com.nogame.primary.entity.LoginUserEntity;
import com.nogame.service.basics.BasicsService;

public interface LoginUserService extends BasicsService<LoginUserEntity>{
	
	/**
	 * 查询用户是否存在
	 * @return
	 */
	LoginUserEntity getUserByAccount(String account);
	
	/**
	 * 验证用户登录信息
	 * @param name
	 * @param password
	 * @return
	 */
	LoginUserEntity getUserByAccountAndPassword(String name, String password);

}
