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
	 * @param loginUserVO
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse<LoginUserEntity> login(@RequestBody LoginUserVO loginUserVO) {
		return loginRequest(loginUserVO);
	}
	
	/**
	 * 注册
	 * @param loginUserVO
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse<LoginUserVO> register(@RequestBody LoginUserVO loginUserVO) {
		loginUserClient.register(loginUserVO);
		return RestResponse.createSuccessResponse();
	}

	
	
	/**
	 * 校验账号是否已注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/checkRegisterAccount", method = RequestMethod.POST)
	public RestResponse<LoginUserEntity> checkRegisterAccount(@RequestBody LoginUserVO loginUserVO) {
		LoginUserEntity existUser = loginUserClient.getUserByAccount(loginUserVO.getAccount());
		RestResponse<LoginUserEntity> response = RestResponse.createSuccessResponse();
		if (existUser != null) {
			response.setStatus(ResponseCode.repeat.getCode());
			response.setMsg(ResponseTips.REGISTERERROR_USEREXIST);
		}
		return response;
	}
	
	/**
	 * 校验邮箱是否已注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/checkRegisterEmail", method = RequestMethod.POST)
	public RestResponse<LoginUserEntity> checkRegisterEmail(@RequestBody LoginUserVO loginUserVO) {
		LoginUserEntity existUser = loginUserClient.getUserByEmail(loginUserVO.getEmail());
		RestResponse<LoginUserEntity> response = RestResponse.createSuccessResponse();
		if (existUser != null) {
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
	private RestResponse<LoginUserEntity> loginRequest(LoginUserVO loginUser) {
		try {
			LoginUserToken token = new LoginUserToken(loginUser.getAccount(), loginUser.getPassword(), loginUser.getLoginType());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return RestResponse.createSuccessResponse();
		} catch (Exception e) {
			return RestResponse.createErrorResponseWithMsg();
		}
	}
}
