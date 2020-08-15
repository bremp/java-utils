package com.bremp.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListUtilsTest {

  // TODO: Test guards and use params for supplying varying lists.
  @Test
  void partition() {
    List<String> source = Arrays.asList("1", "2", "3", "4", "5");
    int buckets = 4;

    List<List<String>> actual = ListUtils.orderedSplit(source, buckets);

    actual.forEach(s -> System.out.println(s.toString()));

    assertThat(actual.size(), is(4));
  }

}