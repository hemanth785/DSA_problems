

/*
 * Link: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 */
public class A09_Fixed_size_subarray_with_max_sum {
  public long maximumSumSubarray(int[] arr, int k) {
    int n = arr.length;
    int l = 0;
    int r = 0;
    
    long maxSubArrSum = 0;
    while(r<k){
      maxSubArrSum += arr[r++];
    }
    
    long sum = maxSubArrSum;
    while(r<n){
      sum = sum - arr[l++] + arr[r++];
      maxSubArrSum = Math.max(sum, maxSubArrSum);
    }
    
    return maxSubArrSum;
  }
}
