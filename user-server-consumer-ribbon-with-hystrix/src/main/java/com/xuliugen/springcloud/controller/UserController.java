package com.xuliugen.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xuliugen.springcloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/user/hyxstric")
public class UserController {

    @Autowired //已经支持负载均衡的
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 使用硬编码的方式消费服务
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getByIdFallBack")
    @GetMapping(value = "/{id}")
    public User getById(@PathVariable String id) {
        return this.restTemplate.getForObject("http://user-server-provider/user/" + id, User.class);
    }

    public User getByIdFallBack(String id) {
        return new User("默认Id", "默认name", "默认password", "默认sex", 21);
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
