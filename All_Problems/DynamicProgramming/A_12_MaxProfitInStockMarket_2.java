package DynamicProgramming;

/*
 * link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class A_12_MaxProfitInStockMarket_2 {
  /*
   * Time: O(n)
   * 
   * Approach: 
   * - buy whenever low price found than prev buy
   * - Sell wherever we find peak point (prev < cur < next) and add it to profit
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
	  int totalProfit = 0;
		int prevBuy = Integer.MAX_VALUE;
		
		for(int i=0; i<n-1; i++){
			int curPrice = prices[i];
			
			//buy here
			if(curPrice < prevBuy){
				prevBuy = curPrice;
				continue;
			}
			
			//sell if we find peak point scenario
			if(curPrice >= prices[i-1] && curPrice > prices[i+1]){
				totalProfit += curPrice - prevBuy;
				prevBuy = Integer.MAX_VALUE;
			} 
		}
		
		//sell the stock if it is unsold and price on last day is more than buy
		if(prevBuy != Integer.MAX_VALUE && prevBuy < prices[n-1]){
			totalProfit +=  prices[n-1] - prevBuy;
		}
		
		return totalProfit;
  }
}
