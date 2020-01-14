package com.cyberorange.primary.mapper;

import com.cyberorange.entity.primary.vo.UserVO;
import com.cyberorange.primary.mapper.base.BaseUserMapper;
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