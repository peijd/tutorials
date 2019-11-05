package com.ripjava.spring.properties.yaml;

import com.ripjava.spring.properties.reloading.SpringPropertiesApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = YamlConfigApplication.class)
public class YamlConfigTest {
    @Autowired
    private YAMLConfig myConfig;

    @Test
    public void test_YamlConfig(){
        assertEquals("prod-YAML", myConfig.getName());
        assertEquals("production", myConfig.getEnvironment());
        assertEquals(Arrays.asList("www.abc.com", "www.xyz.com"), myConfig.getServers());
    }
}
