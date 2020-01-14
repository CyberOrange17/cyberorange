package com.cyberorange.console.primary.service.impl;

import com.cyberorange.console.utils.string.MD5;
import com.cyberorange.service.basics.impl.BasicsServiceImpl;
import com.cyberorange.utils.string.MD5;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.mapper.LoginUserMapper;
import com.cyberorange.primary.service.LoginUserService;
import com.cyberorange.primary.vo.LoginUserVO;

import java.util.Date;

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
		return loginUserMapper.selectOneSelective(loginUserEntity);
	}

	@Override
	public void register(LoginUserVO loginUserVO) {
		LoginUserEntity loginUserEntity = new LoginUserEntity();
		loginUserEntity.setAccount(loginUserVO.getAccount());
		loginUserEntity.setEmail(loginUserVO.getEmail());
		loginUserEntity.setPassword(MD5.md5(loginUserVO.getPassword()));
		loginUserEntity.setCreateTime(new Date());
		loginUserMapper.insert(loginUserEntity);
	}
	
	@Override
	public LoginUserEntity getUserByEmail(String email) {
		LoginUserEntity loginUserEntity = new LoginUserEntity();
		loginUserEntity.setEmail(email);
		return loginUserMapper.selectOneSelective(loginUserEntity);
	}

}