package com.nogame.provider.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nogame.primary.entity.LoginUserEntity;
import com.nogame.service.LoginUserService;

/**
 * 基础服务-用户登录
 * 
 * @author 黄传举
 */
@RestController
@RequestMapping("/loginUser")
public class LoginUserController {

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
		return loginUserService.getUserByAccount(account);
	}

	/**
	 * 验证账号密码
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/getUserByAccountAndPassword", method = RequestMethod.POST)
	public LoginUserEntity getUserByAccountAndPassword(@RequestBody LoginUserEntity loginUser) {
		return loginUserService.getUserByAccountAndPassword(loginUser.getAccount(), loginUser.getPassword());
	}
	
	/**
	 * 注册验证：根据用户名或邮箱判断是否已注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public LoginUserEntity check(LoginUserEntity user) {
		return loginUserService.selectOneByEntity(user);
	}
	
}
