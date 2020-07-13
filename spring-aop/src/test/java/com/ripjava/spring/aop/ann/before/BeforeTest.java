package com.ripjava.spring.aop.ann.before;

import com.ripjava.spring.aop.ann.aspectj.Config;
import com.ripjava.spring.aop.ann.services.EmployeeDTO;
import com.ripjava.spring.aop.ann.services.EmployeeManager;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeTest {
    @Test
    public void test_Aspect_Before(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(BeforeConfig.class);
        EmployeeManager manager = context.getBean(EmployeeManager.class);
        manager.getEmployeeById(1);
        manager.createEmployee(new EmployeeDTO());
    }

    @Test
    public void test_Aspect_BeforeByXML(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-before.xml");
        EmployeeManager manager = context.getBean(EmployeeManager.class);
        manager.getEmployeeById(1);
        manager.createEmployee(new EmployeeDTO());
    }
}
