package algorithms;

public class MedianHeap {

  private MaxHeap maxHeap;

  private MinHeap minHeap;

  public MedianHeap() {
    maxHeap = new MaxHeap();
    minHeap = new MinHeap();
  }

  public static void main(String[] args) {

    MedianHeap medianHeap = new MedianHeap();
    int[] arr = { 3, 4, 1, 8, 20, 19, 6, 7 };
    medianHeap.buildMedianHeap(arr);
    double median = medianHeap.getMedian();
    System.out.println(median);
  }

  private void buildMedianHeap(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      if (!minHeap.isEmpty() && num < minHeap.peek()) {
        maxHeap.insert(num);
        if (maxHeap.size() > minHeap.size() + 1) {
          minHeap.insert(maxHeap.extract());
        }
      } else {
        minHeap.insert(num);
        if (minHeap.size() > maxHeap.size() + 1) {
          maxHeap.insert(minHeap.extract());
        }
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
