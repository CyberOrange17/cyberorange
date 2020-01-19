package com.cyberorange.console.config.interceptor.config;

import com.cyberorange.console.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 * @author 黄传举
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor());
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/login**/**" ,"/home/**", "/static/**", "/error");
    }

    /**
     * 登录拦截器
     * @return
     */
    @Bean("loginInterceptor")
    public HandlerInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
}
