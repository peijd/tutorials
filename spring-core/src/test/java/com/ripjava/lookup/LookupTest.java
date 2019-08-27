package com.ripjava.lookup;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class LookupTest {
    @Test
    public void test_lookup() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student1 = context.getBean("studentBean", Student.class);
        Student student2 = context.getBean("studentBean", Student.class);

        assertEquals(student1, student2);
        assertNotEquals(student1.getNotification("jason"), student2.getNotification("jason"));
        context.close();
    }

    @Test
    public void test_lookupAutowired() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentServices services = context.getBean(StudentServices.class);
        assertEquals("PASS", services.appendMark("a", 89));
        assertEquals("FAIL", services.appendMark("b", 44));
        assertEquals("PASS", services.appendMark("c", 96));
    }

}
