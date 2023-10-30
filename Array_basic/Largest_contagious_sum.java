public class Largest_contagious_sum {
  /*
   * link: https://leetcode.com/problems/maximum-subarray/
   */
  public static void main(String[] args) {
    
  }

  /*
   * Approach: 
   * - Initialize MaxSum as minimum integer value
   * - Keep on calculating the sum for each element of array, while comparing it for MaxSum. 
   * - If sum becomes less than zero at any time, re-initialize it to 0
   * - At the end you should have maxSubarray sum
   */

  int largestContiguousSum(int[] arr){
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum = sum + arr[i];
						maxSum = Math.max(maxSum, sum);
			if(sum <= 0){
				sum = 0;
			}
		}
		return maxSum;
	}
}
