package DP;

import java.util.Arrays;

public class A13_MaxProfitInStockMarket_Fee {
  /*
   * Approach: 2D DP
   * - This is same as max_profit_4, only thing is that we need to deduct fee while selling stock
   */
  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int dp[][] = new int[n][2];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    return maxProfitMemo(prices, n, 0, 1, fee, dp);
  }

  public int maxProfitMemo(int[] prices, int n, int index, int isBuy, int fee, int[][] dp) {
    if (index >= n) {
      return 0;
    }

    if (dp[index][isBuy] != -1) {
      return dp[index][isBuy];
    }

    // buy is allowed
    if (isBuy == 1) {
      // buy case (adding negative because when we buy we are losing money)
      int buyCase = -prices[index] + maxProfitMemo(prices, n, index + 1, 0, fee, dp);
      int notBuyCase = maxProfitMemo(prices, n, index + 1, 1, fee, dp);

      dp[index][isBuy] = Math.max(buyCase, notBuyCase);
    } else {
      // sell case
      int sellCase = prices[index] - fee + maxProfitMemo(prices, n, index + 1, 1, fee, dp);
      int notSellCase = maxProfitMemo(prices, n, index + 1, 0, fee, dp);

      dp[index][isBuy] = Math.max(sellCase, notSellCase);
    }

    return dp[index][isBuy];
  }
}
