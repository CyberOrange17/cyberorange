package com.nogame.mapper.primary.base;

import org.apache.ibatis.annotations.Mapper;

import com.nogame.mapper.basics.BasicsMapper;
import com.nogame.primary.entity.LoginUserEntity;

@Mapper
public interface BaseLoginUserMapper extends BasicsMapper<LoginUserEntity>{

}
