package DynamicProgramming;

import java.util.Arrays;
/*
 * Link: https://workat.tech/problem-solving/practice/unique-paths
 */
public class UniquePaths {
  static int mod = 1000000007;
  static int uniquePaths = 0;

  int uniquePaths(int m, int n) {
    int dp[][] = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return uniquePathsMemo(m-1, n-1, dp);
  }

  int uniquePathsMemo(int m, int n, int dp[][]) {
    if (m < 0 || n < 0) {
      return 0;
    }
    if (m == 0 && n == 0) {
      return 1;
    }
    if (dp[m][n] != -1) {
      return dp[m][n];
    }

    int top = uniquePathsMemo(m-1, n, dp);
    int left = uniquePathsMemo(m, n-1, dp);

    dp[m][n] = (top + left) % mod;

    return dp[m][n];
  }
}
