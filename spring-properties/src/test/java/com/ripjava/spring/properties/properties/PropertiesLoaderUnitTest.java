package com.ripjava.spring.properties.properties;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesLoaderUnitTest {

    @Test
    public void test_loadProperties() throws IOException {
        final String RESOURCE_FILE_NAME = "configuration.properties";

        final String SAMPLE_CONF_ENTRY = "sampleConfEntry";
        final String COLON_SEPARATED_CONF_ENTRY = "colonSeparatedEntry";

        final String GIVEN_CONF_ENTRY_VALUE = "sample String value";
        final String COLON_SEPARATED_CONF_ENTRY_VALUE = "colon separated entry value";

        Properties config = PropertiesLoader.loadProperties(RESOURCE_FILE_NAME);
        String sampleConfEntryValue = config.getProperty(SAMPLE_CONF_ENTRY);
        String colonSeparatedConfEntryValue = config.getProperty(COLON_SEPARATED_CONF_ENTRY);

        assertEquals(GIVEN_CONF_ENTRY_VALUE, sampleConfEntryValue);
        assertEquals(COLON_SEPARATED_CONF_ENTRY_VALUE, colonSeparatedConfEntryValue);

    }
}
