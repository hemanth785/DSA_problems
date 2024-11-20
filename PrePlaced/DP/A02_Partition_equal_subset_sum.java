package DP;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class A02_Partition_equal_subset_sum {
  /*
   * Approach: DP
   * - here we have to use 2D DP
   * - we have to use memoization on [index] and the [diff b/w sum of two partitions]
   */
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int totalSum = 0;
    for(int num: nums){
      totalSum += num;
    }
    int dp[][] = new int[n+1][totalSum+1];
    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -1);
    }
    int res = canPartitionRec(nums, 0, 0, 0, dp);
    return res == 1;
  }

  public int canPartitionRec(int[] nums, int index, int sum1, int sum2, int dp[][]){
    if(index == nums.length){
      return sum1 == sum2 ? 1 : 0;
    }

    if(dp[index][Math.abs(sum1-sum2)] != -1){
      return dp[index][Math.abs(sum1-sum2)];
    }
    int addToLeft = canPartitionRec(nums, index+1, sum1+nums[index], sum2, dp);
    int addToRight = canPartitionRec(nums, index+1, sum1, sum2+nums[index], dp);

    dp[index][Math.abs(sum1-sum2)] = (addToLeft == 1 || addToRight == 1)? 1: 0;
    return dp[index][Math.abs(sum1-sum2)];
  }
}
