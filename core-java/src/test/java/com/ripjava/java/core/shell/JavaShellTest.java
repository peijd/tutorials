package com.ripjava.java.core.shell;

import nl.jqno.equalsverifier.internal.util.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaShellTest {

    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().startsWith("windows");

    private Consumer<String> consumer = System.out::println;

    private String homeDirectory = System.getProperty("user.home");


    @Test
    public void test_CreatingViaRuntime() throws Exception {
        Process process;
        if (IS_WINDOWS) {
            process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", homeDirectory));
        } else {
            process = Runtime.getRuntime().exec(String.format("sh -c ls %s", homeDirectory));
        }
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), consumer);

        Executors.newSingleThreadExecutor().submit(streamGobbler);

        int exitCode = process.waitFor();

        assertEquals(0, exitCode);
    }

    @Test
    public void test_CreatingViaProcessBuilder() throws Exception {
        ProcessBuilder builder = new ProcessBuilder();
        if (IS_WINDOWS) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", "ls");
        }
        builder.directory(new File(homeDirectory));
        Process process = builder.start();
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), consumer);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assertEquals(0, exitCode);
    }

}
