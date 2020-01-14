package com.cyberorange.feign.primary.login;

import com.cyberorange.commom.myenum.GlobalAttributes;
import com.cyberorange.entity.primary.entity.LoginUserEntity;
import com.cyberorange.entity.primary.vo.LoginUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = GlobalAttributes.EURAKA_PRIMARY)
public interface LoginUserClient {

	/**
	 * 根据账号获取登录用户信息
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/loginUser/getUserByAccount")
	public LoginUserEntity getUserByAccount(@RequestParam("account") String account);
	
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
	public LoginUserEntity getUserByEmail(@RequestParam("email") String email);
}
