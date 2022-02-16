package sorting;

import java.util.HashMap;
import java.util.Map;

public class SortArrayWithDuplicates {

  public static void main(String[] args) {
    SortArrayWithDuplicates sortArrayWithDuplicates = new SortArrayWithDuplicates();
    int[] arr = { 2, 3, 1, 6, 7, 2, 4, 1, 1, 7, 5, 6 };
    arr = sortArrayWithDuplicates.sort(arr);
    sortArrayWithDuplicates.printOutput(arr);
  }

  private void printOutput(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private int[] sort(int[] arr) {
    Map<Integer, Integer> occurences = new HashMap();
    for (int i = 0; i < arr.length; i++) {
      if (occurences.get(arr[i]) == null) {
        occurences.put(arr[i], 1);
      } else {
        occurences.put(arr[i], occurences.get(arr[i]) + 1);
      }
    }
    int[] sortedArray = new int[arr.length];
    int index = 0;
    for (int i = 1; i <= 7; i++) {
      int count = occurences.get(i);
      while (count > 0) {
        sortedArray[index] = i;
        count--;
      }
    }
    return sortedArray;
  }
}
