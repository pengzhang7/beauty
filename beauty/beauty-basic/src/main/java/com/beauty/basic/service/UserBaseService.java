package com.beauty.basic.service;

import com.beauty.basic.datasource.domain.UserInfo;
import com.beauty.basic.datasource.persistent.mybatis.daos.implementations.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pengzhang.
 */
@Service
public class UserBaseService {
    @Autowired
    private UserDao userDao;

    /**
     * 创建用户
     * @param user 用户信息
     * @return >0:成功
     */
    public int createUser(UserInfo user){
        return userDao.createUser(user);
    }
}
