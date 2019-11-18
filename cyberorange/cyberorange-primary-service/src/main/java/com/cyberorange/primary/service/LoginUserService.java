package com.cyberorange.primary.service;

import com.cyberorange.service.basics.BasicsService;
import com.cyberorange.primary.entity.LoginUserEntity;

/**
 * 服务接口类
 */
public interface LoginUserService extends BasicsService<LoginUserEntity> {

	LoginUserEntity getLoginUserByAccount(String account);

}