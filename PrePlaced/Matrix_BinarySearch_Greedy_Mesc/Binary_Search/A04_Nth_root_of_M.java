

/*
 * Link: https://www.naukri.com/code360/problems/nth-root-of-m_1062679
 */
public class A04_Nth_root_of_M {
  /*
   * Approach: Using binary search 
   */
  public static int NthRoot(int n, int m) {
    int l = 1;
    int r = m / n;

    while (l <= r) {
      int mid = (l + r) / 2;

      int powerValue = findPower(mid, n, m);

      if (powerValue == m) {
        return mid;
      } else if (powerValue > m) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return -1;
  }

  public static int findPower(int x, int n, int m) {
    long powerValue = 1;
    for (int i = 0; i < n; i++) {
      powerValue *= x;

      if (powerValue > m) { //this is to avoid int overflow situation
        return m + 1;
      }
    }

    return (int) powerValue;
  }
}
