package com.xuliugen.springcloud.ruleconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如果被扫描的话，该配置会应用所有的RibbonClient，因此需要在SpringBootApplication排除扫描
 * <p>
 * 或者可以直接放在SpringBootApplication同级包的外边，eg:com.xuliugen.config下
 * Created by xuliugen on 2017/7/26.
 */
@Configuration
@ExcludeFromComponent
public class FooConfiguration {

    /**
     * 自定义的路由规则
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
