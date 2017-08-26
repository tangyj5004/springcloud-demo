package com.xuliugen.springcloud.feignclientconfig;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuliugen on 2017/7/26.
 */
@Configuration
@ExcludeFromComponent
public class FooConfiguration {

    /**
     * 契约
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

}
