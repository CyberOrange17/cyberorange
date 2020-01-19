package com.cyberorange.console.controller.login;

import com.cyberorange.commom.bean.RestResponse;
import com.cyberorange.commom.constants.ResponseTips;
import com.cyberorange.commom.constants.UserAttributes;
import com.cyberorange.commom.myenum.ResponseCode;
import com.cyberorange.console.config.shiro.LoginUserToken;
import com.cyberorange.feign.primary.login.LoginUserCacheClient;
import com.cyberorange.feign.primary.login.LoginUserClient;
import com.cyberorange.primary.entity.LoginUserEntity;
import com.cyberorange.primary.vo.LoginUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 登陆管理
 *
 * @author 黄传举
 */
@Controller
@RequestMapping("/loginUser")
public class LoginUserController {

    @Autowired
    private LoginUserClient loginUserClient;

    @Autowired
    private LoginUserCacheClient loginUserCacheClient;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String toLogin() {
        return "login/login.html";
    }

    /**
     * 登录
     *
     * @param loginUserVO
     * @return
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<LoginUserEntity> login(@RequestBody LoginUserVO loginUserVO, HttpServletRequest request) {
        String token = loginRequest(loginUserVO);
        if(token != null){
            initUserSession(request, token);
            return RestResponse.createSuccessResponse();
        }
        return RestResponse.createErrorResponseWithMsg();
    }


    /**
     * 注册
     *
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
     *
     * @param loginUserVO
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
     *
     * @param loginUserVO
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
     *
     * @param loginUser
     * @return
     */
    private String loginRequest(LoginUserVO loginUser) {
        try {
            LoginUserToken token = new LoginUserToken(loginUser.getAccount(), loginUser.getPassword(), loginUser.getLoginType());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            Subject currentUser = SecurityUtils.getSubject();
            if(currentUser.isAuthenticated()){
                String backToken = loginUserCacheClient.loginUserInfo(loginUser);
                return backToken;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private void initUserSession(HttpServletRequest request, String token){
        request.getSession().setAttribute(UserAttributes.LOGIN_USER_SESSION, token);
    }
}
