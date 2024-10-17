
/*
 * Link: https://www.naukri.com/code360/problems/lower-bound_8165382
 */
public class A06_Lower_bound {
  public static int lowerBound(int[] arr, int n, int x) {
    if (x > arr[n - 1]) {
      return n;
    }

    int ans = n;

    int l = 0;
    int r = n - 1;

    while (l <= r) {
      int mid = (l + r) / 2;

      if (arr[mid] >= x) {
        ans = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return ans;
  }
}
