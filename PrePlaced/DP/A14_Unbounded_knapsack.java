package DP;

import java.util.Arrays;

/*
 * Link: https://www.naukri.com/code360/problems/unbounded-knapsack_1215029
 * 
 * This is same as coin change with infinite suppy of denominations
 */
public class A14_Unbounded_knapsack {
  /*
   * Approach: 2D DP
   */
  public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    int[][] dp = new int[n+1][w+1];
    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -1);
    }
    
    return unboundedKnapsackMemo(n, w, profit, weight, 0, dp);
  }

  public static int unboundedKnapsackMemo(int n, int w, int[] profit, int[] weight, int index, int[][] dp){
    if(index >= n){
      return 0;
    }

    if(dp[index][w] != -1){
      return dp[index][w];
    }

    int includeProf = 0;
    if(w-weight[index] >= 0){
      includeProf = profit[index] + unboundedKnapsackMemo(n, w-weight[index], profit, weight, index, dp);
    }
    
    int exludeProf = unboundedKnapsackMemo(n, w, profit, weight, index+1, dp);

    dp[index][w] = Math.max(includeProf, exludeProf);
    return dp[index][w];
  }
}
