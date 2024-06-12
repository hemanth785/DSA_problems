package DynamicProgramming;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/description/
 */

public class CoinsChange {
  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int dp[][] = new int[n + 1][amount + 1];
    for (int[] row : dp) {
      // here using -2 as default, because -1 is already used for indicationg invalue
      // coin combination
      Arrays.fill(row, -2);
    }
    return coinsChangeMemo(coins, amount, n - 1, dp);
  }

  public int coinsChangeMemo(int[] coins, int amount, int n, int[][] dp) {
    if (amount == 0) {
      return 0;
    }

    // if we are returning the -1, then we should not consider it as valid result.
    // we should ignore it
    if (amount < 0 || n < 0) {
      return -1;
    }

    if (dp[n][amount] != -2) {
      return dp[n][amount];
    }

    int include = coinsChangeMemo(coins, amount - coins[n], n, dp);
    int exclude = coinsChangeMemo(coins, amount, n - 1, dp);

    // here if any one or both recursive call returns -1 means, we need to discard
    // that value, because thats not a valid denomination
    if (include == -1 && exclude == -1) {
      dp[n][amount] = -1;
    } else if (include == -1) {
      dp[n][amount] = exclude;
    } else if (exclude == -1) {
      dp[n][amount] = 1 + include;
    } else {
      dp[n][amount] = Math.min(1 + include, exclude);
    }
    return dp[n][amount];
  }
}
