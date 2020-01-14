package com.cyberorange.console.primary.vo;

import com.cyberorange.console.primary.entity.UserEntity;
import com.cyberorange.primary.entity.UserEntity;
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
