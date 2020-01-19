package com.cyberorange.primary.cache;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LoginUserCachePO implements Serializable {
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录凭证
     */
    private String token;

    private static final String prefix = "LOGIN_USER";
    private static final String SPLIT = ":";

    public String getKey(){
        return prefix + SPLIT + this.account;
    }
}
