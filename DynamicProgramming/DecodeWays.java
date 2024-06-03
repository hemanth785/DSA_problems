package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://workat.tech/problem-solving/practice/decode-ways
 * 
 * * *  IMPOARTANT * * * this needs to be remembered
 */

public class DecodeWays {
  /*
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
   *  - equal to  = number of ways string (n-1) can be decoded + number of ways current charected can be decoded.
   * 
   * explanation: https://www.youtube.com/watch?v=cQX3yHS0cLo
   */

   static int mod = 1000000007;
   int numDecodings2(String str) {
		if (str.charAt(0) == '0') {
			return 0;
		}
		int n = str.length();
		int[] dp = new int[n + 1];
		
		dp[0] = 1; //this is because, we can decode string of length 0 (empty string in one way only)
		dp[1] = 1; //This is because, string of length 1 can be decoded only in one way directly
		
		for (int i = 2; i <= n; i++) {
			//for single digit
			if (str.charAt(i - 1) > '0') {
				dp[i] = dp[i - 1];
			}
			
			//for double digit (The check we are doing here is whether number in range of 1 to 26 or not)
			if (str.charAt(i - 2) == '1' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) <= '6')) {
				dp[i] = (dp[i] + dp[i - 2]) % mod;
			}
		}
		return dp[n];
	}
}