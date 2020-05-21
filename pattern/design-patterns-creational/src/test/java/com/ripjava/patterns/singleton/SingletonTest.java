package com.ripjava.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {

    @Test
    public  void test_ClassSingleton(){
        //ClassSingleton object1 = new ClassSingleton(); // ClassSingleton()的构造函数不可见
        ClassSingleton classSingleton1 = ClassSingleton.getInstance();
        System.out.println(classSingleton1.getInfo()); //Initial class info

        ClassSingleton classSingleton2 = ClassSingleton.getInstance();
        classSingleton2.setInfo("New class info");

        assertEquals(classSingleton1, classSingleton2);

        assertEquals(classSingleton1.getInfo(), classSingleton2.getInfo());
    }

    @Test
    public  void test_EnumSingleton(){
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();

        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");

        assertEquals(enumSingleton1, enumSingleton2);
        assertEquals(enumSingleton1.getInfo(), enumSingleton2.getInfo());
    }
}
