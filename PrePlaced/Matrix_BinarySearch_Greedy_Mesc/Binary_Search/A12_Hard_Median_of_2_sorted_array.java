/*
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class A12_Hard_Median_of_2_sorted_array {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    //to apply binary search on smaller array
    if(n1 > n2){
      return findMedianSortedArrays(nums2, nums1);
    }

    int n = n1+n2;
    int leftHalfSize = (n1+n2+1)/2; //adding 1 because to support odd and even length conditions

    int low = 0;
    int high = n1;
  
    while(low <= high){
      int mid1 = (low+high)/2;
      int mid2 = leftHalfSize - mid1;

      //assign min and max values incase of overflow of mid value
      int l1 = Integer.MIN_VALUE;
      int l2 = Integer.MIN_VALUE;

      int r1 = Integer.MAX_VALUE;
      int r2 = Integer.MAX_VALUE;

      //assign proper values
      if(mid1 > 0){
        l1 = nums1[mid1-1];
      }
      if(mid2 > 0){
        l2 = nums2[mid2-1];
      }
      if(mid1 < n1){
        r1 = nums1[mid1];
      }
      if(mid2 < n2){
        r2 = nums2[mid2];
      }

      //check if partition is correct
      if(l1 <= r2 && l2 <= r1){
        //if length is even
        if(n%2 == 0){
          return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
        } else {
          return (double)Math.max(l1, l2);
        }
      } else if(l1 > r2) {
        high = mid1-1;
      } else {
        low = mid1+1;
      }
    }

    return -1;
  }
}
