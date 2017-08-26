package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用配置文件的方式配置Ribbon的使用方式
 * 和user-server-consumer-ribbon-customizing项目中使用代码的方式配置的效果是一样的，并且更简单
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonPropertyApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonPropertyApplication.class, args);
    }
}
