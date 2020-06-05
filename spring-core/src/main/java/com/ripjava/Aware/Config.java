package com.ripjava.Aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "customBeanName")
    public BeanName customBeanName() {
        return new BeanName();
    }

    @Bean
    public MyBeanFactory getMyBeanFactory() {
        return new MyBeanFactory();
    }
}

