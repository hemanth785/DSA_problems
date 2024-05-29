package DynamicProgramming;
/*
 * link: https://workat.tech/problem-solving/practice/rod-cutting/
 */
public class RodCutting {
  int maximumProfit(int n, int[] prices) {
    int dp[][] = new int[n + 1][prices.length + 1];

    return maxProfitMemo(n, prices, 1, dp);
  }

  int maxProfitMemo(int n, int prices[], int length, int[][] dp) {
    if (n <= 0) {
      return 0;
    }
    if (length > prices.length || n < length) {
      return 0;
    }

    if (dp[n][length] != 0) {
      return dp[n][length];
    }

    // length is not incremented in include case, because when considering length of
    // any length k, we can have cut rods of length k multiple times (rod of length
    // 3 can be cut into piecies 1,1,1 also)
    int include = prices[length - 1] + maxProfitMemo(n - length, prices, length, dp);
    int exclude = maxProfitMemo(n, prices, length + 1, dp);

    dp[n][length] = Math.max(include, exclude);
    return dp[n][length];
  }
}
