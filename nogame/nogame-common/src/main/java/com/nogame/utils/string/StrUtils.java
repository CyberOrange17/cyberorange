package com.nogame.utils.string;

/**
 * 字符串工具
 * @author 黄传举
 */
public class StrUtils {
	
	/**
	 * 判断为空或空字符串
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		return (str == null || "".equals(str));
	}
}
