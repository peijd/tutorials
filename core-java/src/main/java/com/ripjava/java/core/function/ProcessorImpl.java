package com.ripjava.java.core.function;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ProcessorImpl implements Processor {
    @Override
    public String process(Callable<String> c) throws Exception {
        // 具体实现
        return null;
    }

    @Override
    public String process(Supplier<String> s) {
        // 具体实现
        return null;
    }
}
