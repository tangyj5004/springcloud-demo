package config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 停掉某一个Hyxstric的支持
 * <p>
 * 同样该配置不应该扫描，以免全部都有效
 * Created by xuliugen on 2017/8/29.
 */
@Configuration
public class WithoutHyxstricConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
