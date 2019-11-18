package com.cyberorange.client.primary;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberorange.myenum.GlobalAttributes;
import com.cyberorange.primary.entity.LoginUserEntity;

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
	 * 根据账户及密码获取登录用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/loginUser/checkRegisterAccount", method = RequestMethod.POST)
	public LoginUserEntity getUserByAccountAndPassword(@RequestBody LoginUserEntity user);
}
