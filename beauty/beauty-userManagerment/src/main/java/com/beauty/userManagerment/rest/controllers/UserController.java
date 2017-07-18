package com.beauty.userManagerment.rest.controllers;

import com.beauty.basic.datasource.domain.UserInfo;
import com.beauty.basic.domain.HttpMessage;
import com.beauty.userManagerment.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pengzhang7.
 */
@Controller
@RequestMapping(value = "/api/beauty")
@Api(value = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return httpmessage
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "创建用户接口", notes = "创建用户接口", response = HttpMessage.class)
    public HttpMessage<Boolean> create(@RequestBody UserInfo user) {
        boolean isSuccess = userService.createUser(user);
        return new HttpMessage<>(isSuccess, "请求成功");
    }
}
