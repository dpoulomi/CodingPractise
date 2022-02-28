package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap1 {

  private List<Integer> maxHeap = new ArrayList<>();

  public void add(int element) {
    maxHeap.add(element);
    swim(element);
  }

  public boolean isEmpty() {
    return maxHeap.size() == 0;
  }

  public int extract() {
    int median = maxHeap.get(0);
    maxHeap.add(0, maxHeap.get(maxHeap.size() - 1));
    sink();
    return median;
  }

  public int size() {
    return maxHeap.size();
  }

  public int peek() {
    return maxHeap.get(0);
  }

  public void swim(int element) {
    int elementIndex = maxHeap.size() - 1;
    int parentIndex = elementIndex / 2;
    while (maxHeap.get(parentIndex) < element) {
      int temp = maxHeap.get(parentIndex);
      maxHeap.add(parentIndex, element);
      maxHeap.add(temp);
      elementIndex = parentIndex;
      parentIndex = elementIndex / 2;
    }
  }

  public void sink() {
    int elementIndex = 0;
    int leftIndex = 2 * elementIndex;
    int rightIndex = 2 * elementIndex + 1;
    while (leftIndex < maxHeap.size() || rightIndex < maxHeap.size()) {
      if (maxHeap.get(leftIndex) > maxHeap.get(elementIndex)) {
        int temp = maxHeap.get(leftIndex);
        maxHeap.add(leftIndex, maxHeap.get(elementIndex));
        maxHeap.add(elementIndex, temp);
        elementIndex = leftIndex;
      } else if (maxHeap.get(rightIndex) > maxHeap.get(elementIndex)) {
        int temp = maxHeap.get(rightIndex);
        maxHeap.add(rightIndex, maxHeap.get(elementIndex));
        maxHeap.add(elementIndex, temp);
        elementIndex = rightIndex;
      }
      leftIndex = 2 * elementIndex;
      rightIndex = 2 * elementIndex + 1;
    }
  }
}
