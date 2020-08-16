# java-utils

A collection of java utility methods not found in popular libraries like guava and apache commons. 
Currently, there is only one method in this class, but overtime more will be added when the need 
arises.

**splitToSubLists()** - Splits a list into a given number of sublists. Tries to partition the list in 
equal parts. It maintains the order of the main list in the sublists.
   * @param *list* - the list to split.
   * @param *numSubLists* - the number of sublists.
   * @return A list of sublists.
   
e.g.
```
list = [1,2,3,4,5]
numSubLists = 3

sl1 = [1,2]
sl2 = [3,4]
sl3 = [5]
```

Made minor adjustments to the comment made by `user5888751` on stackoverflow.
https://stackoverflow.com/questions/16616560/is-there-a-simple-way-to-split-one-list-into-x-sublists