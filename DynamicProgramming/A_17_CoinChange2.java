package DynamicProgramming;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/coin-change-ii/
 * 
 * Problem - find the number of ways we can form the amount using coins
 */
public class A_17_CoinChange2 {
  /*
   * Approach: 
   * - Here we are following approach of 'include' and 'exlude'
   * - One thing to keep in mind is that, since coins can be used repitatively- 
   *      so we should not decrement/increment value of index in include case
   *
   */

   int numberOfCombinations(int[] coins, int target) {
		int dp[][] = new int[target+1][coins.length+1];
		for(int i=0; i<target+1; i++){
			Arrays.fill(dp[i], -1);
		}
	  return coinChangeMemo(coins, target, coins.length-1, dp);
	}
	
	int coinChangeMemo(int coins[], int target, int index, int[][] dp){
    //valid denominations
		if(target == 0){
			return 1;
		}
    //invalid denominations
		if(target < 0 || index < 0){
			return 0;
		}
		
		if(dp[target][index] != -1){
			return dp[target][index];
		}
                                            //here we are not decrementing index because of infinite coins available
		int include = coinChangeMemo(coins, target-coins[index], index, dp);
		int exclude = coinChangeMemo(coins, target, index-1, dp);
		
    dp[target][index] = include+exclude;
		
		return dp[target][index];
	}
}
