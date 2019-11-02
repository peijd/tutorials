package com.ripjava.spring.properties.reloading;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileOutputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringPropertiesApplication.class)
public class PropertiesReloadIntegrationTest {


    protected long refreshDelay = 3000;

    @Autowired
    EnvironmentConfigBean environmentConfigBean;

    @Autowired
    Properties properties;

    @Test
    public void test_propertiesConfiguration() throws Exception {
        assertEquals("blue", environmentConfigBean.getColor());

        createConfig("extra.properties", "application.theme.color", "red");
        Thread.sleep(refreshDelay);

        assertEquals("red", environmentConfigBean.getColor());

        createConfig("extra.properties", "application.theme.color", "blue");
    }

    @Test
    public void test_PropertySourceFactory() throws Exception {
        assertEquals("red", environmentConfigBean.getBackgroundColor());

        createConfig("extra2.properties", "application.theme.background", "blue");
        Thread.sleep(refreshDelay);

        assertEquals("blue", environmentConfigBean.getBackgroundColor());

        createConfig("extra2.properties", "application.theme.background", "red");
    }

    @Test
    public void test_properties() throws Exception {
        assertEquals("blue", properties.getProperty("application.theme.color"));

        createConfig("extra.properties", "application.theme.color", "red");
        Thread.sleep(refreshDelay);

        assertEquals("red", properties.getProperty("application.theme.color"));

        createConfig("extra.properties", "application.theme.color", "blue");
    }


    public void createConfig(String file, String key, String value) throws Exception {
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(String
                .format("%s=%s", key, value)
                .getBytes());
        fo.close();
    }
}
