package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用Feign和Hyxstric的结合
 * FallbackFactory和Fallback不可同时使用
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker  //开启Hyxstric的自动配置
public class FeignWithHyxstricApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignWithHyxstricApplication.class, args);
    }
}