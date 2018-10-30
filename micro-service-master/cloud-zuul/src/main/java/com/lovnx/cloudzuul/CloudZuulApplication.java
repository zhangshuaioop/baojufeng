package com.lovnx.cloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class CloudZuulApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudZuulApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {

        return new AccessFilter();

    }

}
