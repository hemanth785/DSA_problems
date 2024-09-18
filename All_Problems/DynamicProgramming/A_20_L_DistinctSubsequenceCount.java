package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/distinct-subsequences
 */
public class A_20_L_DistinctSubsequenceCount {
  public int numDistinct(String s, String t) {
    int dp[][] = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      Arrays.fill(dp[i], -1);
    }
    return numDistinctMemo(s, t, 0, 0, dp);
  }

  public int numDistinctMemo(String s, String t, int i, int j, int[][] dp) {
    if (i == s.length() && j == t.length()) {
      return 1;
    }
    if (j >= t.length()) {
      return 1;
    }
    if (i >= s.length()) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int sChar = s.charAt(i);
    int tChar = t.charAt(j);

    int include = 0;
    if (sChar == tChar) {
      include = numDistinctMemo(s, t, i + 1, j + 1, dp);
    }

    int exclude = numDistinctMemo(s, t, i + 1, j, dp);

    dp[i][j] = include + exclude;
    return dp[i][j];
  }
}
