package com.ripjava.spring.aop.ann.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {Config.class})
@EnableAspectJAutoProxy
public class Config {

}
