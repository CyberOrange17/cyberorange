package com.cyberorange.feign.primary.index;

import com.cyberorange.commom.constants.GlobalAttributes;
import com.cyberorange.primary.entity.LoginUserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = GlobalAttributes.EUREKA_PRIMARY)
public interface UserClient {

	@RequestMapping(value = "/user/getUserBySession")
	public LoginUserEntity getUserBySession();
}
