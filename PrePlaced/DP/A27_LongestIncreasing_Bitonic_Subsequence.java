package DP;

import java.util.Arrays;

/*
 * Link: https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
 */
public class A27_LongestIncreasing_Bitonic_Subsequence {
  public static void main(String[] args) {
    
  }

  /*
   * Approach: Using DP - Tabulation
   * 
   * 1. First find the dp1 array for longest increasing subsequence from starting of array
   * 2. Then find the dp2 array for longest increasing subsequence from end of array
   * 3. Then check for each position, where dp1[i]+dp2[i] is the highest, and that is the longest increasing bitonic subsequence
   * 
   * Note: dp1[i] signifies the, longest increasign subsequence length till index 'i' starting from the begining of array 
   *       dp2[i] signifies the, longest increasign subsequence length till index 'i' starting from the end of array 
   */
  public static int LongestBitonicSequence(int n, int[] nums) {
    int dp1[] = new int[n]; //Longest increasing
    int dp2[] = new int[n]; //Longest decreasing
    
    Arrays.fill(dp1, 0);
    Arrays.fill(dp2, 0);
    
    for(int i=0; i<n; i++){
      for(int prevInd = 0; prevInd < i; prevInd++){
        if(nums[prevInd] < nums[i]){
          dp1[i] = Math.max(dp1[i], 1+dp1[prevInd]);
        }
      }
    }
    
    for(int i=n-1; i>=0; i--){
      for(int prevInd = n-1; prevInd > i; prevInd--){
        if(nums[prevInd] < nums[i]){
          dp2[i] = Math.max(dp2[i], 1+dp2[prevInd]);
        }
      }
    }
    
    int longestBitonicSubsequenceLength = 0;
    for(int i=0; i<n; i++){
      if(dp1[i] != 0 && dp2[i] != 0){
        longestBitonicSubsequenceLength = Math.max(longestBitonicSubsequenceLength, dp1[i]+dp2[i]+1); 
      }
    }
    
    return longestBitonicSubsequenceLength;
  }
}
