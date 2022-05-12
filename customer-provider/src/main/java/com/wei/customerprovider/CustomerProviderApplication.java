package com.wei.customerprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wei.customerprovider.dao")
public class CustomerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerProviderApplication.class, args);
    }

}
