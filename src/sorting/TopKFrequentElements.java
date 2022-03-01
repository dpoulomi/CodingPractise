package sorting;

import java.util.*;

public class TopKFrequentElements {
  public static void main(String[] args) {
    TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
    int[] output = topKFrequentElements.getTopKFrequentElements();
    System.out.println(Arrays.toString(output));
  }

  private int[] getTopKFrequentElements() {
    int arr[] = { 1, 1, 1, 2, 2, 3, 3, 4, 8, 8, 8, 8, 8, 8 };
    int k = 2;
    Map<Integer, Integer> hashFrequency = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      hashFrequency.put(arr[i], hashFrequency.getOrDefault(arr[i], 0) + 1);
    }
    Queue<Integer> topKStore = new PriorityQueue<>(
        (n1, n2) -> hashFrequency.get(n1) - hashFrequency.get(n2));
    for (Map.Entry<Integer, Integer> entry : hashFrequency.entrySet()) {
      topKStore.add(entry.getKey());
      if (topKStore.size() > k) {
        topKStore.remove();

      }
    }
    int[] output = new int[k];
    for (int i = 0; i < output.length; i++) {
      output[i] = topKStore.poll();
    }
    return output;
  }
}
