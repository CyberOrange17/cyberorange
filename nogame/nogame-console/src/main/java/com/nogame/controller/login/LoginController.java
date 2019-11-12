package com.nogame.controller.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nogame.client.primary.LoginUserClient;
import com.nogame.common.RestResponse;
import com.nogame.config.shiro.UserToken;
import com.nogame.myenum.LoginType;
import com.nogame.myenum.ResponseCode;
import com.nogame.myenum.ResponseTips;
import com.nogame.primary.entity.LoginUserEntity;
import com.nogame.primary.entity.UserEntity;
import com.nogame.utils.string.StrUtils;

/**
 * 登陆管理
 * 
 * @author 黄传举
 */
@RestController
@RequestMapping("/loginUser")
public class LoginController {

	@Autowired
	private LoginUserClient loginUserClient;

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView toLogin() {
		return new ModelAndView("/nogame/views/login/login.html");
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public RestResponse<LoginUserEntity> login(LoginUserEntity user) {
		return RestResponse.createSuccessResponseWithMsg(user, login(user, LoginType.NORMAL));
	}

	/**
	 * 校验账号是否已注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/checkRegisterAccount", method = RequestMethod.POST)
	public RestResponse<LoginUserEntity> checkRegisterAccount(LoginUserEntity user) {
		LoginUserEntity existUser = loginUserClient.getUserByAccountAndPassword(user);
		RestResponse<LoginUserEntity> response = RestResponse.createSuccessResponse();
		if (StrUtils.isBlank(user.getAccount()) && existUser != null) {
			response.setStatus(ResponseCode.repeat.getCode());
			response.setMsg(ResponseTips.REGISTERERROR_USEREXIST);
		} else {
			response.setStatus(ResponseCode.repeat.getCode());
			response.setMsg(ResponseTips.REGISTERERROR_EMAILEXIST);
		}
		return response;
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	public RestResponse<UserEntity> logout() {
		return RestResponse.createSuccessResponse();
	}

	/**
	 * 登录验证
	 * 
	 * @param user
	 * @param type
	 * @return
	 */
	private String login(LoginUserEntity user, LoginType type) {
		try {
			UserToken token = new UserToken(user.getAccount(), user.getPassword(), type);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return null;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
