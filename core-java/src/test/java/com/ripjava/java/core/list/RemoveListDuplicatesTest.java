package com.ripjava.java.core.list;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


public class RemoveListDuplicatesTest {
    @Test
    public void test_RemovingDuplicatesWithPlainJava() {
        List<Integer> listWithDuplicates = List.of(0, 1, 2, 3, 0, 0);
        List<Integer> listWithoutDuplicates = new ArrayList<>(
                new HashSet<>(listWithDuplicates));

        assertThat(listWithoutDuplicates, hasSize(4));
    }

    @Test
    public void test_RemovingDuplicatesWithGuava() {
        List<Integer> listWithDuplicates = List.of(0, 1, 2, 3, 0, 0);
        List<Integer> listWithoutDuplicates
                = Lists.newArrayList(Sets.newHashSet(listWithDuplicates));

        assertThat(listWithoutDuplicates, hasSize(4));
    }

    @Test
    public void test_RemovingDuplicatesWithJava8() {
        List<Integer> listWithDuplicates = List.of(1, 1, 2, 2, 3, 3);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
    }

}
