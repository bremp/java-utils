package com.bremp.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

  private ListUtils() {
  }

  /**
   * https://stackoverflow.com/questions/16616560/is-there-a-simple-way-to-split-one-list-into-x-sublists
   * @param list
   * @param numSubLists
   * @param <T>
   * @return
   */
  public static  <T> List<List<T>> orderedSplit(List<T> list, int numSubLists) {
    if (list == null) {
      throw new NullPointerException("List is null.");
    }

    if (numSubLists <= 0) {
      throw new IllegalArgumentException("The list must be divided by an amount greater than 0.");
    }

    if (numSubLists > list.size()) {
      throw new IllegalArgumentException("The size of the list is not sufficient for that distribution.");
    }

    List<List<T>> result = new ArrayList<>(numSubLists);

    int listsSize = list.size() / numSubLists;
    int remainder = list.size() % numSubLists;

    int index = 0;
    int remainderAccess = 0;
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
