package com.wei.goodsui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author weizibing
 * @date 2022/5/9 9:39
 */
@Configuration
public class AppConfig {
    // Ribbon 调用使用的是 RestTemplate 对象
    // 负载均衡 设置
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
