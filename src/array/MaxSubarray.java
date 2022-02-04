package array;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums, find the contiguous subarray
//(containing at least one number) which has the largest sum and return its sum.
//A subarray is a contiguous part of an array.
public class MaxSubarray {

  public static void main(String[] args) {
    MaxSubarray maxSubarray = new MaxSubarray();
    System.out.println("The max sum is:" + maxSubarray.findMaxSum());
  }

  private int findMaxSum() {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    List<Integer> indices = new ArrayList<>();

    int currentSum = arr[0];
    indices.add(0);
    int maxIndex = 0;
    int maxSum = currentSum;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] + currentSum > arr[i]) {
        currentSum = currentSum + arr[i];
      } else {
        currentSum = arr[i];
        indices.removeAll(indices);
      }
      indices.add(i);
      if (currentSum >= maxSum) {
        maxSum = currentSum;
        maxIndex = i;
      }
    }
    int finalMaxIndex = maxIndex;
    indices.stream().filter(i -> i <= finalMaxIndex).forEach(System.out::println);
    return maxSum;
  }
}
