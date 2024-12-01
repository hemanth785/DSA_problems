package DP;

import java.util.Arrays;

//this is same as LongestIncreasingSubsequesce, but here we need to consider the sum of values of each elements instead of count
public class A25_LongestIncreasingSubsequesce_sum {

//My solution: Simple
  /*
   * - Start from the end of array, initially consider n+1 as prev item
   * - follow the approach of include and exclude, 
   *    - where include func call made only when (if its last element of array || current element is lesser than prev element)
   */
  int maxSumSubsequence(int[] arr) {
    int n = arr.length;
    int dp[][] = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return maxSumRec(arr, n-1, n, dp);
  }

  int maxSumRec(int arr[], int index, int prevIndex, int[][] dp) {
    if (index < 0) {
      return 0;
    }
    if (prevIndex != arr.length && dp[index][prevIndex] != -1) {
      return dp[index][prevIndex];
    }

    int includeSum = 0;
    // if this is the 1st element processing or cur element is less than prev, calculate include sum
    if (prevIndex >= arr.length || arr[index] < arr[prevIndex]) {
      includeSum = arr[index] + maxSumRec(arr, index - 1, index, dp);
    }

    int excludeSum = maxSumRec(arr, index - 1, prevIndex, dp);

    dp[index][prevIndex] = Math.max(includeSum, excludeSum);
    return dp[index][prevIndex];
  }

  
}
