package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
  public int rob(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return robHouseDp(nums, n, dp, 0);
  }

  /*
   * approach: 
   * - starting from 1st index, if we are includeing the current house then next house to rob in 1+2, i.e 3
   * - if we are excluding current house, then we can rob adhascent house to current house
   */
  public int robHouseDp(int[] nums, int n, int[] dp, int curIndex) {
    if (curIndex >= n) {
      return 0;
    }
    if (dp[curIndex] == -1) {
      // if you are robing current house, then option is house after the next house
      int profit1 = nums[curIndex] + robHouseDp(nums, n, dp, curIndex + 2);

      // this is skipping current house, and starting from next house
      int profit2 = robHouseDp(nums, n, dp, curIndex + 1);
      dp[curIndex] = Math.max(profit1, profit2);
    }
    return dp[curIndex];
  }
}
