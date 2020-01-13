package com.cyberorange.primary.mapper.base;

import org.apache.ibatis.annotations.Mapper;

import com.cyberorange.mapper.basics.BasicsMapper;
import com.cyberorange.primary.entity.UserEntity;

/**
 * 基础CRUD接口类
 */
@Mapper
public interface BaseUserMapper extends BasicsMapper<UserEntity>{

}