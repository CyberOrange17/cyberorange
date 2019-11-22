package com.cyberorange.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.cyberorange.config.shiro.loginway.LoginWay;
import com.cyberorange.myenum.ResponseTips;
import com.cyberorange.primary.entity.LoginUserEntity;

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
		if (user == null || (loginWay.requriedPassword() && !loginWay.isPasswordMatch(user.getPassword()))) {
			throw new AuthenticationException(ResponseTips.LOGINERROR_USER_NOTMATCH);
		}
		return new SimpleAuthenticationInfo(userToken.getUsername(), user.getPassword(), "ShiroReaml");
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
