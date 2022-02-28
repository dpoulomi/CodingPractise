package algorithms;

public class MedianFinder {

  private Integer[] a;
  private int N;

  public MedianFinder(int capacity) {

    // accounts for '0' not being used
    this.a = new Integer[capacity + 1];
    this.N = 0;
  }

  public void insert(int k) {

    a[++N] = k;
    swim(N);
  }

  public int delMedian() {

    int median = findMedian();
    exch(1, N--);
    sink(1);
    a[N + 1] = null;
    return median;

  }

  public int findMedian() {

    return a[1];

  }

  // entry swims up so that its left child is smaller and right is greater

  private void swim(int k) {

    while (even(k) && k > 1 && less(k / 2, k)) {

      exch(k, k / 2);

      if ((N > k) && less(k + 1, k / 2))
        exch(k + 1, k / 2);
      k = k / 2;
    }

    while (!even(k) && (k > 1 && !less(k / 2, k))) {

      exch(k, k / 2);
      if (!less(k - 1, k / 2))
        exch(k - 1, k / 2);
      k = k / 2;
    }

  }

  // if the left child is larger or if the right child is smaller, the entry sinks down
  private void sink(int k) {

    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, k))
        j++;
      if (less(k, j))
        break;
      exch(k, j);
      k = j;
    }

  }

  private boolean even(int i) {

    if ((i % 2) == 0)
      return true;
    else
      return false;
  }

  private void exch(int i, int j) {

    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private boolean less(int i, int j) {

    if (a[i] <= a[j])
      return true;
    else
      return false;
  }

  public static void main(String[] args) {

    MedianFinder medianFinder = new MedianFinder(10);
    int[] arr = { 3, 4, 1, 8, 20, 19, 6 };
    for (int i = 0; i < arr.length; i++) {
      medianFinder.insert(arr[i]);
    }

    System.out.println("The median is: " + medianFinder.findMedian());
   // medianFinder.delMedian();

   // System.out.println("Original median deleted. The new median is " + medianFinder.findMedian());

  }
}
