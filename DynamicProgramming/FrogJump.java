package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://www.codingninjas.com/studio/problems/frog-jump_3621012?leftPanelTab=1
 */
public class FrogJump {
  public static int frogJump(int n, int heights[]) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return frogJumpMemo(n, n - 1, heights, dp);
  }

  /*
   * Here the approach is, for reaching last temp, frog can either jump from (last-1) step or (last-2) step, so calculate the minEnLost in both cases
   */
  public static int frogJumpMemo(int n, int curIndex, int heights[], int[] dp) {
    if (curIndex == 0) {
      return 0;
    }
    if (curIndex == 1) {
      return Math.abs(heights[1] - heights[0]);
    }

    if (dp[curIndex] == -1) {
      int oneStep = frogJumpMemo(n, curIndex - 1, heights, dp);
      int twoStep = frogJumpMemo(n, curIndex - 2, heights, dp);

      dp[curIndex] = Math.min(
          oneStep + Math.abs(heights[curIndex] - heights[curIndex - 1]),
          twoStep + Math.abs(heights[curIndex] - heights[curIndex - 2]));
    }
    return dp[curIndex];
  }
}
