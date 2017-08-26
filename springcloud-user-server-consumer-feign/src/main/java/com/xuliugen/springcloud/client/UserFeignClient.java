package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xuliugen on 2017/8/26.
 */
@FeignClient("springcloud-user-server-provider")
public interface UserFeignClient {

    //1、只能使用Spring MVC提供的注解，即不可以使用GetMapping;
    //2、@PathVariable("id") 必须要加属性
    //3、这里的URL是springcloud-user-server-provider服务中具体的URL
    //4、使用get方式提交User对象的时候，不能直接使用(User user)进行传输，应使用(@PathVariable String id,...)
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getById(@PathVariable("id") String id);

}
