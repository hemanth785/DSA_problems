package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://workat.tech/problem-solving/practice/decode-ways
 * 
 * * *  IMPOARTANT * * * this needs to be remembered
 */

public class DecodeWays {
  /*
   * Directly go for 2nd solution 
   * Working solution (Not efficient), but its using O(n^2) space for memoization
   */
  
  int numDecodings(String str) {
    int n = str.length();
    int dp[][] = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return numDecodingsMemo(str, n, -1, -1, dp);
  }

  int numDecodingsMemo(String str, int n, int l, int r, int dp[][]) {
    if (r >= n) {
      return 0;
    }

    if (l != -1 && r != -1) {
      if (dp[l][r] != -1) {
        return dp[l][r];
      }
      String subStr = str.substring(l, r + 1);
      int number = Integer.parseInt(subStr);

      if (number > 26 || number < 1 || (number < 10 && subStr.length() > 1)) {
        return 0;
      }
      if (r == n - 1) {
        return 1;
      }
    }

    int singleDigit = numDecodingsMemo(str, n, r + 1, r + 1, dp);
    int doubleDigit = numDecodingsMemo(str, n, r + 1, r + 2, dp);

    if (l == -1 || r == -1) {
      return singleDigit + doubleDigit;
    }
    dp[l][r] = singleDigit + doubleDigit;
    return dp[l][r];
  }

  /*
   * Optimized solution: Bottom up approach
   * 
   * Approach: number of ways in which the string of size 'N' can be decoded is
   *  - equal to  = number of ways string (n-1) can be decoded + number of ways current charector can be decoded.
   * 
   * explanation: https://www.youtube.com/watch?v=cQX3yHS0cLo
   */

   static int mod = 1000000007;
   int numDecodings2(String str) {
		int n = str.length();
		int[] dp = new int[n + 1];
		
		dp[0] = 1; //this is because, we can decode string of length 0 (empty string in one way only)
		dp[1] = str.charAt(0) == '0' ? 0 : 1; //This is because, string of length 1 can be decoded only in one way directly
		
		for (int i = 2; i <= n; i++) {
			//for single digit
			int oneDigit = Integer.valueOf(str.substring(i-1, i));
      int twoDigit = Integer.valueOf(str.substring(i-2, i));

      //consider one digit
      if(oneDigit >= 1){
        dp[i] = dp[i-1];
      }

      //consider 2 digit
      if(twoDigit >= 10 && twoDigit <=26){
        dp[i] = dp[i] + dp[i-2];
      }
			
		}
		return dp[n];
	}
}
