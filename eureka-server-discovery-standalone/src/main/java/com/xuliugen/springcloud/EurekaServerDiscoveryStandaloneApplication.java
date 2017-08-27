package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDiscoveryStandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerDiscoveryStandaloneApplication.class, args);
	}
}
