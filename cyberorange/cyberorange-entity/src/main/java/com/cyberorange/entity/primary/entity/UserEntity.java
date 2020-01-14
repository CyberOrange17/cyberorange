package com.cyberorange.entity.primary.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 
 */
@Data
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Long id;

	/**
	 * 登录用户ID
	 */
    private Long loginId;

	/**
	 * 所在地
	 */
    private String address;

	/**
	 * 等级
	 */
    private Integer level;

	/**
	 * 认证标识
	 */
    private Integer label;

	/**
	 * 创建时间
	 */
    private Date createTime;

	/**
	 * 更新时间
	 */
    private Date updateTime;
}