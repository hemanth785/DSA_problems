

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://workat.tech/problem-solving/practice/longest-subarray-zero-sum
 */
public class A10_LongestSubArrWithZeroSum {
  /*
   * Approach 1: Using bruteforce - two loops
   * Time: O(n^2), Space: O(1)
   */
  static int longestSubarrayWithZeroSum(int[] A) {
		int n = A.length;
		int maxLen = 0;
	    for(int i=0; i<n; i++){
			int sum = 0;
			for(int j=i; j<n; j++){
				sum += A[j];
				if(sum == 0){
					maxLen = Math.max((j-i)+1, maxLen);
				}
			}
		}
		
		return maxLen;
	}

  /*
   * Approach 2: Storing prefix sum in hashMap
   * 
   * Steps:
   * Initialize maximum length as 0.
   * Traverse the array and keep updating the sum for every i. Check if the sum is present in the hashmap or not.
   * If the sum is not present in the hashmap then put the sum in the hash map with the index as key(sum)-value(index) pair.
   * If the sum is present in the hashmap, take the difference between the current index and the index stored in the hashmap and update the maximum length.
	 * 
	 * Logic: If we come accross the same sum, which we have encountered before, 
	 * that means b/w those 2 sums, elements which are present will add upto zero.
	 * 
	 * If we come accross prefSum as zero, that means from starting of array to current positions, all the elements will add upto 0
   * 
   * Time: O(n), Space: O(n)
   */

   static int longestSubarrayWithZeroSumMap(int[] A) {
		int n = A.length;
		int maxLen = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		int prefixSum = 0;
		
		for(int i=0; i<n; i++){
			prefixSum += A[i];
			if(map.containsKey(prefixSum)){
				maxLen = Math.max(maxLen, i - map.get(prefixSum));
			} else if(prefixSum == 0){
				maxLen = i+1;
			} else {
				map.put(prefixSum, i);
			}
		}
		
		return maxLen;
	}
}
