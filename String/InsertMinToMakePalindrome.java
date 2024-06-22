package String;

import java.util.Arrays;

public class InsertMinToMakePalindrome {
  /*
   * Approach:
   * - we can identify the min chars to insert to make a string palindrome is that
   * - First identify the Longest palindromic sub sequence(Refere DP section: LongestPalindromicSubsequence.java)
   * - Once we find the length of longest palindromic in the string, then we have to insert the remaining chars in respective positions
   * 
   * i.e: minInsertionToMakePalidrome = (size of given string) - (longest palinromic subsequence length)
   */
  int minCharactersToBeInserted(String s) {
    int lcs = longestPalindromeSubseq(s);

    return s.length() - lcs;
  }

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
