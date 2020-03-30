package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamTest {

    @Test
    public void test_IntStream(){
        System.out.println("rangeClosed:");
        IntStream.rangeClosed(1, 15).map(n->n*n).forEach(s->System.out.print(s +" "));
        System.out.println();
        System.out.println("range:");
        IntStream.range(1,5).map(n->n*n).forEach(s->System.out.print(s +" "));
    }

    @Test
    public void test_LongStream(){
        System.out.println("rangeClosed:");
        LongStream.rangeClosed(1, 15).map(n->n*n).forEach(s->System.out.print(s +" "));
        System.out.println();
        System.out.println("range:");
        LongStream.range(1,5).map(n->n*n).forEach(s->System.out.print(s +" "));
    }

    @Test
    public void test_DoubleStream(){
        System.out.println("of：");
        DoubleStream.of(5.33,2.34,5.32,2.31,3.51).map(d->d*1.5).forEach(s->System.out.print(s +" "));
        System.out.println();
        System.out.println("average：");
        double val = DoubleStream.of(12.1,11.2,13.3).average().getAsDouble();
        System.out.println(val);
        System.out.println("max：");
        val = DoubleStream.of(12.1,11.2,13.3).max().getAsDouble();
        System.out.println(val);
        System.out.println("filter：");
        DoublePredicate range = d -> d > 12.11 && d < 12.99;
        DoubleStream.of(12.1,11.2,12.3).filter(range).forEach(d->System.out.print(d));
    }
}
