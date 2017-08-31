package com.xuliugen.springcloud;

import com.xuliugen.springcloud.filter.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 默认的Zuul已经添加了EnableDiscoveryClient注解
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterApplication.class, args);
    }

    @Bean
    public PreZuulFilter preZuulFilter() {
        return new PreZuulFilter();
    }
}
