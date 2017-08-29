package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.bean.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 可以查看失败的原因
 * Created by xuliugen on 2017/8/29.
 */
@Component
public class HelloClientFallbackFactory implements FallbackFactory<HelloClient> {

    @Override
    public HelloClient create(final Throwable cause) {

        return new HelloClient() {
            @Override
            public User getById(String id) {
                return new User();
            }
        };
    }
}