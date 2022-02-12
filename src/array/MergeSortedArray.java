package array;

import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
//and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//The final sorted array should not be returned by the function, but instead be stored inside
//the array nums1. To accommodate this, nums1 has a length of m + n,
//where the first m elements denote the elements that should be merged,
//and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
public class MergeSortedArray {

  public static void main(String[] args) {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();
    mergeSortedArray.mergeArray();
  }

  private void mergeArray() {
    int[] nums1 = { 1, 2, 3, 0 , 0 , 0 };
    int[] nums2 = { 4, 5, 6 };
    int m = 6;
    int n = 3;
    int i = 0;
    int j = 0;
    if (m == 0) {
      nums1[0] = nums2[0];
      printMergedArray(nums1);
      return;
    }
    if (n == 0) {
      printMergedArray(nums1);
      return;
    }
    if(nums1[0] > nums2[n - 1]){

    }
    while (i < m) {
      if (nums1[i] > nums2[j]) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
      }
      i++;
    }
    while (j < n) {
      nums1[i] = nums2[j];
      i++;
      j++;
    }
    printMergedArray(nums1);

  }

  private void printMergedArray(int[] num1) {
    for (int k = 0; k < num1.length; k++) {
      System.out.println(num1[k]);
    }
  }
}
