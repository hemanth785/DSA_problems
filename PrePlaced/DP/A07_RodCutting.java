package DP;
/*
 * link: https://workat.tech/problem-solving/practice/rod-cutting/
 * link: https://www.naukri.com/code360/problems/rod-cutting-problem_800284
 * 
 * Note: Greedy approach will not work here (Tested and not working)
 */
public class A07_RodCutting {
  int maximumProfit(int n, int[] prices) {
    int dp[][] = new int[n + 1][prices.length + 1];

    return maxProfitMemo(n, prices, 1, dp);
  }

  int maxProfitMemo(int rodLength, int prices[], int peiceLength, int[][] dp) {
    if (rodLength <= 0) {
      return 0;
    }
    if (peiceLength > rodLength) {
      return 0;
    }

    if (dp[rodLength][peiceLength] != 0) {
      return dp[rodLength][peiceLength];
    }

    // length is not incremented in include case, because when considering length of
    // any length k, we can have cut rods of length k multiple times (rod of length
    // 3 can be cut into piecies 1,1,1 also)
    int price = prices[peiceLength - 1];
    int include = price + maxProfitMemo(rodLength - peiceLength, prices, peiceLength, dp);
    int exclude = maxProfitMemo(rodLength, prices, peiceLength + 1, dp);

    dp[rodLength][peiceLength] = Math.max(include, exclude);
    return dp[rodLength][peiceLength];
  }
  
}
