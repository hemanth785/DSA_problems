package DynamicProgramming;

import java.util.Arrays;
/*
 * link: https://workat.tech/problem-solving/practice/egg-dropping
 */

public class EggDropPuzzle {

  /*
   * Approach: DP with memoization
   */
  // k-number of eggs, n-number of floors
  int minimumMoves(int k, int n) {
    int dp[][] = new int[n + 1][k + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return eggDropMemo(k, n, dp);
  }

  int eggDropMemo(int k, int n, int dp[][]) {
    // base case - if one egg is there, answer will be number of floors
    if (k == 1) {
      return n;
    }
    // base case - if floor is one, then there is only one possibility
    if (n == 1) {
      return 1;
    }

    if (dp[n][k] != -1) {
      return dp[n][k];
    }

    //handling edge case
    if (n < 1) {
      return 0;
    }

    int minAttempts = Integer.MAX_VALUE;

    // calculate number of attempts required, if we start from each floor
    for (int i=1; i<=n; i++) {
      // if egg broken, check for the floors below current floor, with one less egg
      int breakCase = eggDropMemo(k - 1, i - 1, dp);

      // if egg broken, check for the floors above current floor, with same eggs(k)
      int notBreakCase = eggDropMemo(k, n - i, dp);

      // consider the scenario with max attempts required
      int maxTimeOfBothScenario = 1 + Math.max(breakCase, notBreakCase);

      // find min attempts among all the floors as starting point
      minAttempts = Math.min(minAttempts, maxTimeOfBothScenario);
    }
    dp[n][k] = minAttempts;
    return minAttempts;
  }

  /*
   * Approach we can also solve it using, DP with Binary search
   * Link here: https://leetcode.com/problems/super-egg-drop/solutions/4445104/c-java-solution-explained-using-dp-binary-search/
   */
}
