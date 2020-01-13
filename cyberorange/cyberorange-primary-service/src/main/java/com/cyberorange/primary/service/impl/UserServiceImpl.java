package com.cyberorange.primary.service.impl;

import com.cyberorange.primary.mapper.LoginUserMapper;
import com.cyberorange.primary.vo.UserVO;
import com.cyberorange.service.basics.impl.BasicsServiceImpl;
import com.cyberorange.primary.entity.UserEntity;
import com.cyberorange.primary.mapper.UserMapper;
import com.cyberorange.primary.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 */
@Service
public class UserServiceImpl extends BasicsServiceImpl<UserMapper, UserEntity>
	implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVO getUserBySession(Long id) {
		return userMapper.getUserBySession(id);
	}
}