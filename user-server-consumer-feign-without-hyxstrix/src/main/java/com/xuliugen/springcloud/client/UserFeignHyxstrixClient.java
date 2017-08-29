package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.bean.User;
import config.WithHyxstricConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * fallback指定了用到的Fallback
 * Created by xuliugen on 2017/8/26.
 */
@FeignClient(name = "user-server-provider", configuration = WithHyxstricConfiguration.class, fallback = UserHystrixClientFallback.class)
public interface UserFeignHyxstrixClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getById(@PathVariable("id") String id);
}
