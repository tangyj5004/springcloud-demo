package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RibbonWithoutEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonWithoutEurekaApplication.class, args);
	}
}
