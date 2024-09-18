package DynamicProgramming;

import java.util.Arrays;

public class A_14_MaxProfitInStockMarket_CoolDown_4 {
  /*
   * Approach: 
   * - Same as prev problem, instead of max transactions, new condition of coolDown has given
   */
  
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][][] = new int[n + 1][2][2];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    return maxProfitMemo(prices, false, false, 0, dp);
  }

  public int maxProfitMemo(int[] prices, boolean isBought, boolean coolDownPeriod, int index, int[][][] dp) {
    if (index >= prices.length) {
      return 0;
    }

    int buyIndex = isBought ? 1 : 0;
    int coolIndex = coolDownPeriod ? 1 : 0;

    if (dp[index][buyIndex][coolIndex] != -1) {
      return dp[index][buyIndex][coolIndex];
    }

    // buy case
    if (!isBought) {
      int buyCase = 0;
      if (!coolDownPeriod) {
        buyCase = -prices[index] + maxProfitMemo(prices, true, false, index + 1, dp);
      }
      int notBuyCase = maxProfitMemo(prices, false, false, index + 1, dp);

      dp[index][buyIndex][coolIndex] = Math.max(buyCase, notBuyCase);

    } else {
      int sellCase = prices[index] + maxProfitMemo(prices, false, true, index + 1, dp);
      int notSellCase = maxProfitMemo(prices, true, false, index + 1, dp);

      dp[index][buyIndex][coolIndex] = Math.max(sellCase, notSellCase);
    }
    return dp[index][buyIndex][coolIndex];
  }
}
