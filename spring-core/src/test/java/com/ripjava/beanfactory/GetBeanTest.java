package com.ripjava.beanfactory;

import com.ripjava.beanfactory.getbean.Animal;
import com.ripjava.beanfactory.getbean.AnnotationConfig;
import com.ripjava.beanfactory.getbean.Bull;
import com.ripjava.beanfactory.getbean.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetBeanTest {

    @Test
    public void text_getBeanByName() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Object dog = context.getBean("dog");

        assertEquals(Dog.class, dog.getClass());
    }

    @Test
    public void text_getBeanByNameWithException() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        assertThrows(ClassCastException.class, () -> {
            Bull bull = (Bull) context.getBean("dog");
        });
    }

    @Test
    public void text_getBeanByNameAndType() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Dog dog = context.getBean("dog", Dog.class);

        assertEquals("dog", dog.getName());
    }

    @Test
    public void text_getBeanByNameAndTypeWithException() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        assertThrows(BeanNotOfRequiredTypeException.class, () -> {
           context.getBean("dog", Bull.class);
        });
    }

    @Test
    public void text_getBeanByTypeAndConstructor() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Bull bull = context.getBean(Bull.class, "test");

        assertEquals("test", bull.getName());
    }

    @Test
    public void text_getBeanByTypeConstructor2() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        Bull redBull = context.getBean(Bull.class, "redBull");
        Bull blackBull = context.getBean(Bull.class, "blackBull");

        assertEquals("redBull", redBull.getName());
        assertEquals("blackBull", blackBull.getName());
    }

    @Test
    public void text_getBeanByNameAndConstructor() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Bull bull = (Bull)context.getBean("cattle", "test");

        assertEquals("test", bull.getName());
    }
}
