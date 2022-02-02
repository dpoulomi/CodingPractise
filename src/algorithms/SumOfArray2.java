package algorithms;

//Each element of an array  is a digit . The array is ordered:A[i] ≤ A[i+1] for all.
//    Consider the problem of finding the sum of array A[1, ..., n]. Can we do it in O(log n) time?
public class SumOfArray2 {
  public static void main(String[] args) {
    SumOfArray2 sumOfArray = new SumOfArray2();
    int sum = sumOfArray.findSum();
    System.out.println(sum);
  }

  static class ValueTracker {
    static int end;
    static int occurences;
  }

  private int findSum() {
    int[] inputArray = { 1, 1, 1, 1, 1, 8, 8, 8, 9, 9 };
    int element;
    int sum = 0;
    int startIndex = 0;
    for (int i = 1; i <= 9; i++) {
      element = i;
      countOccurences(inputArray, element, startIndex, inputArray.length - 1);
      sum = sum + ValueTracker.occurences * element;
      if (ValueTracker.occurences > 0) {
        startIndex = ValueTracker.end + 1;
      }
    }

    return sum;
  }

  private void countOccurences(int[] inputArray, int element, int start, int end) {
    int ind = getEnd(inputArray, start, end, element);
    if (ind == -1) {
      ValueTracker.occurences = 0;
    } else {
      ValueTracker.end = ind;
      ValueTracker.occurences = ValueTracker.end - start + 1;
    }
  }

  private int getEnd(int[] inputArray, int start, int end, int element) {
    if (start > end) {
      return -1;
    }
    int middle = start + (end - start) / 2;
    if (inputArray[middle] == element) {
      if (middle == inputArray.length - 1 || (middle < inputArray.length - 1 && inputArray[middle + 1] != element)) {
        return middle;
      }
      start = middle + 1;
    } else if (inputArray[middle] < element) {
      start = middle + 1;
    } else {
      end = middle - 1;
    }
    return getEnd(inputArray, start, end, element);
  }

}
