package com.xuliugen.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.xuliugen.springcloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping(value = "eureka-instance")
    public String eurekaInstance() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("user-server-provider", false);
        return instance.getHomePageUrl();
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") String id) {
        System.out.println("user-------");
        return new User("id：" + id, "xuliugen", "123456", "male", 24);
    }

}
