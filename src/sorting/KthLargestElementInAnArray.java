package sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

  public static void main(String[] args) {
    int[] arr = { 3, 2, 1, 5, 6, 4 };
    int k = 2;
    KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
    System.out.println(kthLargestElementInAnArray.findKthLargestElement(arr, k));
  }

  private int findKthLargestElement(int[] arr, int k) {

    Queue<Integer> minQueue = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
      minQueue.add(arr[i]);
      if (minQueue.size() > k) {
        minQueue.poll();
      }
    }
    return minQueue.peek();
  }
}
