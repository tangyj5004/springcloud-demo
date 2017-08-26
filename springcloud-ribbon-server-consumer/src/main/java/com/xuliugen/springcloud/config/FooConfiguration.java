package com.xuliugen.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如果被扫描的话，该配置会应用所有的RibbonClient
 * Created by xuliugen on 2017/7/26.
 */
@Configuration
public class FooConfiguration {

//    @Autowired
//    private IClientConfig config;

//    @Bean
//    public IRule ribbonRule(IClientConfig config) {
//        return new RandomRule();
//    }

    /**
     * 自定义的路由规则
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
