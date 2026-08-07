/*
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class A12_Hard_Median_of_2_sorted_array {
  /*
   * Approach 1: virtually merging 2 arrays until we reach half of entire merged array
   * 
   * Time: O(n+m), Space: O(1)
   */


  /*
   * Approach 2: Applying binary search directly on given arrays
   * 
   * Time: O(log(min(n,m))
   */
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

  /*
   * Approach 4: Same binary search as Approach 2, cleaner naming
   *
   * Core idea — split both arrays into LEFT | RIGHT halves:
   *
   *   nums1: [ ... leftA | rightA ... ]
   *   nums2: [ ... leftB | rightB ... ]
   *
   * Valid partition when:
   *   max(leftA) <= min(rightB)  AND  max(leftB) <= min(rightA)
   *
   * Time: O(log(min(m, n))), Space: O(1)
   */
  public double findMedianSortedArraysClean(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArraysClean(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;
    int leftHalfSize = (m + n + 1) / 2;

    int lo = 0;
    int hi = m;

    while (lo <= hi) {
      int cutA = (lo + hi) / 2;
      int cutB = leftHalfSize - cutA;

      int maxLeftA  = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
      int maxLeftB  = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];
      int minRightA = cutA == m ? Integer.MAX_VALUE : nums1[cutA];
      int minRightB = cutB == n ? Integer.MAX_VALUE : nums2[cutB];

      if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
        if ((m + n) % 2 == 1) {
          return Math.max(maxLeftA, maxLeftB);
        }
        return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
      } else if (maxLeftA > minRightB) {
        hi = cutA - 1;
      } else {
        lo = cutA + 1;
      }
    }

    return -1;
  }
}
