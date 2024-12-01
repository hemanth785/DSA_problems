package DP;

import java.util.Arrays;

/**
 * Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */
public class A26_Number_of_LongestIncreasingSubsequence {
  /*
   * Apporoach 1: Recursive
   * 
   * Time: O(2^n) Space: (call stack) O(n)
   */

  static int longestLISLen = 0;
  static int lisCount = 0;

  public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    longestLISLen = 0;
    lisCount = 0;

    findNumberOfLISMemo(nums, 0, -1, 0);

    return lisCount;
  }

  public void findNumberOfLISMemo(int[] nums, int curIndex, int prevIndex, int lisLength) {
    if (curIndex == nums.length) {
      if (lisLength > longestLISLen) {
        longestLISLen = lisLength;
        lisCount = 1;
      } else if (lisLength == longestLISLen) {
        lisCount++;
      }

      return;
    }

    // include current
    if (prevIndex == -1 || nums[curIndex] > nums[prevIndex]) {
      findNumberOfLISMemo(nums, curIndex + 1, curIndex, lisLength + 1);
    }

    // exclude current
    findNumberOfLISMemo(nums, curIndex + 1, prevIndex, lisLength);
  }


  /*
   * Approach 2: Using DP
   * 
   * - In this approach we would need 2 DP arrays, 
   *    - One for storing length of LIS from that index possible (till last of array)
   *    - One more for storing count of such LIS from that index to end of array
   * - Initially fill both the DP array with 1, as each item itself is the LIS having count 1
   * - Start from last but one index (i)
   * - then iterate from next item of (i) till the end of array
   * - If next item is greater that current item
   *   - check LIS_len_dp fo that item, if that (item_len+1) is greater than, current item LIS_len_DP
   *     -if yes, update current item LIS_len_dp with value '(item_len+1)'
   *     - copy that count to current item count
   *   - else - check LIS_len_dp fo that item, if that (item_len+1) is equal to, current item LIS_len_DP
   *     - then update the count with LIS_len_dp[i]+LIS_len_dp[j]
   * 
   * - Repeat the same process for all the elements
   * 
   * - Now iterate over DP arrays to calculate the Longest LIS count
   * 
   * 
   * Time: O(n^2), Space: O(n)
   */

  public int findNumberOfLIS_DP(int[] nums) {
    int n = nums.length;
    int longestLISLen = 0;
    int longestLISCount = 0;

    int[] lisLenDP = new int[n];
    int[] lisCountDP = new int[n];

    for(int i=0; i<n; i++){
      Arrays.fill(lisLenDP, 1);
      Arrays.fill(lisCountDP, 1);
    }

    for(int i=n-2; i >= 0; i--){
      for(int j=i+1; j<n; j++){

        //check if next item is greater than cur item
        if(nums[j] > nums[i]){
          if(lisLenDP[j]+1 > lisLenDP[i]){
            lisLenDP[i] = lisLenDP[j]+1;
            lisCountDP[i] = lisCountDP[j];

          } else if(lisLenDP[j]+1 == lisLenDP[i]){
            lisCountDP[i] = lisCountDP[j]+lisCountDP[i];
          }
        }

      }
    }

    for(int i=0; i<n; i++){
      if(lisLenDP[i] > longestLISLen){
        longestLISLen = lisLenDP[i];
        longestLISCount = lisCountDP[i];

      } else if(lisLenDP[i] == longestLISLen){
        longestLISCount += lisCountDP[i];
      }
    }
    return longestLISCount;
  }
}