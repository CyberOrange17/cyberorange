package com.nogame.myenum;

public class GlobalAttributes {
	/**
	 * spring cloud euraka 应用名
	 */
	public static final String EURAKA_PRIMARY = "nogame-primary-slot";
	
	
	/**
	 * path
	 */
	public static final String PATH_LOGINGLOBAL = "/**";
	public static final String[] PATH_LOGINEXCLUDE = {"/login.html","/register.html"};
	/**
	 * session
	 */
	public static final String SESSION_USER = "session_user";
	
}
