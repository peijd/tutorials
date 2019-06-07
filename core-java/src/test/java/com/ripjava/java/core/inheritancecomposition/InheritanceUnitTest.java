package com.ripjava.java.core.inheritancecomposition;


import com.ripjava.java.core.inheritancecomposition.model.Actress;
import com.ripjava.java.core.inheritancecomposition.model.Person;
import com.ripjava.java.core.inheritancecomposition.model.Waitress;
import org.junit.jupiter.api.Test;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class InheritanceUnitTest {

    @Test
    public void givenWaitressInstance_whenCheckedType_thenIsInstanceOfPerson() {
        assertThat(new Waitress("Mary", "mary@domain.com", 22), instanceOf(Person.class));
    }

    @Test
    public void givenActressInstance_whenCheckedType_thenIsInstanceOfPerson() {
        assertThat(new Actress("Susan", "susan@domain.com", 30), instanceOf(Person.class));
    }
}