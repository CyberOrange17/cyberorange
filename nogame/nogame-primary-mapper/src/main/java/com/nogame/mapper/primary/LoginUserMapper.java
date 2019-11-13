package com.nogame.mapper.primary;

import org.apache.ibatis.annotations.Mapper;

import com.nogame.mapper.basics.BasicsMapper;
import com.nogame.primary.entity.LoginUserEntity;

@Mapper
public interface LoginUserMapper extends BasicsMapper<LoginUserMapper>{

	LoginUserEntity getUserByAccount(String account);

	LoginUserEntity getUserByAccountAndPassword(String account, String password);

}
