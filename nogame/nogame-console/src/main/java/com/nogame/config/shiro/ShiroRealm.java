package com.nogame.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.nogame.config.shiro.loginway.LoginWay;
import com.nogame.myenum.ResponseTips;
import com.nogame.primary.entity.LoginUserEntity;

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
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UserToken userToken = (UserToken) token;
		LoginWay loginWay = userToken.getLoginWay();
		LoginUserEntity user = loginWay.getUser();
		if (user == null) {
			throw new AuthenticationException(ResponseTips.LOGINERROR_USERNOTEXIST);
		}
		if (loginWay.requriedPassword() && !loginWay.isPasswordMatch(user.getPassword())) {
			throw new AuthenticationException(ResponseTips.LOGINERROR_PASSWORDMISMATCH);
		}
		return new SimpleAuthenticationInfo(userToken.getUsername(), user.getPassword(), "ShiroReaml");
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
