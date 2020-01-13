package com.cyberorange.primary.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 登录用户表
 */
@Data
public class LoginUserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Long id;

	/**
	 * 账号
	 */
    private String account;

	/**
	 * 昵称
	 */
    private String name;

	/**
	 * 密码
	 */
    private String password;

	/**
	 * 手机号
	 */
    private String phone;

	/**
	 * 邮箱
	 */
    private String email;

	/**
	 * QQ
	 */
    private String qq;

	/**
	 * 创建时间
	 */
    private Date createTime;

	/**
	 * 修改时间
	 */
    private Date updateTime;
}