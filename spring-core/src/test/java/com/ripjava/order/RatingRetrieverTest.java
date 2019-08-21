package com.ripjava.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class RatingRetrieverTest {
    @Configuration
    @ComponentScan(basePackages = {"com.ripjava.order"})
    static class ContextConfiguration {}

    @Autowired
    private List<Rating> ratings;


    @Test
    public void test_order() {
        assertThat(ratings.get(0).getRating(), is(equalTo(1)));
        assertThat(ratings.get(1).getRating(), is(equalTo(2)));
        assertThat(ratings.get(2).getRating(), is(equalTo(3)));
    }
}
