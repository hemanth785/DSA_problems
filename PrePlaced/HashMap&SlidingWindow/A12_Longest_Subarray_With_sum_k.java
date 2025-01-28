

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 */
public class A12_Longest_Subarray_With_sum_k {
  /*
   * Approach 1: Buteforce - Using 2 arrays
   * 
   * Time: O(n^2)  Space: O(1)
   */

  public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    int len = 0;

    for(int i=0; i<n; i++){
      int sumSoFar = 0;
      for(int j=i; j<n; j++){
        sumSoFar += nums[j];
        if(sumSoFar == k){
          len = Math.max(len, j-i);
        }
      }
    }

    return len;
  }

  /*
   * Approach 2: Buteforce - Using HashMap to store prefix sums index
   * 
   * - Initiate prefixSum hashmap to store the index of first occurance prefix sum
   * - Start with first element while calculating sum with every element
   * - each stage check if any prefixSum exists for (sumSoFar - k), if it exists compare the maxLength with - (index - map.get(sumSoFar - k))
   * - Update the sumSoFar index in the hashMap (If it does not already exists)
   * 
   * Time: O(n)  Space: O(n)
   * solution link: https://www.youtube.com/watch?v=yDeNqw_dAU0
   */

  public int lenOfLongestSubarr(int[] nums, int k) {
    Map<Integer, Integer> prefSumMap = new HashMap<>();
    prefSumMap.put(0, -1);

    int n = nums.length;
    int sum = 0;
    int len = 0;

    for(int i=0; i<n; i++){
      sum += nums[i];
      
      if(prefSumMap.containsKey(sum-k)){
        len = Math.max(len, i-prefSumMap.get(sum-k));
      }
      if(!prefSumMap.containsKey(sum)){
        prefSumMap.put(sum, i);
      }
    }

    return len;
  }



}
