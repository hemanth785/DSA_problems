package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/coin-change-ii/
 * 
 * Problem - find the number of ways we can form the amount using coins
 */
public class CoinChange2 {
  /*
   * Approach: 
   * - Here we have to find the number different ways in which we can form the amount
   * - We cannot use and modify the coin change 1 code because, here we can use same coin multiple times and 
   *    there is possibility we consider the same conmbinatin again. for ex: 1112 and 1211, these 2 are same only
   * - So one approach we can use is, 
   *   - start with one coin and call recursive function for using this coin until (1*coin1, 2*coin1...n*coin1) until total amount is less than target amount is given
   *   - for each of these possible amount, then call recursive function for next coin (1*coin2, 2*coin2... n*coin2)
   * 
   *  - in recursive stack if any moment amount becomes 0, return 1
   *
   */

  public int change(int amount, int[] coins) {
    int n = coins.length;
    int dp[][] = new int[n][amount + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return coinsChangeMemo(coins, amount, n - 1, dp);
  }

  public int coinsChangeMemo(int[] coins, int amount, int index, int[][] dp) {
    if (amount == 0) {
      return 1;
    }

    if (index < 0) {
      return 0;
    }

    if (dp[index][amount] != -1) {
      return dp[index][amount];
    }
    int ways = 0;
    // initial coinAmount is 0, because we have to consider the case of excluding the current coin
    for (int coinAmount = 0; coinAmount <= amount; coinAmount += coins[index]) {
      ways += coinsChangeMemo(coins, amount - coinAmount, index - 1, dp);
    }
    dp[index][amount] = ways;
    return dp[index][amount];
  }
}
