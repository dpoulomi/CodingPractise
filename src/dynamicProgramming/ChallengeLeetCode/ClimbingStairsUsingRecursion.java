package dynamicProgramming.ChallengeLeetCode;

public class ClimbingStairsUsingRecursion {

  public static void main(String[] args) {
    int ways[] = { 1, 2 };
    int stairs = 4;
    ClimbingStairsUsingRecursion climbingStairsUsingRecursion = new ClimbingStairsUsingRecursion();
    System.out.println(climbingStairsUsingRecursion.findDistinctWays(ways, stairs));
  }

  private int findDistinctWays(int[] ways, int stairs) {
    if (stairs <= 2) {
      return stairs;
    }
    return findDistinctWays(ways, stairs - 1) + findDistinctWays(ways, stairs - 2);

  }
}
