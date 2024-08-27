package DynamicProgramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

/*
 * Note: In this problem, we need to maximize the profit by buying and selling a stock only once
 */
public class A_11_MaxProfitInStockMarket_1 {
  /*
   * Appraoch: 
   * - Keep the min value till now in variable
   * - if we come accross the value greater than min value, calculate profit if we sell, and compare it against the maxProfit
   * - If we come accross lesser value than min value, assign it to min value
   */
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int maxProfit = 0;
    int buyPrice = prices[0];

    for (int i = 1; i < prices.length; i++) {
      int cur = prices[i];
      if (cur > buyPrice) {
        int profit = cur - buyPrice;
        maxProfit = Math.max(profit, maxProfit);
      } else {
        buyPrice = cur;
      }
    }

    return maxProfit;
  }
}
