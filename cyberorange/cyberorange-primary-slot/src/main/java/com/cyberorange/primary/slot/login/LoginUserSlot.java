package com.cyberorange.primary.slot.login;

import com.cyberorange.entity.primary.entity.LoginUserEntity;
import com.cyberorange.entity.primary.vo.LoginUserVO;
import com.cyberorange.primary.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础服务-用户登录
 * 
 * @author 黄传举
 */
@RestController
@RequestMapping("/loginUser")
public class LoginUserSlot{

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
	 * 注册
	 * @param loginUserVO
	 */
	@RequestMapping(value = "/register")
	public void register(@RequestBody LoginUserVO loginUserVO) {
		loginUserService.register(loginUserVO);
	}
	
	/**
	 * 根据账号查询用户
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/getUserByEmail")
	public LoginUserEntity getUserByEmail(@RequestParam String email) {
		return loginUserService.getUserByEmail(email);
	}
}
