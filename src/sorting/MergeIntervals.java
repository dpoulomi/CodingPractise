package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

  public static void main(String[] args) {
    MergeIntervals mergeIntervals = new MergeIntervals();
    //int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    int[][] intervals = { { 1, 4 }, { 2, 3 } };
    int[][] result = mergeIntervals.merge(intervals);
    for (int i = 0; i < result.length; i++) {
      if (result[i][0] != -1) {
        System.out.println(result[i][0] + "," + result[i][1]);
      }
    }
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int[][] output = new int[intervals.length][2];
    for (int i = 0; i < output.length; i++) {
      output[i][0] = -1;
      output[i][1] = -1;
    }
    output[0] = intervals[0];
    int counter = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (output[counter][1] >= intervals[i][0] && output[counter][1] < intervals[i][1]) {
        output[counter][1] = intervals[i][1];
      } else if (output[counter][1] < intervals[i][0]) {
        output[counter + 1] = intervals[i];
        counter = counter + 1;
      }

    }
    int outputCount = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (output[i][0] != -1) {
        outputCount++;
      }
    }
    return Arrays.copyOf(output, outputCount);
  }

}
