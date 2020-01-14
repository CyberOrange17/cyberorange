package com.cyberorange.primary.service;

import com.cyberorange.primary.vo.UserVO;
import com.cyberorange.service.basics.BasicsService;
import com.cyberorange.primary.entity.UserEntity;

/**
 * 服务接口类
 */
public interface UserService extends BasicsService<UserEntity> {

    /**
     *  获取资料卡用户信息
     * @param id
     * @return
     */
    UserVO getUserBySession(Long id);
}