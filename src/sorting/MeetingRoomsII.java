package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

  public static void main(String[] args) {
    MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
   // int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
    int[][] intervals = { { 7, 10 }, { 2, 4 } };
    System.out.println(meetingRoomsII.minMeetingRooms(intervals));
  }

  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    PriorityQueue<Integer> meetingRoom = new PriorityQueue<Integer>(new Comparator<Integer>() {
      @Override public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    meetingRoom.add(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= meetingRoom.peek()) {
        meetingRoom.poll();
      }
      meetingRoom.add(intervals[i][1]);
    }
    return meetingRoom.size();
  }
}
