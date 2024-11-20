package DP;

import java.util.Arrays;

/*
 * Link: https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954
 */
public class A01_Subset_sum_equals_x {
  public static boolean subsetSumToK(int n, int k, int arr[]){
		int dp[] = new int[k+1];
		Arrays.fill(dp, -1);
      return subsetSumRecursive(arr, 0, k, dp);
  }

  public static boolean subsetSumRecursive(int[] A, int index, int target, int dp[]){
		if(target == 0){
			return true;
		}
        
    if(index >= A.length || target < 0){
			return false;
		}

		if(dp[target] != -1){
			return dp[target] == 1;
		}
		
		//including current element
		boolean include = subsetSumRecursive(A, index+1, target-A[index], dp);
		if(include){
			dp[target] = 1;
			return true;
		}
			
	    //excluding current element
		boolean exclude = subsetSumRecursive(A, index+1, target, dp);
		dp[target] = exclude ? 1 : 0;
		return exclude;
	}
}
