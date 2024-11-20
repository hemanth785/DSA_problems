package DP;

import java.util.Arrays;

/*
 * Link: https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum._842494
 */
public class A03_Partition_subset_with_min_sum {
  public static int minSubsetSumDifference(int []nums, int n) {
    int totalSum = 0;
    for(int num: nums){
      totalSum += Math.abs(num);
    }
    int dp[][] = new int[n+1][totalSum+1];

    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -2);
    }

    return minimumDifferenceMemo(nums, 0, 0, 0, 0, 0, dp);
  }

public static int minimumDifferenceMemo(int[] nums, int index, int sum1, int sum2, int len1, int len2, int[][] dp){
    if(index == nums.length){
      return Math.abs(sum1-sum2);
    }

    int memoVal = dp[index][Math.abs(sum1-sum2)];
    if(memoVal != -2){
      return memoVal;
    }

    int item = nums[index];
    int leftAddDiff = minimumDifferenceMemo(nums, index+1, sum1+item, sum2, len1+1, len2, dp);
    int rightAddDiff = minimumDifferenceMemo(nums, index+1, sum1, sum2+item, len1, len2+1, dp);

    if(leftAddDiff == -1 && rightAddDiff == -1){
      dp[index][Math.abs(sum1-sum2)] = -1;
    } else if(leftAddDiff == -1){
      dp[index][Math.abs(sum1-sum2)] = rightAddDiff;
    } else if(rightAddDiff == -1){
      dp[index][Math.abs(sum1-sum2)] = leftAddDiff;
    } else {
      dp[index][Math.abs(sum1-sum2)] = Math.min(leftAddDiff, rightAddDiff);
    }

    return dp[index][Math.abs(sum1-sum2)];
  }
}
