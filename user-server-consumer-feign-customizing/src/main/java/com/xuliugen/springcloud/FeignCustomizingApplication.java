package com.xuliugen.springcloud;

import com.xuliugen.springcloud.feignclientconfig.ExcludeFromComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 使用自定义的FeignClient
 */
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponent.class))
@EnableEurekaClient
@EnableFeignClients
public class FeignCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignCustomizingApplication.class, args);
    }
}
