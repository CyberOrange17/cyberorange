package com.cyberorange.console.config.interceptor;

import com.cyberorange.client.primary.login.LoginUserClient;
import com.cyberorange.console.utils.CookieUtils;
import com.cyberorange.utils.CookieUtils;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 * @author 黄传举
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginUserClient loginUserClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取cookie中的token
        CookieUtils.getCookieValue(request, )
        return false;
    }
}
