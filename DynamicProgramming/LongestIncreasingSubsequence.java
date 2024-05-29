package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

  /*
   * DP: Tabulation method - Simple to understand
   * 
   * - initilze lis(dp) as 1 for each index - means at each index initially length of lis = 1
   * - Start from the end of the array - find the longest increasing subsequence length for last item - it'll be 1
   * - for i th item, length of lis will be = Math.max(1, lis(i+1), lis(i+2), ... lis(n-1))
   * 
   * Time: O(n^2), Space: O(n)
   */

   int getLengthOfLIS(int[] nums) {
		int n = nums.length;
        int lis[] = new int[n+1]; //this is the dp we are using
        Arrays.fill(lis, 1); //initially assume for each index LIS is 1

        int maxLis = 0;
		//start from the end of array
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(nums[i] < nums [j]){
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
            }

			// this is for- max lis can start from anywhere in the array
			// so we have to consider the max length from each index
            maxLis = Math.max(maxLis, lis[i]);
        }

        return maxLis;
	}


  
//My solution: Simple (choose this one)
  /*
   * - Start from the end of array, initially consider n+1 as prev item
   * - follow the approach of include and exclude, 
   *    - where include func call made only when (if its last element of array || current element is lesser than prev element)
   */
  public int lengthOfLISDP(int[] arr) {
    int n = arr.length;
    int dp[][] = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return lengthOfLISMemo(arr, n - 1, n, dp);
  }

  int lengthOfLISMemo(int arr[], int index, int prevIndex, int[][] dp) {
    if (index < 0) {
      return 0;
    }
    if (prevIndex != arr.length && dp[index][prevIndex] != -1) {
      return dp[index][prevIndex];
    }

    int includeSum = 0;
    if (prevIndex >= arr.length || arr[index] < arr[prevIndex]) { // need to check for <= if possible
      includeSum = 1 + lengthOfLISMemo(arr, index - 1, index, dp);
    }

    int excludeSum = lengthOfLISMemo(arr, index - 1, prevIndex, dp);

    dp[index][prevIndex] = Math.max(includeSum, excludeSum);

    return dp[index][prevIndex];
  }




  /* 
   * Approach 2: DP: Recursive approach - Little difficult to understand 
   * 
   * Time: O(n^2), Space: O(n)
   */
  int ans = 1;
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    longestLISRecursiveMemo(nums, n - 1, dp);
    return ans;
  }

  //TODO: this needs to be done again from my side

  public int longestLISRecursiveMemo(int[] nums, int n, int[] dp) {
    if (n == 0) {
      return 1;
    }
    if (dp[n] == -1) {
      int lis = 1;

      // this will calculate LIS considering nth element as last element of subsequence
      for (int i = 0; i < n; i++) {
        if (nums[i] < nums[n]) {
          lis = Math.max(lis, 1 + longestLISRecursiveMemo(nums, i, dp));
        }
      }

      // this will calculate LIS considering all other element as last element of subsequence
      longestLISRecursiveMemo(nums, n - 1, dp);
      dp[n] = lis;
      ans = Math.max(ans, lis);
    }

    return dp[n];
  }
}
