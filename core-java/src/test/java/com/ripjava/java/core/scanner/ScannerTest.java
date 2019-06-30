package com.ripjava.java.core.scanner;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class ScannerTest {
    @Test
    public void  test_ReadFileWithScanner() throws FileNotFoundException {
        System.out.println(new File(".").getAbsolutePath());
        Scanner scanner = new Scanner(new File("src/test/resources/text.txt"));
        assertThat(scanner.hasNext(), is(true));
        assertThat("Hello", is(scanner.next()));
        assertThat("world", is(scanner.next()));
        scanner.close();
    }
    @Test
    public void test_ConvertInputStreamToString()  throws IOException {
        String expectedValue = "Hello world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/text.txt");
        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("A");

        String result = scanner.next();
        assertEquals(expectedValue, result);

        scanner.close();
    }


    @Test
    public void test_ReadUsingBufferedReader()  throws IOException {
        String firstLine = "Hello world";
        String secondLine = "Hi, John";
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/text2.txt"));

        String result = reader.readLine();
        assertEquals(firstLine, result);

        result = reader.readLine();
        assertEquals(secondLine, result);

        reader.close();
    }

    @Test
    public void test_ReadUsingScanner() throws IOException {
        String firstLine = "Hello world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/text2.txt");
        Scanner scanner = new Scanner(inputStream);

        String result = scanner.nextLine();
        assertEquals(firstLine, result);

        scanner.useDelimiter(", ");
        assertEquals("Hi", scanner.next());
        assertEquals("John", scanner.next());

        scanner.close();
    }

    @Test
    public void test_ReadingInputFromConsole() {
        String input = "Hello";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);

        String result = scanner.next();
        assertEquals(input, result);

        System.setIn(stdin);
        scanner.close();
    }

    @Test
    public void test_ValidateInputUsingScanner() throws IOException {
        String input = "2000";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);

        boolean isIntInput = scanner.hasNextInt();
        assertTrue(isIntInput);

        System.setIn(stdin);
        scanner.close();
    }
    @Test
    public void test_ScanString() throws IOException {
        String input = "Hello 1 F 3.5";
        Scanner scanner = new Scanner(input);

        assertEquals("Hello", scanner.next());
        assertEquals(1, scanner.nextInt());
        assertEquals(15, scanner.nextInt(16));
        assertEquals(3.5, scanner.nextDouble(), 0.00000001);

        scanner.close();
    }

    @Test
    public void test_FindPatternUsingScanner() throws IOException {
        String expectedValue = "world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/text.txt");
        Scanner scanner = new Scanner(inputStream);

        String result = scanner.findInLine("wo..d");
        assertEquals(expectedValue, result);

        scanner.close();
    }

    @Test
    public void test_FindPatternInHorizon() throws IOException {
        String expectedValue = "world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/text.txt");
        Scanner scanner = new Scanner(inputStream);

        String result = scanner.findWithinHorizon("wo..d", 5);
        assertNull(result);

        result = scanner.findWithinHorizon("wo..d", 100);
        assertEquals(expectedValue, result);

        scanner.close();
    }

    @Test
    public void test_SkipPatternUsingScanner() throws IOException {
        FileInputStream inputStream = new FileInputStream("src/test/resources/text.txt");
        Scanner scanner = new Scanner(inputStream);

        scanner.skip(".e.lo");

        assertEquals("world", scanner.next());

        scanner.close();
    }

    @Test
    public void test_ChangeScannerDelimiter() throws IOException {
        String expectedValue = "Hello world";
        String[] splited = expectedValue.split("o");

        FileInputStream inputStream = new FileInputStream("src/test/resources/text.txt");
        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("o");

        assertEquals(splited[0], scanner.next());
        assertEquals(splited[1], scanner.next());
        assertEquals(splited[2], scanner.next());

        scanner.close();
    }
    @Test
    public void test_ReadWithScannerTwoDelimiters()
            throws IOException {
        Scanner scanner = new Scanner(new File("src/test/resources/names.txt"));
        scanner.useDelimiter(",|-");

        assertEquals("John", scanner.next());
        assertEquals("Adam", scanner.next());
        assertEquals("Tom", scanner.next());

        scanner.close();
    }

}
