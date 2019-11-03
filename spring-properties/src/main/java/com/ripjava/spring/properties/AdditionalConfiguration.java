package com.ripjava.spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(AdditionalProperties.class)
@PropertySource("classpath:configprops.properties")
public class AdditionalConfiguration {

    @Autowired
    private AdditionalProperties additionalProperties;

}