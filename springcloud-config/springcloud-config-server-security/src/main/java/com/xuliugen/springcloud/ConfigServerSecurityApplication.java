package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerSecurityApplication.class, args);
    }
}