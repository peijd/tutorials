package com.ripjava.configurable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@ComponentScan({"com.ripjava.configurable"})
@EnableSpringConfigured
@EnableLoadTimeWeaving
public class ConfigurableAppConfig {


}
