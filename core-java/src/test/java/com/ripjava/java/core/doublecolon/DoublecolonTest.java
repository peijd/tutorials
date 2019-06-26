package com.ripjava.java.core.doublecolon;

import com.ripjava.java.core.doublecolon.InterfaceComputer;
import com.ripjava.java.core.doublecolon.MacbookPro;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.ripjava.java.core.doublecolon.Computer;
import com.ripjava.java.core.doublecolon.ComputerUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class DoublecolonTest {


    @Test
    public void testStaticMethod_byColonReference(){
        List<Computer> inventory = Arrays.asList(
                new Computer( 2015, "white", 35), new Computer(2009, "black", 65));
        inventory.forEach(ComputerUtils::repair);

        assertThat(inventory.get(0).getHealty(), is(100));
    }

    @Test
    public void testInstanceMethod_byColonReference() {
        Computer c1 = new Computer(2015, "white");
        Computer c2 = new Computer(2009, "black");
        Computer c3 = new Computer(2014, "black");
        Arrays.asList(c1, c2, c3).forEach(System.out::print);
    }

    @Test
    public void testObjectArbitraryMethod_byColonReference() {
        Computer c1 = new Computer(2015, "white", 100);
        Computer c2 = new MacbookPro(2009, "black", 100);
        List<Computer> inventory = Arrays.asList(c1, c2);
        inventory.forEach(Computer::turnOnPc);
    }

    @Test
    public void testSuperClassMethod_byColonReference() {
        Computer c = new MacbookPro(2009, "black", 100);
        assertThat( c.calculateValue(999.9), is(766.59));
    }

    @Test
    public void testConstructMethod_byColonReference() {
        InterfaceComputer c = Computer::new;
        assertThat(c.create(), instanceOf(Computer.class));
    }

    @Test
    public void testTwoParameterConstructMethod_byColonReference() {
        BiFunction<Integer, String, Computer> c = Computer::new;
        assertThat(c.apply(2013, "white"), instanceOf(Computer.class));
    }

    @Test
    public void testThreeParameterConstructMethod_byColonReference() {
        TriFunction<Integer, String, Integer, Computer> c = Computer::new;
        assertThat(c.apply(2013, "white", 60), instanceOf(Computer.class));
    }

    @Test
    public void testCreateArray_byColonReference() {
        Function<Integer, Computer[]> computerCreator = Computer[]::new;
        Computer[] computerArray = computerCreator.apply(5);

        assertThat( computerArray.length, is(5));
    }

}
