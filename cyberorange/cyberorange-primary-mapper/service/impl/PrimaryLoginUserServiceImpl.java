package com.cyberorange.primary.service.impl;

import com.cyberorange.service.basics.impl.BasicsServiceImpl;
import com.cyberorange.primary.entity.PrimaryLoginUserEntity;
import com.cyberorange.primary.mapper.PrimaryLoginUserMapper;
import com.cyberorange.primary.service.PrimaryLoginUserService;

import org.springframework.stereotype.Service;

/**
 * 服务实现类
 */
@Service
public class PrimaryLoginUserServiceImpl extends BasicsServiceImpl<PrimaryLoginUserMapper, PrimaryLoginUserEntity>
	implements PrimaryLoginUserService {

}