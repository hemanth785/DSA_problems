package DynamicProgramming;

import java.util.Arrays;
/*
 * Link: https://leetcode.com/problems/minimum-path-sum/description/
 */
public class A_25_GridMinPathSum {
  public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int dp[][] = new int[n][m];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return minPathSumMemo(grid, n - 1, m - 1, dp);
  }

  public int minPathSumMemo(int[][] grid, int n, int m, int dp[][]) {
    if (n == 0 && m == 0) {
      return grid[n][m];
    }
    // invalid path
    if (n < 0 || m < 0) {
      return Integer.MAX_VALUE;
    }

    if (dp[n][m] != -1) {
      return dp[n][m];
    }

    int topMove = minPathSumMemo(grid, n - 1, m, dp);
    int leftMove = minPathSumMemo(grid, n, m - 1, dp);

    dp[n][m] = grid[n][m] + Math.min(topMove, leftMove);

    return dp[n][m];
  }
}
