package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务发现 服务发现的Server
 * 将服务注册到Eureka上
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerDiscoveryApplication.class, args);
    }
}
