package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
  public int rob(int[] nums) {
    int n = nums.length;
    if(n == 1){
        return nums[0];
    }
    int dp[] = new int[n+1];
    Arrays.fill(dp, -1);

    //robbing starting from 1st house to (n-1)th house
    int first = robCirularHouseDp(nums, n-1, dp, 0);

    Arrays.fill(dp, -1);
    //robbing starting from 2nd house to nth house
    int second = robCirularHouseDp(nums, n, dp, 1);

    return Math.max(first, second);
}

public int robCirularHouseDp(int[] nums, int n, int[] dp, int curIndex){
    if(curIndex >= n){
        return 0;
    }
    if(dp[curIndex] == -1){
        //if you are robing current house, then option is house after the next house
        int profit1 = nums[curIndex] + robCirularHouseDp(nums, n, dp, curIndex+2);

        //this is skipping current house, and starting from next house
        int profit2 = robCirularHouseDp(nums, n, dp, curIndex+1);
        dp[curIndex] = Math.max(profit1, profit2);
    }
    return dp[curIndex];
}
}
