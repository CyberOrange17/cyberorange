package com.cyberorange.primary.service.impl;

import com.cyberorange.allocation.redis.RedisClient;
import com.cyberorange.primary.cache.LoginUserCachePO;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.mapper.LoginUserMapper;
import com.cyberorange.primary.service.LoginUserCacheService;
import com.cyberorange.primary.vo.LoginUserVO;
import com.cyberorange.service.basics.impl.BasicsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 服务实现类
 */
@Service
public class LoginUserCacheServiceImpl extends BasicsServiceImpl<LoginUserMapper, LoginUserEntity>
	implements LoginUserCacheService {


	@Autowired
	private RedisClient redisClient;


	@Override
	public String loginUserInfo(LoginUserVO loginUser) {
		LoginUserCachePO loginUserCachePO = LoginUserCachePO.builder()
				.account(loginUser.getAccount())
				.password(loginUser.getPassword())
				.token(UUID.randomUUID().toString())
				.build();
		// 保存到redis
		redisClient.set(loginUserCachePO.getKey(), loginUserCachePO);
		return loginUserCachePO.getToken();
	}

}