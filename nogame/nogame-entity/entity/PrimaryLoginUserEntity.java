package com.nogame.primary.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录用户表
 */
public class PrimaryLoginUserEntity implements Serializable {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}