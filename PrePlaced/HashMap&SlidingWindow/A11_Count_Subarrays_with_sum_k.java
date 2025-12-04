

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class A11_Count_Subarrays_with_sum_k {
  /*
   * Approach 1: Buteforce - Using 2 arrays
   * 
   * Time: O(n^2)  Space: O(1)
   */

  public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    int subArrayCount = 0;

    for(int i=0; i<n; i++){
      int sumSoFar = 0;
      for(int j=i; j<n; j++){
        sumSoFar += nums[j];
        if(sumSoFar == k){
          subArrayCount++;
        }
      }
    }

    return subArrayCount;
  }

  /*
   * Approach 2: Using HashMap to store prefix sums count
   * 
   * - Initiate prefixSum hashmap to store the count of all teh prefix sum occured so far
   * - Start with first element while calculating sum with every element
   * - each stage check if any prefixSum exists for (sumSoFar - k), if it exists update that prefix sum count in the result
   * - Update the sumSoFar count in the hashMap
   * 
   * Time: O(n)  Space: O(n)
   * 
   * Solution link: 
   */

  public int subarraySumOptimized(int[] nums, int k) {
    //This map contain all the prefixSums and the count of how many times that sum occured so far
    Map<Integer, Integer> prefSumMap = new HashMap<>();

    prefSumMap.put(0, 1);

    int n = nums.length;
    int sum = 0;
    int subArrayCount = 0;

    for(int i=0; i<n; i++){
      sum += nums[i];
      int prefixSum = sum-k;

      if(prefSumMap.containsKey(prefixSum)){
        subArrayCount += prefSumMap.get(prefixSum);
      }

      prefSumMap.put(sum, prefSumMap.getOrDefault(sum, 0)+1);
    }

    return subArrayCount;
  }
}
