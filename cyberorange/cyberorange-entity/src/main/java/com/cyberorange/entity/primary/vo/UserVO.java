package com.cyberorange.entity.primary.vo;

import com.cyberorange.entity.primary.entity.UserEntity;
import lombok.Data;

@Data
public class UserVO extends UserEntity {

    /**
     * 账号
     */
    private String account;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String name;
}
