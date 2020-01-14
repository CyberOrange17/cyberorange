package com.cyberorange.console.primary.service;

import com.cyberorange.console.primary.entity.LoginUserEntity;
import com.cyberorange.console.primary.vo.LoginUserVO;
import com.cyberorange.console.service.basics.BasicsService;
import com.cyberorange.service.basics.BasicsService;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.vo.LoginUserVO;

/**
 * 服务接口类
 */
public interface LoginUserService extends BasicsService<LoginUserEntity> {

	/**
	 * 根据账号查询
	 * @param account
	 * @return
	 */
	LoginUserEntity getLoginUserByAccount(String account);
	
	/**
	 * 注册
	 * @param loginUserVO
	 */
	void register(LoginUserVO loginUserVO);

	/**
	 * 根据邮箱查询
	 * @param email
	 * @return
	 */
	LoginUserEntity getUserByEmail(String email);
}