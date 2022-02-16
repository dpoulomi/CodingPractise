package sorting;

//An efficient sorting algorithm for an array C[1, 2, 3, …..n] of integers whose elements
//are taken from the set [1, 2, 3, 4, 5, 6, 7]

class SortArrayWithConstantElements {
  int[] sort(int[] arr) {
    int n = arr.length;
    int[] output = new int[n];
    int count[] = new int[7];
    for (int i = 0; i < n; ++i)
      ++count[arr[i] - 1];
    for (int i = 1; i < 7; ++i)
      count[i] += count[i - 1];
    for (int i = n - 1; i >= 0; i--) {
      output[count[arr[i] - 1] - 1] = arr[i];
      --count[arr[i] - 1];
    }
    return output;
  }

  public static void main(String args[]) {
    SortArrayWithConstantElements ob = new SortArrayWithConstantElements();
    int[] arr = { 1, 4, 6, 3, 2, 1, 3, 4, 6, 7 };
    int[] output = ob.sort(arr);
    System.out.print("Sorted array is ");
    for (int i = 0; i < output.length; i++) {
      System.out.println(output[i]);
    }
  }
}
