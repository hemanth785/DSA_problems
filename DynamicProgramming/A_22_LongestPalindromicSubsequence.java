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

  /*
   * Approach: More simpler code (Tabular)
   * Link: https://www.youtube.com/watch?v=WODxMJyW8Q8
   * 
   * - This approach involved 2 pointers (signifyng substring i - for start and j - for end ) and the DP matrix
   * - initially we need to mark the cells with j<i(Invalid subtring) are 0 (-In java by default all cells value will be 0)
   * - Then we have to mark, all one size string as 1 (where i==j, these are diagonal cells)
   * - Then start processing for size of substring starting from 2 to n (k)
   * - at any stage if k==2 (substring of size 2) and item at i and j are equal (such as aa or bb), fill that cell as 2 (because those are palindrome with fixed size 2)
   * - for any other k values, check if item at i and j are same
   *   - if Yes - mark that cell as 2 + dp[i+1][j-1], 2+ because we got 2 more chars which contributes to making palindrome considering the previous palindrome
   *   - If No - mark that cell as Math.max( dp[i+1][j], dp[i][j-1]) - Exploring other 2 possibilities, once exluding starting char and other exluding end char
   *     
   */

  public int longestPalindromeSubseqTab(String s) {
    int n = s.length();
    int dp[][] = new int[n+1][n+1];

    //fill value 1 for all single length string (single charactors), 
    //that will be across the diagonal in dp matrix
    for(int i=0; i<n; i++){
      dp[i][i] = 1;
    }

    //check for all the length of string, starting from k=2
    for(int k=2; k<=n; k++){
      for(int i=0; i<=n-k; i++){
        int j = i+k-1;

        if(k==2 && s.charAt(i) == s.charAt(j)){
          dp[i][j] = 2;
        }
        else if(s.charAt(i) == s.charAt(j)){
          dp[i][j] = 2 + dp[i+1][j-1];
        }
        else {
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
      }
    }

    return dp[0][n-1];
  }
}
