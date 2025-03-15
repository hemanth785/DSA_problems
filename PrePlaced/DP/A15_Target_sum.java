package DP;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/target-sum/
 */
public class A15_Target_sum {
  /*
   * Approach: Using recursion
   * - We can apply direct recursion with a basis that, 
   * - for each item either assign + or - sign and continue with expression
   * 
   * Time: O(2^n), Space: Aux space - O(n)
   * 
   */
  public int findTargetSumWays(int[] nums, int target) {
    return findTargetSumWaysMemo(nums, target, 0, 0);
  }

  public int findTargetSumWaysMemo(int[] nums, int target, int index, int sumSoFar){
    if(index == nums.length){
      if(sumSoFar == target){
        return 1;
      } else {
        return 0;
      }
    }

    int assignPosWays = findTargetSumWaysMemo(nums, target, index+1, sumSoFar+nums[index]);
    int assignNegWays = findTargetSumWaysMemo(nums, target, index+1, sumSoFar-nums[index]);

    return assignPosWays + assignNegWays;
  }


   /*
   * Approach: Using DP
   * 
   * Time: O(n), Space: O(n*totalSum), Aux space(recursion stack): O(n)
   * 
   * Note: Here 'totalSum' is just a buffer used to avoid negative numbers, 
   * because dp[] index wont support negative numbers
   */
  
  public int findTargetSumWaysDP(int[] nums, int target) {
    int n = nums.length;
    int totalSum = 0;
    for(int i=0; i<n; i++){
      totalSum += nums[i];
    }

    int dp[][] = new int[n+1][(totalSum*2)+1];  //we need to calculate max negative sum to max positive sum
    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -1);
    }
    return findTargetSumWaysMemo2(nums, target, 0, 0, dp, totalSum);
  }

  public int findTargetSumWaysMemo2(int[] nums, int target, int index, int sumSoFar, int[][] dp, int totalSum){
    if(index == nums.length){
      if(sumSoFar == target){
        return 1;
      } else {
        return 0;
      }
    }

    int memoVal = dp[index][sumSoFar+totalSum]; // here sumSoFar can become negative, so add totalSum (if totalSum = 5 and sumSoFar= -3, then it'll become 5-3 = 2)
    if(memoVal != -1){
      return memoVal;
    }

    int assignPosWays = findTargetSumWaysMemo2(nums, target, index+1, sumSoFar+nums[index], dp, totalSum);
    int assignNegWays = findTargetSumWaysMemo2(nums, target, index+1, sumSoFar-nums[index], dp, totalSum);

    dp[index][sumSoFar+totalSum] = assignPosWays + assignNegWays;
    return dp[index][sumSoFar+totalSum];
  }
}



