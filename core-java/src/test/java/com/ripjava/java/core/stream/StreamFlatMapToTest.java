package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamFlatMapToTest {

    @Test
    public void test_FlatMapToInt(){
        int[][] data = {{1,2},{3,4},{5,6}};

        IntStream is1 = Arrays.stream(data).flatMapToInt(row -> Arrays.stream(row));
        System.out.println(is1.sum());

        int[] l1 = {4,8,9};
        IntDemoPerson p1 = new IntDemoPerson("li", l1);
        int[] l2 = {2,7,8};
        IntDemoPerson p2 = new IntDemoPerson("sun", l2);
        List<IntDemoPerson> list = Arrays.asList(p1,p2);

        IntStream is2 = list.stream().flatMapToInt(row -> Arrays.stream(row.getLuckyNum()));
        System.out.println(is2.max().getAsInt());
    }

    class IntDemoPerson {
        private String name;
        private int[] luckyNum;
        public IntDemoPerson(String name, int[] luckyNum){
            this.name = name;
            this.luckyNum = luckyNum;
        }
        public String getName() {
            return name;
        }
        public int[] getLuckyNum() {
            return luckyNum;
        }
    }

    @Test
    public void test_FlatMapToLong(){
        long[][] data = {{1L,2L},{3L,4L},{5L,6L}};
        LongStream ls1 = Arrays.stream(data).flatMapToLong(row -> Arrays.stream(row));
        System.out.println(ls1.sum());

        long[] l1 = {4l,8l,9l};
        LongDemoPerson p1 = new LongDemoPerson("li", l1);
        long[] l2 = {2l,7l,8l};
        LongDemoPerson p2 = new LongDemoPerson("sun", l2);
        List<LongDemoPerson> list = Arrays.asList(p1,p2);

        LongStream ls2 = list.stream().flatMapToLong(row -> Arrays.stream(row.getLuckyNum()));
        System.out.println(ls2.min().getAsLong());
    }

    class LongDemoPerson {
        private String name;
        private long[] luckyNum;
        public LongDemoPerson(String name, long[] luckyNum){
            this.name = name;
            this.luckyNum = luckyNum;
        }
        public String getName() {
            return name;
        }
        public long[] getLuckyNum() {
            return luckyNum;
        }
    }

    @Test
    public void  test_flatMapToDouble(){
        double[][] data = {{1.5,2.4},{3.2,4.4},{5.2,6.8}};
        DoubleStream ds1 = Arrays.stream(data).flatMapToDouble(row -> Arrays.stream(row));
        System.out.println(ds1.average().getAsDouble());

        double[] d1 = {60.5,58.9, 62.5};
        DoubleDemoPerson p1 = new DoubleDemoPerson("Ram", d1);
        double[] d2 = {70.5,65.3,67.4};
        DoubleDemoPerson p2 = new DoubleDemoPerson("Shyam", d2);
        List<DoubleDemoPerson> list = Arrays.asList(p1,p2);
        DoubleStream ds2 = list.stream().flatMapToDouble(row -> Arrays.stream(row.getWeightsInAYear()));
        System.out.println(ds2.min().getAsDouble());
    }

    class DoubleDemoPerson {
        private String name;
        private double[] weightsInAYear;
        public DoubleDemoPerson(String name, double[] weightsInAYear){
            this.name = name;
            this.weightsInAYear = weightsInAYear;
        }
        public String getName() {
            return name;
        }
        public double[] getWeightsInAYear() {
            return weightsInAYear;
        }
    }

}
