package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class MaxProfitInStockMarket_3 {
  /*
   * Approach 1: Using dynamic problem approach
   * link: https://www.youtube.com/watch?v=-uQGzhYj8BQ
   */

  public int maxProfitDP(int[] prices) {
    int n = prices.length;
    int dp[][][] = new int[n][2][3];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    return maxProfitMemo(prices, n, 0, 1, 2, dp);
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



  /*
    * Approach 2: Most efficient in terms of Time complexity
    * - find the leftMaxProfit and rightMaxProfit for each element
    * leftMaxProfit - maximum profit we can make considering prices from 0th index to current index, for each iterm (make profit by buying and selling once)
    * rightMaxProfit - maximum profit we can make considering prices from last index to current index, for each item (make profit by buying and selling once)
  */

  /*
    * NOTE: this approach only works, when maximum 2 transaction is allowed.
    * Time: O(n), Space: O(n)
  */


  public int maxProfit(int[] prices) {
    int n = prices.length;
    int leftMaxProfArr[] = new int[n];
    int rightMaxProfArr[] = new int[n];

    int leftMin = prices[0]; //this is to simulate buy price
    for(int i=1; i<n; i++){
        leftMin = Math.min(leftMin, prices[i]);
        leftMaxProfArr[i] = Math.max(leftMaxProfArr[i-1], prices[i]-leftMin); //check can we make more profit by selling at curent price, or else keep last profit as max profit
    }

    int rightMax = prices[n-1]; //this is to simulate sell price
    for(int i=n-2; i>=0; i--){
        rightMax = Math.max(rightMax, prices[i]);
        rightMaxProfArr[i] = Math.max(rightMaxProfArr[i+1], rightMax - prices[i]); //check can we make more profit by buying at curent price, or else keep last profit as max profit
    }

    int maxProfit = 0;
    for(int i=0; i<n; i++){
        maxProfit = Math.max(maxProfit, leftMaxProfArr[i]+rightMaxProfArr[i]);
    }

    return maxProfit;
  }
}
