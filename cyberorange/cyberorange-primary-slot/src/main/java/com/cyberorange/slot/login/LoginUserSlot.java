package com.cyberorange.slot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.service.LoginUserService;

/**
 * 基础服务-用户登录
 * 
 * @author 黄传举
 */
@RestController
@RequestMapping("/loginUser")
public class LoginUserSlot {

	@Autowired
	private LoginUserService loginUserService;
	
	/**
	 * 根据账号查询用户
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/getUserByAccount")
	public LoginUserEntity getUserByAccount(@RequestParam String account) {
		return loginUserService.getLoginUserByAccount(account);
	}

	/**
	 * 注册验证：账号是否已注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/checkRegisterAccount", method = RequestMethod.POST)
	public LoginUserEntity checkRegisterAccount(@RequestParam String account) {
		return loginUserService.getLoginUserByAccount(account);
	}
	
}
