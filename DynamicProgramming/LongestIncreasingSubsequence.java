package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

  
//My solution: Simple (choose this one)
  /*
   * - Start from the end of array, initially check for last(nextIndex) and last but one(index)
   * - follow the approach of include and exclude, 
   * - if its a 1st iteration or condition is satisfying (current < nextElement)
   *      - then call for both include and exlude recursion call
   *   or
   *      - call for only exclude recursion call
   * 
   * - terminate when we reach start of array
   */
  public int lengthOfLISDP(int[] arr) {
    int n = arr.length;
    int dp[][] = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return lengthOfLISMemo(arr, n - 1, n, dp);
  }

  int lengthOfLISMemo(int arr[], int index, int nextIndex, int[][] dp) {
    if (index < 0) {
      return 0;
    }
    if (nextIndex != arr.length && dp[index][nextIndex] != -1) {
      return dp[index][nextIndex];
    }

    int includeCount = 0;
    //call for inclusion only when current element is lesser than next element
    if (nextIndex >= arr.length || arr[index] < arr[nextIndex]) {
      includeCount = 1 + lengthOfLISMemo(arr, index - 1, index, dp);
    }

    int excludeSum = lengthOfLISMemo(arr, index - 1, nextIndex, dp);

    dp[index][nextIndex] = Math.max(includeCount, excludeSum);

    return dp[index][nextIndex];
  }
}
