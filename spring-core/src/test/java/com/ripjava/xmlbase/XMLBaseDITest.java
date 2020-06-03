package com.ripjava.xmlbase;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XMLBaseDITest {

    @Test
    public void test_DIBySetter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml-base-di.xml");
        IndexApp indexApp = applicationContext.getBean("indexApp", IndexApp.class);
        assertNotNull(indexApp);
    }

    @Test
    public void test_DIByConstructor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml-base-di.xml");
        IndexApp indexApp = applicationContext.getBean("indexApp2", IndexApp.class);
        assertNotNull(indexApp);
    }

    @Test
    public void test_DIByStaticFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml-base-di.xml");
        IndexApp indexApp = applicationContext.getBean("indexApp3", IndexApp.class);
        assertNotNull(indexApp);
    }

    @Test
    public void test_DIByFactoryMethod() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml-base-di.xml");
        IndexApp indexApp = applicationContext.getBean("indexApp4", IndexApp.class);
        assertNotNull(indexApp);
    }

}
