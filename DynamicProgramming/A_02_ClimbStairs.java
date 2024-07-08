package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/climbing-stairs/description/
 */

public class A_02_ClimbStairs {
  public int climbStairs(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return climbStairsMemo(n, dp);
  }

  public int climbStairsMemo(int n, int[] dp) {
    if (n <= 1) {
      return 1;
    }
    if (dp[n] == -1) {
      // to reach nth step, either we can jump from (n-1)th step, or (n-2)th step
      dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
    }
    return dp[n];
  }
}
