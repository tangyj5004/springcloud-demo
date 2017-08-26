package com.xuliugen.springcloud.controller;

import com.xuliugen.springcloud.bean.User;
import com.xuliugen.springcloud.client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/user/property")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") String id) {
        return userFeignClient.getById(id);
    }

    /**
     * 使用负载均衡的方式显示消费的那一他主机的服务
     */
    @GetMapping(value = "/loadBalancerClient")
    public void loadBalancerClient() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-server-provider");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }

}
