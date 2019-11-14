package com.nogame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nogame.primary.entity.LoginUserEntity;
import com.nogame.primary.mapper.LoginUserMapper;
import com.nogame.service.LoginUserService;
import com.nogame.service.impl.basics.BasicsServiceImpl;

/**
 * 登录用户
 * @author 黄传举
 */
@Service
public class LoginUserServiceImpl extends BasicsServiceImpl<LoginUserEntity> implements LoginUserService {
	
	@Autowired
	private LoginUserMapper loginUserMapper;

	@Override
	public LoginUserEntity getUserByAccount(String account) {
		return loginUserMapper.getUserByAccount(account);
	}

	@Override
	public LoginUserEntity getUserByAccountAndPassword(String account, String password) {
		return loginUserMapper.getUserByAccountAndPassword(account, password);
	}

}
