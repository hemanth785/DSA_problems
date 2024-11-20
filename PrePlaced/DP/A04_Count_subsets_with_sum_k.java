package DP;

import java.util.Arrays;

/*
 * Link: https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532
 */
public class A04_Count_subsets_with_sum_k {
  static long maxResVal = (long)Math.pow(10, 9)+7;
  public static int findWays(int nums[], int target) {
    int n = nums.length;
    int dp[][] = new int[n+1][target+1];
    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -1);
    }

    return findWaysMemo(nums, target, 0, dp);
  }

  public static int findWaysMemo(int nums[], int target, int index, int[][] dp){
      
    if(target < 0){
      return 0;
    }
    if(target == 0){
      return 1;
    }
    if(index >= nums.length){
      return 0;
    }

    if(dp[index][target] != -1){
      return dp[index][target];
    }

    int num = nums[index];
    long include = findWaysMemo(nums, target-num, index+1, dp);
    long exclude = findWaysMemo(nums, target, index+1, dp);

    long result = include+exclude;

    dp[index][target] = (int)(result > maxResVal ? result%maxResVal : result);

    return dp[index][target];
  }
}
