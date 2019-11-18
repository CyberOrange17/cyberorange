package com.cyberorange.controller.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cyberorange.client.primary.LoginUserClient;
import com.cyberorange.common.RestResponse;
import com.cyberorange.config.shiro.LoginUserToken;
import com.cyberorange.myenum.ResponseCode;
import com.cyberorange.myenum.ResponseTips;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.vo.LoginUserVO;
import com.cyberorange.utils.string.StrUtils;

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
		return new ModelAndView("/cyberorange/views/login/login.html");
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse<LoginUserVO> login(@RequestBody LoginUserVO loginUserVO) {
		return RestResponse.createSuccessResponseWithMsg(loginUserVO, loginRequest(loginUserVO));
	}

	/**
	 * 校验账号是否已注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/checkRegisterAccount", method = RequestMethod.POST)
	public RestResponse<LoginUserEntity> checkRegisterAccount(@RequestBody LoginUserEntity user) {
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
	 * 登录验证
	 * @param loginUser
	 * @return
	 */
	private String loginRequest(LoginUserVO loginUser) {
		try {
			LoginUserToken token = new LoginUserToken(loginUser.getAccount(), loginUser.getPassword(), loginUser.getLoginType());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return null;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
