package com.beauty.basic.datasource.persistent.mybatis.daos.implementations;

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

}
