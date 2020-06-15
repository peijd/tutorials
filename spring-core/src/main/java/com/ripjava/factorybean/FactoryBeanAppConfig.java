package com.ripjava.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanAppConfig {

    @Bean(name = "MyBean")
    public MyFactoryBean myFactoryBean() {
        MyFactoryBean factory = new MyFactoryBean();
        factory.setFactoryId(8888);
        factory.setBeanId(2);
        return factory;
    }

}
