package com.nogame.primary.entity;

/**
 * 用户资料信息
 * 
 * @author 黄传举
 *
 */
public class UserEntity {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 昵称
	 */
	private String name;

	/**
	 * 性别
	 */
	private int gender;
	
	/**
	 * 头像
	 */
	private String headImg;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
}
