package dynamicProgramming.ChallengeLeetCode;

public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    int numberOfSteps = 4;
    int[] ways = { 1, 2 };
    System.out.println(climbingStairs.findNumberOfWays(numberOfSteps, ways));

  }

  private int findNumberOfWays(int numberOfSteps, int[] ways) {

    int[] numberOfWays = new int[numberOfSteps + 1];
    numberOfWays[0] = 1;
    numberOfWays[1] = 1;

    for (int i = 2; i <= numberOfSteps; i++) {
      numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 2];
    }
    return numberOfWays[numberOfSteps];
  }
}
