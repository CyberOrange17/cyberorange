package com.cyberorange.console.slot.index;

import com.cyberorange.console.primary.service.UserService;
import com.cyberorange.console.primary.vo.UserVO;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.entity.UserEntity;
import com.cyberorange.primary.service.LoginUserService;
import com.cyberorange.primary.service.UserService;
import com.cyberorange.primary.vo.LoginUserVO;
import com.cyberorange.primary.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础服务-用户
 * 
 * @author 黄传举
 */
@RestController
@RequestMapping("/user")
public class UserSlot {

	@Autowired
	private UserService userService;
	
	/**
	 * 根据账号查询用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getUserByAccount")
	public UserVO getUserBySession() {
		return userService.getUserBySession(null);
	}
}
