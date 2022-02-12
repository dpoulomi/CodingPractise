package array;

//Given two sorted arrays nums1 and nums2 of size m and n respectively,
//return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).
public class MedianofTwoSortedArray {

  public static void main(String[] args) {
    int[] nums1 = { 1, 2 };
    int[] nums2 = { 3, 4 };
    MedianofTwoSortedArray medianofTwoSortedArray = new MedianofTwoSortedArray();
    double median = medianofTwoSortedArray.findMedian(nums1, nums2);
    System.out.println(median);
  }

  private double findMedian(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    double median = 0;
    int[] mergedArray = getMergedSortedArray(nums1, nums2);
    if ((m + n) % 2 == 0) {
      median = (nums1[nums1.length - 1] + nums2[0]) / 2;
    } else if ((m + n) % 2 == 1) {
      if (m > n) {
        median = nums1[nums1.length - 1];
      } else if (m < n) {
        median = nums2[0];
      }
    }
    return median;
  }

  private int[] getMergedSortedArray(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] mergedArray = new int[nums1.length + nums2.length];
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        mergedArray[k] = nums1[i];
        i++;
      } else if (nums1[i] > nums2[j]) {
        mergedArray[k] = nums1[i];
        j++;
      }
      k++;
    }
    while (i < nums1.length) {
      mergedArray[k] = nums1[i];
      i++;
      k++;
    }
    while (j < nums2.length) {
      mergedArray[k] = nums2[i];
      j++;
      k++;
    }
    return mergedArray;
  }
}
