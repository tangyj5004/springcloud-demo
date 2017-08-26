package com.xuliugen.springcloud.controller;

import com.xuliugen.springcloud.client.FeignClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/feign/serviceName")
public class EurekaController {

    @Autowired
    private FeignClientDemo feignClient;

    /**
     * 请求URL:http://localhost:9081/feign/serviceName/user-server-provider
     * @param serviceName
     * @return
     */
    @GetMapping(value = "/{serviceName}")
    public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return feignClient.findEurekaByServiceName(serviceName);
    }

}
