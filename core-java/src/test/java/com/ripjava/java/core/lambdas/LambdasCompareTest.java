package com.ripjava.java.core.lambdas;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LambdasCompareTest {

    @Test
    public void givenAnonymousClass_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });
        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort(
                (Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void givenLambdaShortForm_whenSortingEntitiesByName_thenCorrectlySorted() {

        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {

        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort(Human::compareByNameThenAge);
        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void givenInstanceMethod_whenSortingByNameThenAge_thenCorrectlySorted() {

        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Collections.sort(
                humans, Comparator.comparing(Human::getName));
        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Comparator<Human> comparator
                = Comparator.comparing(Human::getName);

        humans.sort(comparator.reversed());

        assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test
    public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humans = Arrays.asList(
                new Human("Sarah", 12),
                new Human("Sarah", 10),
                new Human("Zack", 12)
        );

        humans.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test
    public void givenComposition_whenSortingByNameThenAge_thenCorrectlySorted() {

        List<Human> humans = Arrays.asList(
                new Human("Sarah", 12),
                new Human("Sarah", 10),
                new Human("Zack", 12)
        );

        humans.sort(
                Comparator.comparing(Human::getName).thenComparing(Human::getAge)
        );

        assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test
    public final void givenStreamNaturalOrdering_whenSortingByNameReversed_thenCorrectlySorted() {
        List<String> letters = Arrays.asList("B", "A", "C");

        List<String> reverseSortedLetters = letters.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertThat(reverseSortedLetters.get(0), equalTo("C"));
    }

    @Test
    public final void givenStreamCustomOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12));
        Comparator<Human> reverseNameComparator = (h1, h2) -> h2.getName().compareTo(h1.getName());

        List<Human> reverseSortedHumans = humans.stream().sorted(reverseNameComparator)
                .collect(Collectors.toList());
        assertThat(reverseSortedHumans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test
    public final void givenStreamComparatorOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12));

        List<Human> reverseSortedHumans = humans.stream()
                .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        assertThat(reverseSortedHumans.get(0), equalTo(new Human("Sarah", 10)));
    }
}
