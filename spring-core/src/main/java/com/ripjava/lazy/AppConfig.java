package com.ripjava.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ComponentScan(basePackages = "com.ripjava.lazy")
public class AppConfig {

    @Bean
    public Region getRegion(){
        return new Region();
    }

    @Bean
    public Country getCountry(){
        return new Country();
    }
}

