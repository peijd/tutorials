package com.ripjava.spring.aop.ann.aspectj;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {

    @Test
    public void test_Aspect(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        EmployeeManager manager = context.getBean(EmployeeManager.class);
        manager.getEmployeeById(1);
        manager.createEmployee(new EmployeeDTO());
    }
}
