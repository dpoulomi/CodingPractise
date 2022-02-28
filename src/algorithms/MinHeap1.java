package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MinHeap1 {

  private List<Integer> minHeap = new ArrayList<>();

  public void add(int element) {
    minHeap.add(element);
    swim(element);
  }

  public boolean isEmpty() {
    return minHeap.size() == 0;
  }

  public int size() {
    return minHeap.size();
  }

  public int extract() {
    int median = minHeap.get(0);
    minHeap.add(0, minHeap.get(minHeap.size() - 1));
    sink();
    return median;

  }

  public int peek() {
    return minHeap.get(0);
  }

  public void swim(int element) {
    int elementIndex = minHeap.size() - 1;
    int parentIndex = elementIndex / 2;
    while (minHeap.get(parentIndex) > element) {
      int temp = minHeap.get(parentIndex);
      minHeap.add(parentIndex, element);
      minHeap.add(temp);
      elementIndex = parentIndex;
      parentIndex = elementIndex / 2;
    }
  }

  public void sink() {
    int elementIndex = 0;
    int leftIndex = 2 * elementIndex;
    int rightIndex = 2 * elementIndex + 1;
    while (leftIndex < minHeap.size() || rightIndex < minHeap.size()) {
      if (minHeap.get(leftIndex) < minHeap.get(elementIndex)) {
        int temp = minHeap.get(leftIndex);
        minHeap.add(leftIndex, minHeap.get(elementIndex));
        minHeap.add(elementIndex, temp);
        elementIndex = leftIndex;

      } else if (minHeap.get(rightIndex) < minHeap.get(elementIndex)) {
        int temp = minHeap.get(rightIndex);
        minHeap.add(rightIndex, minHeap.get(elementIndex));
        minHeap.add(elementIndex, temp);
        elementIndex = rightIndex;
      }
      leftIndex = 2 * elementIndex;
      rightIndex = 2 * elementIndex + 1;

    }
  }
}
