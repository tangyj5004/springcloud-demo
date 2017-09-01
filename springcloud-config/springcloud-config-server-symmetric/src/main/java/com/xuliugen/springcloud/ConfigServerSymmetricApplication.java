package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 对称加密
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerSymmetricApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerSymmetricApplication.class, args);
    }
}
