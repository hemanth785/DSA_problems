

/*
 * Link: https://www.naukri.com/code360/problems/implement-upper-bound_8165383
 */
public class A05_Upper_Bound {
  /*
   * Approach: Binary search
   * - Initialize ans index as size of given array (because this is what we need to return if upper bound not found in input array)
   * - start from the middle index, and check if arr[mid] is greater than given 'x'
   *    - if yes, then this could be potential upper bound element, save it in ans and move right pointer to mid-1 pos (because we want to check if any smaller upper bound exists)
   *    - if no, just move left pointer to mid+1 pos
   * 
   * - Once l>r, break the loop and return ans
   */

  public static int upperBound(int[] arr, int x, int n) {
    int l = 0;
    int r = n - 1;
    int ans = n;

    while (l <= r) {
      int mid = (l + r) / 2;

      if (arr[mid] > x) {
        ans = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return ans;
  }
}
