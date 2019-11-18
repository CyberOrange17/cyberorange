package com.cyberorange.primary.service.impl;

import com.cyberorange.service.basics.impl.BasicsServiceImpl;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.mapper.LoginUserMapper;
import com.cyberorange.primary.service.LoginUserService;

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