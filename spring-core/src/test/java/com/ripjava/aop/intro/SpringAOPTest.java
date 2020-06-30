package com.ripjava.aop.intro;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {
    @Test
    public void test_springAOP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-intro.xml");
        context.getBean(SampleAdder.class).add(1,3);
    }
}
