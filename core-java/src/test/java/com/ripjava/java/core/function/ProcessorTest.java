package com.ripjava.java.core.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

public class ProcessorTest {


    private  Processor processor;

    @BeforeEach
    public void  beforeEach(){
        processor = new ProcessorImpl();
    }

    @Test
    public void testProcessor() throws Exception {
        processor.process((Callable<String>) ()-> "test");
    }
}
