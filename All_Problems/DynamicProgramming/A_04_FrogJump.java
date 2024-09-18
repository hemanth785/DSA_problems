package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://www.codingninjas.com/studio/problems/frog-jump_3621012?leftPanelTab=1
 */
public class A_04_FrogJump {
  public static int frogJump(int n, int heights[]) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return frogJumpMemo(n, n - 1, heights, dp);
  }

  /*
   * Here the approach is, for reaching last step, frog can either jump from (last-1) step or (last-2) step, so calculate the minEnLost in both cases
   */
  public static int frogJumpMemo(int n, int curIndex, int heights[], int[] dp) {
    //if frog already reached 0th step
    if (curIndex == 0) {
      return 0;
    }
    //if from is at last but one step, then it can only jump one step to reach last step
    if (curIndex == 1) {
      return Math.abs(heights[1] - heights[0]);
    }

    //otherwise recurse for one and two steps from each step
    if (dp[curIndex] == -1) {
      int oneStep = frogJumpMemo(n, curIndex - 1, heights, dp);
      int twoStep = frogJumpMemo(n, curIndex - 2, heights, dp);

      dp[curIndex] = Math.min(
        oneStep + Math.abs(heights[curIndex] - heights[curIndex - 1]),
        twoStep + Math.abs(heights[curIndex] - heights[curIndex - 2])
      );
    }
    return dp[curIndex];
  }
}
