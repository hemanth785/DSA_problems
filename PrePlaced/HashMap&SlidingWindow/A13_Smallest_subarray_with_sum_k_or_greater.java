

/*
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Note: This problem contains only positive numbers
 */
public class A13_Smallest_subarray_with_sum_k_or_greater {


  /*
   * Approach: Using sliding window
   */
  public int minSubArrayLen(int k, int[] nums) {
    int n = nums.length;
    int sum = 0;

    int l=0;
    int r=0;

    int len = Integer.MAX_VALUE;

    while(r<n && l<=r){
      if(sum >= k){
        len = Math.min(len, r-l);
        sum = sum - nums[l++];
      } else {
        sum = sum + nums[r++];
      }
    }

    while(l<n  && sum >= k){
      len = Math.min(len, r-l);
      sum = sum - nums[l++];
    }

    return len == Integer.MAX_VALUE ? 0 : len;
  }
}
