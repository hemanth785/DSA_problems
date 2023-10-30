package DynamicProgramming;

import java.util.Arrays;

public class EggDropPuzzle {
  static int minAttempts = Integer.MAX_VALUE;

  static int eggDrop(int n, int k) {
    int dp[][] = new int[n + 1][k + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return eggDropMemo(n, k, dp);
  }

  static int eggDropMemo(int n, int k, int[][] dp) {
    if (n == 1) {
      return k;
    }
    if (k == 1) {
      return 1;
    }

    if (dp[n][k] != -1) {
      return dp[n][k];
    }
    int minAttempts = Integer.MAX_VALUE;
    for (int i = 1; i <= k; i++) {
      int breakCase = 1 + eggDropMemo(n - 1, i - 1, dp);
      int notBreakCase = 1 + eggDropMemo(n, k - i, dp);

      int attempts = Math.max(breakCase, notBreakCase);
      minAttempts = Math.min(minAttempts, attempts);
    }
    dp[n][k] = minAttempts;

    return dp[n][k];
  }
}
