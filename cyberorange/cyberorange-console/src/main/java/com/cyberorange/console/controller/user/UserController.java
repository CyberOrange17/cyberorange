package com.cyberorange.console.controller.user;

import com.cyberorange.feign.primary.login.LoginUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登陆管理
 *
 * @author 黄传举
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginUserClient loginUserClient;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/card.html", method = RequestMethod.GET)
    public String toLogin() {
        return "login/login.html";
    }
}
