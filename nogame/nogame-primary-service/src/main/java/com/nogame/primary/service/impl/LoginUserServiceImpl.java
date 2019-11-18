package com.nogame.primary.service.impl;

import com.nogame.service.basics.impl.BasicsServiceImpl;
import com.nogame.primary.entity.LoginUserEntity;
import com.nogame.primary.mapper.LoginUserMapper;
import com.nogame.primary.service.LoginUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 */
@Service
public class LoginUserServiceImpl extends BasicsServiceImpl<LoginUserMapper, LoginUserEntity>
	implements LoginUserService {

	@Autowired
	private LoginUserMapper loginUserMapper;
	
	@Override
	public LoginUserEntity getLoginUserByAccount(String account) {
		LoginUserEntity loginUserEntity = new LoginUserEntity();
		loginUserEntity.setAccount(account);
		LoginUserEntity selectOneSelective = loginUserMapper.selectOneSelective(loginUserEntity);
		return selectOneSelective;
	}

}