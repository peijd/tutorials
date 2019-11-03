package com.ripjava.spring.properties;

import com.ripjava.spring.properties.reloading.SpringPropertiesApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ConfigPropertiesDemoApplication.class)
public class ConfigPropertiesIntegrationTest {

    @Autowired
    private AdditionalProperties additionalProperties;

    @Test
    public void test_AdditionalProperties() {
       assertTrue(additionalProperties.getUnit().equals("km"));
       assertTrue(additionalProperties.getMax() == 100);
    }
}
