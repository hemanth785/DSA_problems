package DynamicProgramming;

import java.util.Arrays;

/*
 * 0/1 Knapsack
 * link: https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */
public class A_08_Knapsack {
  // Function to return max value that can be put in knapsack of capacity W.
  static int knapSack(int W, int wt[], int val[], int n) {
    int dp[][] = new int[n + 1][W + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return knapsackMemo(W, wt, val, n, 0, dp);
  }

  /*
   * Approach: 
   * Take or not take at each item and move on
   */
  static int knapsackMemo(int capacityWt, int wt[], int val[], int n, int curIndex, int dp[][]) {
    if (curIndex >= n || capacityWt <= 0) {
      return 0;
    }

    if (dp[curIndex][capacityWt] == -1) {
      int inclCurVal = 0;
      if (wt[curIndex] <= capacityWt) {
        inclCurVal = val[curIndex] + knapsackMemo(capacityWt - wt[curIndex], wt, val, n, curIndex + 1, dp);
      }
      int exclCurVal = knapsackMemo(capacityWt, wt, val, n, curIndex + 1, dp);
      dp[curIndex][capacityWt] = Math.max(inclCurVal, exclCurVal);
    }

    return dp[curIndex][capacityWt];
  }
}
