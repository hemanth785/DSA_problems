package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/burst-balloons/
 */

/*
 * Approach: Using DP and memoization
 * 1. If we start calculating coins while bursting ballons, from top to bottom, we cannot solve problem for partitions independanlty
 * 2. Rather start calculation coins for last bursting(bottom most) ballon, and keep counting the coins, while moving upwards
 *   This way we can solve the problem via partitioning into subproblems
 * 
 * Solution link: https://www.youtube.com/watch?v=Yz4LlDSlkns
 */
public class A31_Burst_ballons {
  public int maxCoins(int[] nums) {
    int n = nums.length;

    int dp[][] = new int[n+1][n+1];
    for(int i=0; i<=n; i++){
      Arrays.fill(dp[i], -1);
    }

    List<Integer> ballons = new ArrayList<>();
    ballons.add(1); //add 1 to the leftmost
    for(int i=0; i<n; i++){
      ballons.add(nums[i]);
    }
    ballons.add(1); //add 1 to the rightmost

    return maxCoinsDP(ballons, 1, ballons.size()-2, dp);
  }

  public int maxCoinsDP(List<Integer> ballons, int l, int r, int dp[][]){
    if(l>r){
      return 0;
    }

    if(dp[l][r] != -1){
      return dp[l][r];
    }

    int maxCoins = 0;
    for(int i=l; i<=r; i++){
      int coins = (ballons.get(l-1) * ballons.get(i) * ballons.get(r+1))+
                  maxCoinsDP(ballons, l, i-1, dp)+
                  maxCoinsDP(ballons, i+1, r, dp);

      maxCoins = Math.max(maxCoins, coins);
    }

    dp[l][r] = maxCoins;
    return dp[l][r];
  }
}
