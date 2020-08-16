package com.bremp.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("ListUtils - splitToSubLists")
class ListUtilsTest {

  @Test
  @DisplayName("throws exception when list is null.")
  void whenListIsNull() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      List<String> list = null;
      int numOfLists = 4;
      ListUtils.splitToSubLists(list, numOfLists);
    });
  }

  @Test
  @DisplayName("throws exception when number of sublists is zero.")
  void whenNumberOfSubListsIsZero() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      List<String> list = new ArrayList<>();
      int numOfLists = 0;
      ListUtils.splitToSubLists(list, numOfLists);
    });
  }

  @Test
  @DisplayName("when number of sublists is greater than list size.")
  void whenNumberOfSubListsIsGreaterThanListSize() {
    List<String> list = new ArrayList<>();
    int numOfLists = 1;

    List<List<String>> actual = ListUtils.splitToSubLists(list, numOfLists);

    assertThat(actual.size(), is(1));
    assertThat(actual.get(0), is(empty()));
  }

  @ParameterizedTest
  @DisplayName("with varying list sizes.")
  @CsvSource({
      "1, 1",
      "'1,2', 1",
      "'1,2,3', 1",
      "'1,2,3,4', 2",
      "'1,2,3,4,5', 2",
      "'1,2,3,4,5,6', 2",
      "'1,2,3,4,5,6,7', 3",
      "'1,2,3,4,5,6,7,8', 3",
      "'1,2,3,4,5,6,7,8,9', 3"
  })
  void withVaryingListSizes(String listContent, int expectedSubListSize) {
    List<String> list = Arrays.asList(listContent.split(","));
    int numOfLists = 3;

    List<List<String>> actual = ListUtils.splitToSubLists(list, numOfLists);

    actual.forEach(s -> System.out.println(s.toString()));

    assertThat(actual.size(), is(3));
    assertThat(actual.get(0).size(), is(expectedSubListSize));
  }

}