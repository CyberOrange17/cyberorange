package com.cyberorange.feign.primary.index;

import com.cyberorange.commom.myenum.GlobalAttributes;
import com.cyberorange.entity.primary.entity.LoginUserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = GlobalAttributes.EURAKA_PRIMARY)
public interface UserClient {

	@RequestMapping(value = "/user/getUserBySession")
	public LoginUserEntity getUserBySession();
}
