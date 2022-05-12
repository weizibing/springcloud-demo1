package com.wei.goodsprovider;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 能够被注册中心发现 扫描到此服务
@EnableEurekaClient
@MapperScan("com.wei.goodsprovider.dao")
@EnableCircuitBreaker
public class GoodsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderApplication.class, args);
    }

    @Bean
    // 配置收集数据流的 servlet
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet);
        registrationBean.setName("HystrixMetricsStreamServlet");
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }

}
