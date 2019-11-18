package com.cyberorange.mapper.primary;

import org.apache.ibatis.annotations.Mapper;

import com.cyberorange.mapper.basics.BasicsMapper;
import com.cyberorange.primary.entity.UserEntity;

/**
 * 用户
 * @author 黄传举
 */
@Mapper
public interface UserMapper extends BasicsMapper<UserEntity>{
	
	/**
	 * 用户信息校验
	 * @param user
	 * @return UserModel
	 */
	UserEntity getUserInfo(UserEntity user);

}