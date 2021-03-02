package com.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.cons.GlobalParams;

//通过@Configuration注解来表明该类是一个Spring的配置，相当于一个xml文件
@Configuration
@ComponentScan(basePackages = "com.spring.cons")
@PropertySource(value = { "classpath:config.properties"})
public class UserSpringConfig {
  
    @Bean
    public GlobalParams user(){
        return new GlobalParams();
    }
    
}