package com.cyberorange.primary.mapper.base;

import com.cyberorange.entity.primary.entity.UserEntity;
import com.cyberorange.mapper.basics.BasicsMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基础CRUD接口类
 */
@Mapper
public interface BaseUserMapper extends BasicsMapper<UserEntity>{

}