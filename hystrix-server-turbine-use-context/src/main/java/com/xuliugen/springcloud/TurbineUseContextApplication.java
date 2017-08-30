package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class TurbineUseContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineUseContextApplication.class, args);
    }
}