package com.nogame.primary.service.impl;

import com.nogame.service.basics.impl.BasicsServiceImpl;
import com.nogame.primary.entity.PrimaryLoginUserEntity;
import com.nogame.primary.mapper.PrimaryLoginUserMapper;
import com.nogame.primary.service.PrimaryLoginUserService;

import org.springframework.stereotype.Service;

/**
 * 服务实现类
 */
@Service
public class PrimaryLoginUserServiceImpl extends BasicsServiceImpl<PrimaryLoginUserMapper, PrimaryLoginUserEntity>
	implements PrimaryLoginUserService {

}