package com.cyberorange.console.config.shiro;

import com.cyberorange.console.config.shiro.loginway.LoginWay;
import com.cyberorange.primary.entity.LoginUserEntity;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义realm
 * 
 * @author 黄传举
 */
public class ShiroRealm extends AuthorizingRealm {

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		LoginUserToken userToken = (LoginUserToken) token;
		LoginWay loginWay = userToken.getLoginWay();
		LoginUserEntity user = loginWay.getLoginUser();
		char[] password = userToken.getPassword();
		if (user != null && !loginWay.requiredPassword()) {
			userToken.setPassword(user.getPassword().toCharArray());
			password = user.getPassword().toCharArray();
		}
		return new SimpleAuthenticationInfo(user, password, this.getName());
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
