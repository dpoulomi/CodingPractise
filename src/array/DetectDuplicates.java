package array;

import java.util.HashMap;
import java.util.Map;

//Given an integer array nums,
//return true if any value appears at least twice in the array,
//and return false if every element is distinct.
public class DetectDuplicates {

  public static void main(String[] args) {
    DetectDuplicates detectDuplicates = new DetectDuplicates();
    System.out.println(detectDuplicates.findIfDuplicatePresent());
  }

  private boolean findIfDuplicatePresent() {
    int[] arr = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
    Map<Integer, Integer> numberStorage = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (numberStorage.get(arr[i]) == null) {
        numberStorage.put(arr[i], 1);
      } else if (numberStorage.get(arr[i]) == 1) {
        return true;
      }
    }
    return false;
  }

}
