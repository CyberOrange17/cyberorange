package com.cyberorange.primary.mapper.base;

import com.cyberorange.mapper.basics.BasicsMapper;
import org.apache.ibatis.annotations.Mapper;

import com.cyberorange.primary.entity.LoginUserEntity;

/**
 * 基础CRUD接口类
 */
@Mapper
public interface BaseLoginUserMapper extends BasicsMapper<LoginUserEntity> {

}