package com.xuliugen.springcloud.controller;

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
@RequestMapping(value = "/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable String id) {
        return this.restTemplate.getForObject("http://springcloud-user/user/" + id, User.class);
    }

    @GetMapping(value = "/loadBalancerClient")
    public void loadBalancerClient() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud-user");
        //192.168.1.213:8081
        //192.168.1.213:8084
        //192.168.1.213:8081
        //192.168.1.213:8084
        //192.168.1.213:8081
        //192.168.1.213:8084
        //192.168.1.213:8081
        //192.168.1.213:8084
        //192.168.1.213:8081
        //192.168.1.213:8084
        //192.168.1.213:8081
        //192.168.1.213:8084
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }

}
