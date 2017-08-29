package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * FallbackFactory和Fallback不可同时使用
 * Created by xuliugen on 2017/8/29.
 */
@FeignClient(name = "user-server-provider", fallbackFactory = HelloClientFallbackFactory.class)
public interface HelloClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getById(@PathVariable("id") String id);
}
