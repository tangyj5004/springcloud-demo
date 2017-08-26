package com.xuliugen.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/ribbon")
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/loadBalancerClient")
    public void loadBalancerClient() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-server-provider");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }

}
