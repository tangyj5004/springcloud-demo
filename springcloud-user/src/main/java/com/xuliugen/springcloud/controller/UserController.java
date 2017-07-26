package com.xuliugen.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.xuliugen.springcloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping(value = "eureka-instance")
    public String eurekaInstance() {
        InstanceInfo instance = this.discoveryClient.getNextServerFromEureka("springcloud-user", false);
        return instance.getHomePageUrl();
    }

    @GetMapping
    public List<User> get() {
        List<User> users = assemberUsers();
        return users;
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable String id) {
        System.out.println("user-------");
        return new User("id:1", "xuliugen", "123456", "male", 24);
    }

    /***
     * 组装Users
     */
    private List<User> assemberUsers() {
        List<User> users = new ArrayList<User>(5);
        User user1 = new User("id:1", "xuliugen", "123456", "male", 24);
        User user2 = new User("id:2", "zhangsan", "234567", "male", 23);
        User user3 = new User("id:3", "lisi", "345678", "male", 25);
        User user4 = new User("id:4", "wangwu", "456789", "male", 26);
        User user5 = new User("id:5", "zhaoliu", "567890", "male", 21);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }
}
