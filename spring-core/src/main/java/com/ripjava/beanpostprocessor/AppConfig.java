package com.ripjava.beanpostprocessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {AppConfig.class})
public class AppConfig {
}
