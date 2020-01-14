package com.cyberorange.primary.service;

import com.cyberorange.entity.primary.entity.LoginUserEntity;
import com.cyberorange.entity.primary.vo.LoginUserVO;
import com.cyberorange.service.basics.BasicsService;

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