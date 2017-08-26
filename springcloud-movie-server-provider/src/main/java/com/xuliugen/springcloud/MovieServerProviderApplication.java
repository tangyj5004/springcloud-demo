package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerProviderApplication.class, args);
    }
}
