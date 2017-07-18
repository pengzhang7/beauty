package com.beauty.basic.datasource.persistent.mybatis.daos.implementations;

import com.beauty.basic.datasource.domain.UserInfo;
import com.beauty.basic.datasource.persistent.mybatis.daos.interfaces.User;
import com.beauty.basic.datasource.persistent.mybatis.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * userDao
 */
@Repository
public class UserDao implements User {

    @Autowired
    private UserMapper userMapper;

    /**
     * 创建用户
     * @param userInfo 用户信息对象
     * @return >0:成功
     */
    public int createUser(UserInfo userInfo) {
        return userMapper.createUser(userInfo);
    }
}
