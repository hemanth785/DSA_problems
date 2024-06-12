package DynamicProgramming;

import java.util.Arrays;

/*
 * Frog jump with max k steps allowed
 * link: https://www.codingninjas.com/studio/problems/minimal-cost_8180930?leftPanelTab=1
 */
public class FrogJump2 {
  public static int minimizeCost(int n, int k, int[] height) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return frogJumpMemo2(n, k, n - 1, height, dp);
  }

  public static int frogJumpMemo2(int n, int k, int curIndex, int heights[], int[] dp) {
    if (curIndex == 0) {
      return 0;
    }
    if (curIndex == 1) {
      return Math.abs(heights[1] - heights[0]);
    }

    if (dp[curIndex] == -1) {
      int minCost = Integer.MAX_VALUE;
      for (int i = 1; i <= k; i++) {
        int nextIndex = curIndex - i;
        if (nextIndex >= 0) {
          int nexStepsCost = Math.abs(heights[curIndex] - heights[nextIndex]) + frogJumpMemo2(n, k, nextIndex, heights, dp);

          minCost = Math.min(minCost, nexStepsCost);
        }
      }
      dp[curIndex] = minCost;
    }
    return dp[curIndex];
  }
}
