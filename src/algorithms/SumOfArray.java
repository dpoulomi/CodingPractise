package algorithms;

//Each element of an array  is a digit . The array is ordered:A[i] ≤ A[i+1] for all.
//    Consider the problem of finding the sum of array A[1, ..., n]. Can we do it in O(log n) time?
public class SumOfArray {
  public static void main(String[] args) {
    SumOfArray sumOfArray = new SumOfArray();
    int sum = sumOfArray.findSum();
    System.out.println(sum);

  }

  private int findSum() {
    int[] inputArray = { 0, 0, 1, 1, 2, 2, 9 };//15
    int start = 0;
    int end = 0;
    int sum = 0;
    while (start < inputArray.length) {
      int element = inputArray[start];
      end = binarySearch(inputArray, start, inputArray.length - 1, element);
      if (end == -1) {
        sum = sum + inputArray[start];
      } else {
        sum = sum + (end - start + 1) * inputArray[start];
      }
      start = end + 1;
    }
    return sum;
  }

  private int binarySearch(int[] arr, int start, int end, int element) {
    int mid = start + (end - start) / 2;
    if (arr[mid] == element) {
      return mid;
    } else if (arr[mid] > element) {
      return binarySearch(arr, start, mid, element);
    } else if (arr[mid] < element) {
      return binarySearch(arr, mid + 1, end, element);
    }
    return -1;
  }
}
