package Greedy;
/*
 * Link: https://leetcode.com/problems/maximum-subarray/
 */
public class A06_MaxSumSubarray {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;

    int l = 0;
    int r = 0;

    // check if array has only negative element, if thats the case return the max
    // value among the negative values
    boolean isPositiveFound = false;
    for(int i = 0; i < n; i++){
      if(nums[i] >= 0){
        maxSum = 0;
        sum = 0;
        isPositiveFound = true;
        break;
      } else {
        maxSum = Math.max(maxSum, nums[i]);
      }
    }

    if (!isPositiveFound) {
      return maxSum;
    }

    //check max sum from left side
    for (int i = 0; i < n; i++) {
      sum = sum + nums[i];
      if (sum <= 0) {
        sum = 0;
      } else {
        maxSum = Math.max(maxSum, sum);
      }
    }

    //check max sum from right side
    sum = 0;
    for (int i = n - 1; i >= 0; i--) {
      sum = sum + nums[i];
      if (sum <= 0) {
        sum = 0;
      } else {
        maxSum = Math.max(maxSum, sum);
      }
    }

    return maxSum;
  }
}
