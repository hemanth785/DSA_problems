package Array_advanced;
/*
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class A06_FindMinInSortedRotated {
  /*
   * Link: Use binary search
   * - We need to find the bitonic point, in the bitonic point, the item next to bitonic item is the min element
   */
  public int findMin(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    if (nums[0] < nums[n - 1]) {
      return nums[0];
    }

    int l = 0;
    int r = n - 1;

    while (l < r) {
      int mid = l + (r - l) / 2;

      if (mid + 1 < n && nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
        return nums[mid];
      } else if (nums[l] < nums[mid]) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return -1;
  }
}
