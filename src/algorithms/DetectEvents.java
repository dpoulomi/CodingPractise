package algorithms;

//You'll be given an array (of integers) and a threshold value as input,
//write a program to return the number of critical events in the array.
//An event between indices i < j is a critical event if a[i] > t * a[j],
// where  is the threshold value given as input.
public class DetectEvents {

  public static void main(String[] args) {
    DetectEvents detectEvents = new DetectEvents();
    detectEvents.findCriticalEvents();
  }

  private void findCriticalEvents() {
    int[] arr = { 4, 2, 1, 6 };
    int threshold = -1;
    int events = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > threshold * arr[j]) {
          events++;
        }
      }
    }
    System.out.println("No of critical events: " + events);
  }
}
