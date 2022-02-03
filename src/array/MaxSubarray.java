package array;

//Given an integer array nums, find the contiguous subarray
//(containing at least one number) which has the largest sum and return its sum.
//A subarray is a contiguous part of an array.
public class MaxSubarray {

  public static void main(String[] args) {
    MaxSubarray maxSubarray = new MaxSubarray();
    System.out.println(maxSubarray.findMaxSum());
  }

  private int findMaxSum() {
    int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    int currentSum = arr[0];
    int maxSum = Integer.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
      currentSum = currentSum + arr[i];
      if (currentSum > arr[i]) {

      } else {
        currentSum = arr[i];
      }
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }
    return maxSum;
  }
}
