package com.beauty.basic.datasource.persistent.mybatis.mappers;

import com.beauty.basic.datasource.domain.UserInfo;

/**
 * 用户相关数据Mapper
 */
public interface UserMapper {
    /**
     * 创建用户
     *
     * @param userInfo 用户信息
     * @return >0:创建成功
     */
    int createUser(UserInfo userInfo);
}
