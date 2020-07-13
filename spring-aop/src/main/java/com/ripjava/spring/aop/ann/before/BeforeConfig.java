package com.ripjava.spring.aop.ann.before;

import com.ripjava.spring.aop.ann.aspectj.Config;
import com.ripjava.spring.aop.ann.services.EmployeeManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {BeforeConfig.class, EmployeeManager.class})
@EnableAspectJAutoProxy
public class BeforeConfig {
}
