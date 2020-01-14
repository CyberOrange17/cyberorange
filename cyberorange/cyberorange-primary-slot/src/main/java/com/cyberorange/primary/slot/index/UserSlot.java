package com.cyberorange.primary.slot.index;

import com.cyberorange.entity.primary.vo.UserVO;
import com.cyberorange.primary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
