package com.ripjava.resource;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceTest {


    @Test
    public void test_resourceReadByGetFile()
            throws IOException {
        File resource = new ClassPathResource("data/text.txt").getFile();
        String text = new String(Files.readAllBytes(resource.toPath()));
        assertEquals("this is test  text file", text);
    }
    @Test
    public void test_resourceReadByGetInputStream()
            throws IOException {
        InputStream resource = new ClassPathResource("data/text.txt").getInputStream();
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource)) ) {
            String text = reader.lines().collect(Collectors.joining("\n"));
            assertEquals("this is test  text file", text);
        }
    }
}
