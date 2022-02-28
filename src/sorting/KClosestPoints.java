package sorting;

import java.util.*;

public class KClosestPoints {

  public int[][] kClosest(int[][] points, int k) {
    Queue<int[]> maxHeap = new PriorityQueue<>((a , b) -> b[0] - a[0]);
    for (int i = 0; i < points.length; i++) {
      if (i < k) {
        maxHeap.offer(points[i]);
      } else if (checkIfNewPointIsCloser( maxHeap.peek(), points[i])) {
          maxHeap.poll();
          maxHeap.offer(points[i]);
        }
    }
    int[][] output = new int[k][2];
    int index = 0;
    while (maxHeap.size() > 0) {
      int[] entry = maxHeap.poll();
      output[index] = entry;
      index++;
    }
    return output;
  }

  private boolean checkIfNewPointIsCloser(int[] furthestPoint, int[] newPoint) {
    double xValue = Math.pow(furthestPoint[0], 2);
    double yValue = Math.pow(furthestPoint[1], 2);
    double distance = Math.sqrt(xValue + yValue);

    double xValue1 = Math.pow(newPoint[0], 2);
    double yValue1 = Math.pow(newPoint[1], 2);
    double distance1 = Math.sqrt(xValue1 + yValue1);

    return distance1 < distance;

  }

  public static void main(String[] args) {
    KClosestPoints kClosestPoints = new KClosestPoints();
    int[][] points = { { 3, 3 }, { 5, -1 }, {-2, 4} };
    int k = 2;
    int[][] result = kClosestPoints.kClosest(points, k);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i][0] + "," + result[i][1]);
    }
  }
}
