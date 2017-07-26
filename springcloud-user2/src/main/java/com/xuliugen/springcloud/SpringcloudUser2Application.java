package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudUser2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudUser2Application.class, args);
    }
}
