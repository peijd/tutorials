package com.ripjava.scopes;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScopesWithXMLTest {

    private static final String NAME = "Test NAME";
    private static final String NAME_OTHER = "Test NAME OTHER";
    @Test
    public void test_SingletonScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("scopes.xml");
        Person personSingletonA = (Person) context.getBean("personSingleton");
        Person personSingletonB = (Person) context.getBean("personSingleton");
        personSingletonA.setName(NAME);
        assertEquals(NAME, personSingletonB.getName());
        ((AbstractApplicationContext) context).close();
    }

    @Test
    public void test_PrototypeScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("scopes.xml");
        Person personPrototypeA = (Person) context.getBean("personPrototype");
        Person personPrototypeB = (Person) context.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        assertEquals(NAME, personPrototypeA.getName());
        assertEquals(NAME_OTHER, personPrototypeB.getName());
        ((AbstractApplicationContext) context).close();
    }
}
