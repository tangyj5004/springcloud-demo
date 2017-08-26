package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.bean.User;
import com.xuliugen.springcloud.feignclientconfig.ExcludeFromComponent;
import com.xuliugen.springcloud.feignclientconfig.FooConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by xuliugen on 2017/8/26.
 */
@FeignClient(name = "springcloud-user-server-provider", configuration = FooConfiguration.class)
@ExcludeFromComponent
public interface UserFeignClient {

    @RequestLine("GET /user/{id}")
    User getById(@Param("id") String id);

}
