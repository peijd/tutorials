package com.ripjava.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages="com.ripjava.primary")
public class Config {

    @Bean
    public Employee AEmployee() {
        return new Employee("A");
    }

    @Bean
    @Primary
    public Employee BEmployee() {
        return new Employee("B");
    }
}
