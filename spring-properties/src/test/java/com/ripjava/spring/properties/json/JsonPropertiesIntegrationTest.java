package com.ripjava.spring.properties.json;

import com.ripjava.spring.properties.reloading.SpringPropertiesApplication;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ConfigPropertiesDemoApplication.class)
@ContextConfiguration(initializers = JsonPropertyContextInitializer.class)
public class JsonPropertiesIntegrationTest {
    @Autowired
    private JsonProperties jsonProperties;


    @Test
    public void test_JsonProperties() {
        assertEquals("mailer@mail.com", jsonProperties.getHost());
        assertEquals(9090, jsonProperties.getPort());
        assertTrue(jsonProperties.isResend());
    }


    @Test
    public void test_JsonProperties_ListValues() {
        MatcherAssert.assertThat(
                jsonProperties.getTopics(),
                Matchers.is(Arrays.asList("spring", "boot")));
    }


    @Test
    public void test_JsonProperties_NestedLoadedAsMap() {
        assertEquals("sender", jsonProperties.getSender().get("name"));
        assertEquals("street", jsonProperties.getSender().get("address"));
    }

    @Autowired
    CustomJsonProperties customJsonProperties;

    @Test
    public void test_CustomJsonProperties() {
        assertEquals("mailer@mail.com", customJsonProperties.getHost());
        assertEquals(9090, customJsonProperties.getPort());
        assertTrue(customJsonProperties.isResend());
    }


    @Test
    public void test_CustomJsonProperties_ListValues() {
        MatcherAssert.assertThat(
                customJsonProperties.getTopics(),
                Matchers.is(Arrays.asList("spring", "boot")));
    }


    @Test
    public void test_CustomJsonProperties_NestedLoadedAsObject() {
        assertNotNull(customJsonProperties.getSender());
        assertEquals("sender", customJsonProperties.getSender().getName());
        assertEquals("street", customJsonProperties.getSender().getAddress());
    }


}
