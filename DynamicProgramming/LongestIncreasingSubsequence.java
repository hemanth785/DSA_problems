package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
  int ans = 1;

  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    longestLISRecursiveMemo(nums, n - 1, dp);
    return ans;
  }

  public int longestLISRecursiveMemo(int[] nums, int n, int[] dp) {
    if (n == 0) {
      return 1;
    }
    if (dp[n] == -1) {
      int lis = 1;

      // this will calculate LIS considering nth element as last element of
      // subsequence
      for (int i = 0; i < n; i++) {
        if (nums[i] < nums[n]) {
          lis = Math.max(lis, 1 + longestLISRecursiveMemo(nums, i, dp));
        }
      }

      // this will calculate LIS considering all other element as last element of
      // subsequence
      longestLISRecursiveMemo(nums, n - 1, dp);
      dp[n] = lis;
      ans = Math.max(ans, lis);
    }

    return dp[n];
  }
}
