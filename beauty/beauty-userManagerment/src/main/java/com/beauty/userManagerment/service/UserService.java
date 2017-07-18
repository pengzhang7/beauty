package com.beauty.userManagerment.service;

import com.beauty.basic.datasource.domain.UserInfo;
import com.beauty.basic.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pengzhang.
 */
@Service
public class UserService {
    @Autowired
    private UserBaseService userBaseService;

    /**
     * 创建用户
     * @param user 用户信息对象
     * @return true:false
     */
    public boolean createUser(UserInfo user) {
        return userBaseService.createUser(user) > 0;
    }
}
