package com.ripjava.beanfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeanFactoryTest {

    @Test
    public void test_BeanFactoryMethod() {
//        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
//        reader.loadBeanDefinitions(new ClassPathResource("beanfactory-example.xml"));
//        BeanFactory factory =  (BeanFactory)reader.getBeanFactory();
        Resource res = new ClassPathResource("beanfactory-example.xml");
        BeanFactory factory = new XmlBeanFactory(res);
        User user = (User) factory.getBean("user");

        assertTrue(factory.isSingleton("user"));
        assertTrue(factory.getBean("user") instanceof User);
        assertTrue(factory.isTypeMatch("user", User.class));
        assertTrue(factory.getAliases("user").length > 0);
    }
}
