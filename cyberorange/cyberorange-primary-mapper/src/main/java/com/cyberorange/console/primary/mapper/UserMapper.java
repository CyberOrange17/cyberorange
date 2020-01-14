package com.cyberorange.console.primary.mapper;

import com.cyberorange.primary.mapper.base.BaseUserMapper;

import com.cyberorange.primary.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MAPPER接口类
 */
@Mapper
public interface UserMapper extends BaseUserMapper {

    /**
     * 根据iD获取用户信息
     * @param id
     * @return
     */
    UserVO getUserBySession(Long id);
}