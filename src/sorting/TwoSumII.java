package sorting;

public class TwoSumII {

  public static void main(String[] args) {
    int[] arr = { 2, 7, 11, 15 };
    int target = 9;
    TwoSumII sumII = new TwoSumII();
    int[] output = sumII.twoSum(arr, target);
    System.out.println(output[0] + "," + output[1]);
  }

  public int[] twoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;
    int[] result = new int[2];
    while (i < j) {
      if (numbers[i] + numbers[j] == target) {
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
      } else if (numbers[i] + numbers[j] > target) {
        j = j - 1;
      } else if (numbers[i] + numbers[j] < target) {
        i = i + 1;
      }
    }
    return result;
  }
}
