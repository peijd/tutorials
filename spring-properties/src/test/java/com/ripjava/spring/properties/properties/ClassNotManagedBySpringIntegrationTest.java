package com.ripjava.spring.properties.properties;


import com.ripjava.spring.properties.ConfigPropertiesDemoApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClassNotManagedBySpringIntegrationTest {


    @MockBean
    private InitializerBean initializerBean;

    @BeforeEach
    public void init() {
        when(initializerBean.initClass())
                .thenReturn(new ClassNotManagedBySpring("This is only sample value", "Another configured value"));
    }
    @Test
    public void test_ClassNotManagedBySpring(){
        ClassNotManagedBySpring classNotManagedBySpring = initializerBean.initClass();

        String initializedValue = classNotManagedBySpring.getCustomVariable();
        String anotherCustomVariable = classNotManagedBySpring.getAnotherCustomVariable();

        assertEquals("This is only sample value", initializedValue);
        assertEquals("Another configured value", anotherCustomVariable);
    }

}
