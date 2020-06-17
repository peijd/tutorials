package com.ripjava.injectstaticvalue;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/application.properties")
@ComponentScan(basePackageClasses = {AppConfig.class})
public class AppConfig {
}
