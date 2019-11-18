package com.nogame.primary.mapper.base;

import org.apache.ibatis.annotations.Mapper;

import com.nogame.mapper.basics.BasicsMapper;
import com.nogame.primary.entity.LoginUserEntity;

/**
 * 基础CRUD接口类
 */
@Mapper
public interface BaseLoginUserMapper extends BasicsMapper<LoginUserEntity>{

}