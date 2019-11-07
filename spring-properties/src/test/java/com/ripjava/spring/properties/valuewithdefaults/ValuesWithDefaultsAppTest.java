package com.ripjava.spring.properties.valuewithdefaults;


import com.ripjava.spring.properties.ConfigPropertiesDemoApplication;
import com.ripjava.spring.properties.yaml.YamlConfigApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@TestPropertySource(value = "classpath:valueswithdefaults.properties")
@SpringBootTest(classes = ConfigPropertiesDemoApplication.class)
public class ValuesWithDefaultsAppTest {
    @Value("${some.key:my default value}")
    private String stringWithDefaultValue;

    @Value("${some.key:}")
    private String stringWithBlankDefaultValue;

    @Value("${some.key:true}")
    private boolean booleanWithDefaultValue;

    @Value("${some.key:42}")
    private int intWithDefaultValue;

    @Value("${some.key:one,two,three}")
    private String[] stringArrayWithDefaults;

    @Value("${some.key:1,2,3}")
    private int[] intArrayWithDefaults;

    @Value("#{systemProperties['some.key'] ?: 'my default system property value'}")
    private String spelWithDefaultValue;


    @Test
    public void test_ValuesWithDefaults() {

        assertEquals(stringWithDefaultValue, "my default value");
        assertEquals(stringWithBlankDefaultValue, "");


        assertTrue(booleanWithDefaultValue);
        assertTrue(intWithDefaultValue == 42);

        List<String> stringListValues = Arrays.asList("one", "two", "three");
        assertArrayEquals(stringArrayWithDefaults, stringListValues.toArray());

        List<Integer> intListValues = Arrays.asList(1, 2, 3);
        assertEquals(IntStream.of(intArrayWithDefaults).boxed().collect(Collectors.toList()), intListValues);

        assertEquals(spelWithDefaultValue, "my default system property value");
    }

}
