package com.xuliugen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * 默认的Zuul已经添加了EnableDiscoveryClient注解
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayZuulPatternApplication {

    /**
     * 使用这种方式的话，每一个serviceId的实例就需要是：user-server-provider-v1
     * 访问的URL格式为：http://192.168.1.213:8031/v1/user-server-provider/user/1
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayZuulPatternApplication.class, args);
    }
}
