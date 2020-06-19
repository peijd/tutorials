package com.ripjava.importannotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { BirdConfig.class, CatConfig.class, DogConfig.class })
// @ContextConfiguration(classes = {AnimalConfig.class})
@ContextConfiguration(classes = {ElephantConfig.class})
public class ImportConfigTest {
    @Autowired
    ApplicationContext context;

    @Test
    void test_getBean() {
        assertThatBeanExists("dog", Dog.class);
        assertThatBeanExists("cat", Cat.class);
        assertThatBeanExists("bird", Bird.class);
    }

    @Test
    void test_getElephantBean() {
        assertThatBeanExists("elephant", Elephant.class);
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        assertTrue(context.containsBean(beanName));
        assertNotNull(context.getBean(beanClass));
    }
}