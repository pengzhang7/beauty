package com.beauty.basic.datasource.persistent.mybatis.daos.interfaces;

import com.beauty.basic.datasource.domain.UserInfo;

/**
 * 用户相关dao
 */
public interface User {
    /**
     * 创建用户
     *
     * @param userInfo 用户信息
     * @return >0:创建成功
     */
    int createUser(UserInfo userInfo);

}
