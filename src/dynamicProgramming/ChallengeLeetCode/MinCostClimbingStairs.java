package dynamicProgramming.ChallengeLeetCode;

//You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
//Once you pay the cost, you can either climb one or two steps.
//You can either start from the step with index 0, or the step with index 1.
//Return the minimum cost to reach the top of the floor.
public class MinCostClimbingStairs {

  public static void main(String[] args) {
    MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
    int[] cost = { 1,100,1,1,1,100,1,1,100,1};

    int minCost = minCostClimbingStairs.getMinimumCostToReachTopFloor(cost);

  }

  private int getMinimumCostToReachTopFloor(int[] cost) {
   return 1;
  }
}
