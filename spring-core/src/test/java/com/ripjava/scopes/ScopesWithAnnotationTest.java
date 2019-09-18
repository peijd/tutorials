package com.ripjava.scopes;

import com.ripjava.profiles.SpringProfilesConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ScopesConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ScopesWithAnnotationTest {

    private static final String NAME = "Test NAME";
    private static final String NAME_OTHER = "Test NAME OTHER";
    @Autowired
    ApplicationContext context;

    @Test
    public void test_SingletonScope() {

        Person personSingletonA = (Person) context.getBean("personSingleton");
        Person personSingletonB = (Person) context.getBean("personSingleton");

        personSingletonA.setName(NAME);
        assertEquals(NAME, personSingletonB.getName());
    }

    @Test
    public void test_PrototypeScope() {
        Person personPrototypeA = (Person) context.getBean("personPrototype");
        Person personPrototypeB = (Person) context.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        assertEquals(NAME, personPrototypeA.getName());
        assertEquals(NAME_OTHER, personPrototypeB.getName());
    }
}
