package sorting;

import java.util.Arrays;

//Give an efficient sorting algorithm for an array D[1, 2, 3, …, n]
//whose elements are distinct (D[i] != D[j], for every i!= j ϵ 1, 2….,n)
//and are taken from the set 1, 2,…,2n
public class SortArrayWithDistinctElements {

  public static void main(String[] args) {
    SortArrayWithDistinctElements sortArrayWithDistinctElements = new SortArrayWithDistinctElements();
    int[] array = { 1, 2, 6, 3, 11, 7, 5, 4, 9, };
    int[] sortedArray = sortArrayWithDistinctElements.sort(array);
    Arrays.stream(sortedArray).forEach(System.out::println);
  }

  private int[] sort(int[] array) {
    int range = array.length * 2;
    int[] count = new int[range];
    for (int i = 0; i < array.length; i++) {
      count[array[i] - 1] = 1;
    }
    int[] output = new int[array.length];
    int index = 0;
    for (int i = 0; i < range; i++) {
      if (count[i] == 1) {
        output[index] = i + 1;
        index++;
      }
    }
    return output;
  }
}
