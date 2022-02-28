package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median_Heap {

  private Queue<Integer> minHeap, maxHeap;

  Median_Heap() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  void add(int num) {
    if (!minHeap.isEmpty() && num < minHeap.peek()) {
      maxHeap.offer(num);
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      }
    } else {
      minHeap.offer(num);
      if (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.offer(minHeap.poll());
      }
    }
  }

  double getMedian() {
    int median;
    if (minHeap.size() < maxHeap.size()) {
      median = maxHeap.peek();
    } else if (minHeap.size() > maxHeap.size()) {
      median = minHeap.peek();
    } else {
      median = (minHeap.peek() + maxHeap.peek()) / 2;
    }
    return median;

  }
}
