package com.nogame.primary.service;

import com.nogame.service.basics.BasicsService;
import com.nogame.primary.entity.LoginUserEntity;

/**
 * 服务接口类
 */
public interface LoginUserService extends BasicsService<LoginUserEntity> {

	LoginUserEntity getLoginUserByAccount(String account);

}