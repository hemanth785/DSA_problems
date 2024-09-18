package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class A_28_LongestIncreasingSubsequence {
  /*
   * Approach: Using include and exclude technique
   */
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[][] = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    int res = lengthOfLISMemo(nums, 0, -1, dp);

    return res == 0 ? 1 : res;
  }

  public int lengthOfLISMemo(int[] nums, int curIndex, int prevIndex, int[][] dp) {
    if (curIndex >= nums.length) {
      return 0;
    }

    if (prevIndex != -1 && dp[prevIndex][curIndex] != -1) {
      return dp[prevIndex][curIndex];
    }

    int includeLength = 0;
    // include current
    if (prevIndex == -1 || nums[curIndex] > nums[prevIndex]) {
      includeLength = 1 + lengthOfLISMemo(nums, curIndex + 1, curIndex, dp);
    }

    // exclude current
    int excludeLength = lengthOfLISMemo(nums, curIndex + 1, prevIndex, dp);

    if (prevIndex != -1) {
      dp[prevIndex][curIndex] = Math.max(includeLength, excludeLength);
      return dp[prevIndex][curIndex];
    }
    return Math.max(includeLength, excludeLength);
  }
}
