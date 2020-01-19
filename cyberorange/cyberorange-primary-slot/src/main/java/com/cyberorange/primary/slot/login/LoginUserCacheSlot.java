package com.cyberorange.primary.slot.login;

import com.cyberorange.primary.service.LoginUserCacheService;
import com.cyberorange.primary.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础服务-登录用户缓存
 * 
 * @author 黄传举
 */
@RestController
@RequestMapping("/loginUserCache")
public class LoginUserCacheSlot {

	@Autowired
	private LoginUserCacheService loginUserCacheService;

	@RequestMapping(value = "/loginUserInfo", method = RequestMethod.POST)
	public String loginUserInfo(@RequestBody LoginUserVO loginUser){
		return loginUserCacheService.loginUserInfo(loginUser);
	}
}
