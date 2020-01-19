package com.cyberorange.console.config.interceptor;

import com.cyberorange.commom.constants.UserAttributes;
import com.cyberorange.console.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 * @author 黄传举
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        log.info("path:[{}] enter into LoginInterceptor", request.getRequestURI());
        // 获取cookie中的token
        String cookieValue = CookieUtils.getCookieValue(request, UserAttributes.LOGIN_USER_SESSION);
        return false;
    }
}
