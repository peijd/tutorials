package com.ripjava.java.core.random;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomNumberTest {

    @Test
    public void test_RandomNextNumber(){
        // 长整数
        long generatedLong = new Random().nextLong();
        System.out.println(generatedLong);
        // 整数
        int generatedInteger = new Random().nextInt();
        System.out.println(generatedInteger);
        // 浮点数 float
        float generatedFloat = new Random().nextFloat();
        System.out.println(generatedFloat);
        // 浮点数 double
        double generatedDouble = Math.random();
        System.out.println(generatedDouble);
    }

    @Test
    public void test_RandomBounded() {
        // 长整数
        long leftLimit = 1L;
        long rightLimit = 10000L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        System.out.println(generatedLong);
        // 整数
        int leftLimit2 = 1;
        int rightLimit2 = 10;
        int generatedInteger = leftLimit2 + (int) (new Random().nextFloat() * (rightLimit2 - leftLimit2));
        System.out.println(generatedInteger);
        // 浮点数 float
        float leftLimit3 = 1F;
        float rightLimit3 = 10F;
        float generatedFloat = leftLimit3 + new Random().nextFloat() * (rightLimit3 - leftLimit3);
        System.out.println(generatedFloat);
        // 浮点数 double
        double leftLimit4 = 1D;
        double rightLimit4 = 10D;
        double generatedDouble = leftLimit4 + new Random().nextDouble() * (rightLimit4 - leftLimit4);
        System.out.println(generatedDouble);

    }

    @Test
    public void test_ApacheCommonsRandomBounded() {
        // 长整数
        long leftLimit = 10L;
        long rightLimit = 10000L;
        long generatedLong = new RandomDataGenerator().nextLong(leftLimit, rightLimit);
        System.out.println(generatedLong);
        // 整数
        int leftLimit2 = 1;
        int rightLimit2 = 10;
        int generatedInteger = new RandomDataGenerator().nextInt(leftLimit2, rightLimit2);
        System.out.println(generatedInteger);
        // 浮点数 float
        float leftLimit3 = 1F;
        float rightLimit3 = 10F;
        float randomFloat = new RandomDataGenerator().getRandomGenerator().nextFloat();
        float generatedFloat = leftLimit3 + randomFloat * (rightLimit3 - leftLimit3);
        System.out.println(generatedFloat);
        // 浮点数 double
        double leftLimit4 = 1D;
        double rightLimit4 = 100D;
        double generatedDouble = new RandomDataGenerator().nextUniform(leftLimit4, rightLimit4);
        System.out.println(generatedDouble);
    }


}
