package algorithms;

//Each element of an array  is a digit . The array is ordered:A[i] ≤ A[i+1] for all.
//    Consider the problem of finding the sum of array A[1, ..., n]. Can we do it in O(log n) time?
public class SumOfArray1 {
  public static void main(String[] args) {
    SumOfArray1 sumOfArray = new SumOfArray1();
    int sum = sumOfArray.findSum();
    System.out.println(sum);

  }

  private int findSum() {
    int[] inputArray = { 0, 0, 1, 1, 2, 2, 2, 3, 9 };
    int element;
    int sum = 0;
    int startIndex = 0;
    int endIndex = inputArray.length;
    for (int i = 0; i <= 9; i++) {
      element = i;
      int numberOfOccurences = countOccurences(inputArray, inputArray.length, element, startIndex,
          endIndex);
      sum = sum + numberOfOccurences * element;
      startIndex = endIndex + 1;
    }

    return sum;
  }

  private int countOccurences(int[] inputArray, int length, int element, int start, int end) {
    int ind = binarySearch(inputArray, start, end, element);
    if (ind == -1)
      return 0;
    int count = 1;
    int left = ind - 1;
    while (left >= 0 && inputArray[left] == element) {
      count++;
      left--;
    }
    int right = ind + 1;
    while (right < length && inputArray[right] == element) {
      count++;
      right++;
    }
    end = right;
    return count;
  }

  private int binarySearch(int[] arr, int low, int high, int num) {
    if (high < low)
      return -1;
    int mid = low + (high - low) / 2;
    if (arr[mid] == num)
      return mid;
    if (arr[mid] > num)
      return binarySearch(arr, low, mid - 1, num);
    return binarySearch(arr, mid + 1, high, num);
  }
}
