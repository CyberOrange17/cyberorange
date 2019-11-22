package com.cyberorange.client.primary;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberorange.myenum.GlobalAttributes;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.vo.LoginUserVO;

@FeignClient(value = GlobalAttributes.EURAKA_PRIMARY)
public interface LoginUserClient {

	/**
	 * 根据账号获取登录用户信息
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/loginUser/getUserByAccount")
	public LoginUserEntity getUserByAccount(@RequestParam String account);
	
	/**
	 * 注册
	 * @param loginUserVO
	 */
	@RequestMapping(value = "/loginUser/register")
	public void register(@RequestBody LoginUserVO loginUserVO);
	
	/**
	 * 根据邮箱获取登录用户信息
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/loginUser/getUserByEmail")
	public LoginUserEntity getUserByEmail(@RequestParam String email);
}
