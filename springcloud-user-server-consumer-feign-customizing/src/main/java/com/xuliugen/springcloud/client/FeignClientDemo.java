package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.config.AuthConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xuliugen on 2017/8/26.
 */
@FeignClient(name = "xxx", url = "http://localhost:8761/", configuration = AuthConfiguration.class)
public interface FeignClientDemo {

    /**
     * 获取微服务信息
     * @param serviceName 微服务名称
     * @return
     */
    @RequestMapping("/eureka/apps/{serviceName}")
    public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
