package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    twoSum.findPair();

  }

  private int[] findPair() {
    int[] arr = { 3, 3 };
    int target = 6;
    int[] result = new int[2];

    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int remainingValue = target - arr[i];
      if (!indexMap.keySet().contains(remainingValue)) {
        indexMap.put(arr[i], i);
      } else {
        System.out.println("The indices are:" + indexMap.get(remainingValue) + " and " + i);
        result[0] = indexMap.get(remainingValue);
        result[1] = i;
        return result;
      }
    }
    return result;
  }
}
