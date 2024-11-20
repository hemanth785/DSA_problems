package DP;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class A11_MaxProfitInStockMarket_4 {
  /*
   * Approach: 
   * This is same as 'MaxProfitInStockMarket_3', instead of 2 transactions, k transactions will be allowed
   * - DP Solution remains almost same only
   */

  int maxProfit(int[] prices, int k) {
    int n = prices.length;
    int dp[][][] = new int[n][2][k + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    return maxProfitMemo(prices, n, 0, 1, k, dp);
  }

  public int maxProfitMemo(int[] prices, int n, int index, int isBuy, int maxTransactionAllowed, int[][][] dp) {
    if (index >= n) {
      return 0;
    }
    if (maxTransactionAllowed == 0) {
      return 0;
    }

    if (dp[index][isBuy][maxTransactionAllowed] != -1) {
      return dp[index][isBuy][maxTransactionAllowed];
    }

    // buy is allowed
    if (isBuy == 1) {
      // buy case (adding negative because when we buy we are losing money)
      int buyCase = -prices[index] + maxProfitMemo(prices, n, index + 1, 0, maxTransactionAllowed, dp);
      int notBuyCase = maxProfitMemo(prices, n, index + 1, 1, maxTransactionAllowed, dp);

      dp[index][isBuy][maxTransactionAllowed] = Math.max(buyCase, notBuyCase);
    } else {
      // sell case
      int sellCase = prices[index] + maxProfitMemo(prices, n, index + 1, 1, maxTransactionAllowed - 1, dp);
      int notSellCase = maxProfitMemo(prices, n, index + 1, 0, maxTransactionAllowed, dp);

      dp[index][isBuy][maxTransactionAllowed] = Math.max(sellCase, notSellCase);
    }

    return dp[index][isBuy][maxTransactionAllowed];
  }
}
