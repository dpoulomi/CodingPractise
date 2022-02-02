package algorithms;

import java.util.HashMap;
import java.util.Map;

public class DetectEvents1 {

  public static void main(String[] args) {
    DetectEvents1 detectEvents1 = new DetectEvents1();
    detectEvents1.findEventCount();
  }

  private void findEventCount() {
    int[] arr = {1, 20, 4, 5, 7};
    int threshold = 3;
    int min =Integer.MAX_VALUE;
    int minIndex = 0;
    Map minStore = new HashMap();
    for(int i = 1 ;i < arr.length; i++){
      if(arr[i] < min){
        min = arr[i];
        minIndex = i;
      }
      minStore.put(arr[0], min);
      i = minIndex;
      while (i < arr.length){
        if(arr[i] < min){
          min = arr[i];
          minIndex = i;
        }
      }
    }
  }
}
