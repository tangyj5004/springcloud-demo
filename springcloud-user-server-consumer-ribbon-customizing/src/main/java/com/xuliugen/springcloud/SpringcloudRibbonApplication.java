package com.xuliugen.springcloud;

import com.xuliugen.springcloud.ruleconfig.ExcludeFromComponent;
import com.xuliugen.springcloud.ruleconfig.FooConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 使用Java代码配置路由规则
 */
@SpringBootApplication
@EnableEurekaClient
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = FooConfiguration.class))
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponent.class))
@RibbonClient(name = "springcloud-user-server-provider", configuration = FooConfiguration.class)
public class SpringcloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonApplication.class, args);
    }
}
