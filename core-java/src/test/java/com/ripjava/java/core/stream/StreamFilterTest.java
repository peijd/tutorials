package com.ripjava.java.core.stream;

import com.pivovarit.function.ThrowingPredicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamFilterTest {



    @Test
    public void test_streamFilter() {
        Customer zhang = new Customer("Zhang", 15);
        Customer duan = new Customer("Duan", 200);
        Customer li = new Customer("Li", 150);
        Customer sun = new Customer("Sun", 1);
        List<Customer> customers = Arrays.asList(zhang, duan, li, sun);

        List<Customer> customersWithMoreThan100Points = customers
                .stream()
                .filter(c -> c.getPoints() > 100)
                .collect(Collectors.toList());

        assertThat(customersWithMoreThan100Points , hasSize(2));
        assertThat(customersWithMoreThan100Points, hasItems(duan, li));

        List<Customer> customersWithMoreThan100Points_2 = customers
                .stream()
                .filter(Customer::hasOverHundredPoints)
                .collect(Collectors.toList());


        assertThat(customersWithMoreThan100Points_2 , hasSize(2));
        assertThat(customersWithMoreThan100Points_2, hasItems(duan, li));
    }


    @Test
    public void test_streamFilter_Multiple() {
        Customer zhang = new Customer("Zhang", 15);
        Customer duan = new Customer("Duan", 200);
        Customer li = new Customer("Li", 150);
        Customer sun = new Customer("Sun", 1);
        List<Customer> customers = Arrays.asList(zhang, duan, li, sun);

        List<Customer> charlesWithMoreThan100Points = customers
                .stream()
                .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Duan"))
                .collect(Collectors.toList());

        assertThat(charlesWithMoreThan100Points, hasSize(1));
        assertThat(charlesWithMoreThan100Points, hasItems(duan));

        List<Customer> customersWithMoreThan100Points_2 = customers
                .stream()
                .filter(c -> c.getPoints() > 100 )
                .filter(c -> c.getName().startsWith("Duan"))
                .collect(Collectors.toList());


        assertThat(customersWithMoreThan100Points_2, hasSize(1));
        assertThat(customersWithMoreThan100Points_2, hasItems(duan));
    }

    @Test
    public void test_streamFilter_Exception() {
        Customer zhang = new Customer("Zhang", 15);
        Customer duan = new Customer("Duan", 200);
        Customer li = new Customer("Li", 150);
        Customer sun = new Customer("Sun", 1);
        List<Customer> customers = Arrays.asList(zhang, duan, li, sun);

        List<Customer> customersWithValidProfilePhoto = customers
                .stream()
                .filter(c -> {
                    try {
                        return c.hasValidProfilePhoto();
                    } catch (IOException e) {
                        System.out.println(c.getName());
                    }
                    return false;
                })
                .collect(Collectors.toList());

        List customersWithValidProfilePhoto_2 = customers
                .stream()
                .filter(ThrowingPredicate.unchecked(Customer::hasValidProfilePhoto))
                .collect(Collectors.toList());
    }


}
