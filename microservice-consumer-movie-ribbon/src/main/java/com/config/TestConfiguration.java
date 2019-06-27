package com.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的ribbon的规则时不能在默认的扫描包下面
 */
@Configuration
public class TestConfiguration {

    @Bean
    public IRule ribbonRule() {
        //负载均衡，随机规则
        return new RandomRule();
    }


}
