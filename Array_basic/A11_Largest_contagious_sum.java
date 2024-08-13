public class A11_Largest_contagious_sum {
  /*
   * link: https://leetcode.com/problems/maximum-subarray/
   * 
   * Given an integer array nums, find the subarray with the largest sum, and return its sum.
   *
   * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
   * Output: 6
   * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
   */
  public static void main(String[] args) {
    int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println(largestContiguousSum(arr));
  }

  /*
   * Approach: 
   * - Initialize MaxSum as minimum integer value
   * - Keep on calculating the sum for each element of array, while comparing it for MaxSum. 
   * - If sum becomes less than zero at any time, re-initialize it to 0
   * - At the end you should have maxSubarray sum
   */

  static int largestContiguousSum(int[] arr) {
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
      maxSum = Math.max(maxSum, sum);
      if (sum <= 0) {
        sum = 0;
      }
    }
    return maxSum;
  }
}
