package com.ripjava.java.core;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TryWithResourcesTest {
    private static final Logger LOG = LoggerFactory.getLogger(TryWithResourcesTest.class);

    private static final String TEST_STRING_HELLO_WORLD = "Hello World";


    private Date resource1Date, resource2Date;

    @Test
    public void 使用Try_with_resources的示例() {
        final StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw, true)) {
            pw.print(TEST_STRING_HELLO_WORLD);
        }

        assertEquals(sw.getBuffer()
                .toString(), TEST_STRING_HELLO_WORLD);
    }

    @Test
    public void 使用多个资源的示例() {

        final StringWriter sw = new StringWriter();
        try (Scanner sc = new Scanner(TEST_STRING_HELLO_WORLD); PrintWriter pw = new PrintWriter(sw, true)) {
            while (sc.hasNext()) {
                pw.print(sc.nextLine());
            }
        }

        assertEquals(sw.getBuffer()
                .toString(), TEST_STRING_HELLO_WORLD);
    }

    /* Example to show order in which the resources are closed */
    @Test
    public void 显示资源关闭顺序的示例() throws Exception {
        try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst(); AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {
            af.doSomething();
            as.doSomething();
        }
        assertTrue(resource1Date.after(resource2Date));
    }

    class AutoCloseableResourcesFirst implements AutoCloseable {
        public AutoCloseableResourcesFirst() {
            LOG.debug("Constructor -> AutoCloseableResources_First");
        }

        public void doSomething() {
            LOG.debug("Something -> AutoCloseableResources_First");
        }

        @Override
        public void close() throws Exception {
            LOG.debug("Closed AutoCloseableResources_First");
            resource1Date = new Date();
        }
    }

    class AutoCloseableResourcesSecond implements AutoCloseable {
        public AutoCloseableResourcesSecond() {
            LOG.debug("Constructor -> AutoCloseableResources_Second");
        }

        public void doSomething() {
            LOG.debug("Something -> AutoCloseableResources_Second");
        }

        @Override
        public void close() throws Exception {
            LOG.debug("Closed AutoCloseableResources_Second");
            resource2Date = new Date();
            Thread.sleep(10000);
        }
    }



}
