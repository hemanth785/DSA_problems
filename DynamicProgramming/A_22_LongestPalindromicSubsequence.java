package DynamicProgramming;

import java.util.Arrays;

public class A_22_LongestPalindromicSubsequence {
  /*
   * Aproach: Trick
   * - What we can do is that, we can create a new string by reversing the given string
   * - Then find the longest commen subsequence between those strings 
   *      (because palindrome is the string if read it from front or back it'll be same)
   * - This longest commen subsequence is actually the longest palindromic string
   */
  public int longestPalindromeSubseq(String s) {
    // create another string which is reversal of given string
    String reversedStr = reverseString(s);
    int n = s.length();
    int dp[][] = new int[n][n];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    int longestPalindromicSubsuquence = longestCommenSubsequence(s, reversedStr, n - 1, n - 1, dp);

    return longestPalindromicSubsuquence;
  }

  public static int longestCommenSubsequence(String t1, String t2, int n, int m, int[][] dp) {
    if (n < 0 || m < 0) {
      return 0;
    }
    if (dp[n][m] == -1) {
      if (t1.charAt(n) == t2.charAt(m)) {
        dp[n][m] = 1 + longestCommenSubsequence(t1, t2, n - 1, m - 1, dp);
      } else {
        dp[n][m] = Math.max(
            longestCommenSubsequence(t1, t2, n - 1, m, dp),
            longestCommenSubsequence(t1, t2, n, m - 1, dp));
      }
    }
    return dp[n][m];
  }

  public String reverseString(String str) {
    String revString = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      revString += str.charAt(i);
    }

    return revString;
  }
}
