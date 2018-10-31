package com.lovnx.servicepublic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.feign.hystrix","com.lovnx.servicepublic"})
@EnableFeignClients(basePackages = {"com.feign.client"})
@EnableAutoConfiguration
public class ServicePublicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePublicApplication.class, args);
    }


}
