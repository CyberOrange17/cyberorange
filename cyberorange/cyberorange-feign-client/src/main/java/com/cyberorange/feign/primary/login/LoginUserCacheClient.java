package com.cyberorange.feign.primary.login;

import com.cyberorange.commom.constants.GlobalAttributes;
import com.cyberorange.primary.vo.LoginUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = GlobalAttributes.EUREKA_PRIMARY)
public interface LoginUserCacheClient {

    /**
     * 保存用户登录信息
     * @param loginUser
     * @return token
     */
    @RequestMapping(value = "/loginUserCache/loginUserInfo", method = RequestMethod.POST)
    String loginUserInfo(LoginUserVO loginUser);
}
