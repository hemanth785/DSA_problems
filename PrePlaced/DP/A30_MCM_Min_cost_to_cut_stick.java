package DP;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
 */

/*
 * Aproach: DP with memoization
 * 1. For the given array of cuts, add 0 to the beginning, and stick length to the end of array 
 *    (This will help in calculating cost of cuttign stick at each stage)
 * 2. Sort the cuts array given, so that we can solve the problem recursively
 * 3. Now try start cutting from each possible position and check for the min cost using DP
 */
public class A30_MCM_Min_cost_to_cut_stick {
  public int minCost(int rodLength, int[] cuts) { //Main function
    List<Integer> cutsList = Arrays.stream(cuts).boxed().collect(Collectors.toList());
    cutsList.add(0); 
    cutsList.add(rodLength);

    int n = cutsList.size();
    int dp[][] = new int[n+1][n+1];
    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -1);
    }

    Collections.sort(cutsList);

    return minCostToCut(1, n-2, cutsList, dp);
  }

  public int minCostToCut(int l, int r, List<Integer> cuts, int[][] dp){ //Recursive function
    if(l>r){
      return 0;
    }

    if(dp[l][r] != -1){
      return dp[l][r];
    }

    int minCost = Integer.MAX_VALUE;
    for(int i=l; i<=r; i++){
      int cost = cuts.get(r+1)-cuts.get(l-1)+ //cost of current cut
                  minCostToCut(l, i-1, cuts, dp)+ // check cost for cuttign left side stick
                  minCostToCut(i+1, r, cuts, dp); // check cost for cuttign right side stick

      minCost = Math.min(cost, minCost);
    }

    dp[l][r] = minCost;
    return dp[l][r];
  }
}
