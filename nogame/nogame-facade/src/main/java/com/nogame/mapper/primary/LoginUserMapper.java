package com.nogame.mapper.primary;

import org.apache.ibatis.annotations.Mapper;

import com.nogame.mapper.basics.BasicsMapper;
import com.nogame.primary.entity.LoginUserEntity;

/**
 * 账号
 * @author 黄传举
 */
@Mapper
public interface LoginUserMapper extends BasicsMapper<LoginUserEntity>{
	
	/**
	 * 根据账号查找
	 * @param account
	 * @return
	 */
	LoginUserEntity getUserByAccount(String account);
	
	/**
	 * 根据账号和密码查找
	 * @param account
	 * @param password
	 * @return
	 */
	LoginUserEntity getUserByAccountAndPassword(String account, String password);
}
