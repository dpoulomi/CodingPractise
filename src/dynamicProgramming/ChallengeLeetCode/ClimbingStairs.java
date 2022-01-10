package dynamicProgramming.ChallengeLeetCode;

public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    int numberOfSteps = 4;
    int[] ways = {1, 2};

    int numberOfWays = climbingStairs.findNumberOfWays(numberOfSteps, ways);
  }

  private int findNumberOfWays(int numberOfSteps, int[] ways) {

    int[] numberOfWays = new int[numberOfSteps + 1];
    return numberOfWays[numberOfSteps];
  }
}
