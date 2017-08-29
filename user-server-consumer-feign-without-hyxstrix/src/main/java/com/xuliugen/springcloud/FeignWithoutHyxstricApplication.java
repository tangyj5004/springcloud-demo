package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用Feign和Hyxstric的结合
 * 一个Client使用Hyxstric一个不使用
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker  //开启Hyxstric的自动配置
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = WithoutHyxstricAnnotation.class))
public class FeignWithoutHyxstricApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignWithoutHyxstricApplication.class, args);
    }
}