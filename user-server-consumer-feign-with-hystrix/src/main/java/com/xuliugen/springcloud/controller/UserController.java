package com.xuliugen.springcloud.controller;

import com.xuliugen.springcloud.bean.User;
import com.xuliugen.springcloud.client.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/user/feign-with-hystrix")
public class UserController {

    @Autowired
    private UserFeignHystrixClient userFeignHyxstrixClient;

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") String id) {
        return userFeignHyxstrixClient.getById(id);
    }

}
