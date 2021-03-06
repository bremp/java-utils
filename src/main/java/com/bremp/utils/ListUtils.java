package com.bremp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

  private ListUtils() {
  }

  /**
   * Splits a list into a given number of sublists. Tries to partition the list in equal parts. It
   * maintains the order of the main list in the sublists.
   * https://stackoverflow.com/questions/16616560/is-there-a-simple-way-to-split-one-list-into-x-sublists
   *
   * @param list        the list to split.
   * @param numSubLists the number of sublists.
   * @return A list of sublists.
   */
  public static <T> List<List<T>> splitToSubLists(List<T> list, int numSubLists) {
    if (numSubLists <= 0) {
      throw new IllegalArgumentException("The list must be divided by an amount greater than 0.");
    }
    if (list == null || list.isEmpty()) {
      return Collections.emptyList();
    }
    if (numSubLists > list.size()) {
      numSubLists = list.size();
    }

    List<List<T>> result = new ArrayList<>(numSubLists);

    int listsSize = list.size() / numSubLists;
    int remainder = list.size() % numSubLists;

    int index = 0;
    int remainderAccess = 0;
    //noinspection ConstantConditions
    int from = index * listsSize + remainderAccess;
    int to = (index + 1) * listsSize + remainderAccess;

    while (numSubLists > index) {
      if (remainder != 0) {
        result.add(list.subList(from, to + 1));
        remainder--;
        remainderAccess++;
      } else {
        result.add(list.subList(from, to));
      }

      index++;
      from = index * listsSize + remainderAccess;
      to = (index + 1) * listsSize + remainderAccess;
    }

    return result;
  }

}
