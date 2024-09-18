package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/regular-expression-matching/
 */
public class RegExp_RegularExpMatching {
  /*
   * NOTE: In this problem, astercis (*) mactches for following
   * - An empty char -  "" ,    * will not be at the beginning of string
   * - sequence of preceding char - If in pattern 'a*' is there, it can match a, aa, aaa...
   * - sequence of preceding char - If in pattern '.*' is there, it can match combination of charactors like 'abgkljs'
   */


  /*
   * Approach: DP
   * - start from the begining of the both the array
   * - if cur char of string and pattern match or pattern char is '.', mark the 'currentMatch' as true, else mark it as false
   * - Now check for the if the next char in pattern is *
   *    - if yes, make recursive call for below 2 cases
   *      - 1. match the * for empty char, (thus ignoring * by incrementing j+2)
   *      - 2. if currentMatch is true, then match the * for next char, (incrementing i+1)
   *      - return the result by taking OR of above 2 cases
   *    -  else,
   *      - if current match is true, recurse for next char of both string and pattern (i+1, j+1)
   */

   
  public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();

    int dp[][] = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return isMatchMemo(s, p, 0, 0, n, m, dp);
  }

  public boolean isMatchMemo(String s, String p, int i, int j, int n, int m, int[][] dp) {
    if (i >= n && j >= m) {
      return true;
    }

    // if only pattern is exhausted, return false
    if (j >= m) {
      return false;
    }

    if (dp[i][j] != -1) {
      return dp[i][j] == 1;
    }

    dp[i][j] = 0;
    // Check if the current characters match or if the pattern character is '.'
    boolean currentMatch = i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

    // If the next character in pattern is '*', handle the '*' wildcard character
    if (j + 1 < m && p.charAt(j + 1) == '*') {
      // Explore both options: matching zero occurrences for * || matching current character for *
      boolean matchZeroOccurence = isMatchMemo(s, p, i, j+2, n, m, dp);
      boolean matchCurrCharector = currentMatch && isMatchMemo(s, p, i+1, j, n, m, dp);

      dp[i][j] = matchZeroOccurence || matchCurrCharector ? 1 : 0;

    } else if (currentMatch) {
      // If the characters match, move to the next characters in both strings
      dp[i][j] = isMatchMemo(s, p, i+1, j+1, n, m, dp) ? 1 : 0;
    }

    return dp[i][j] == 1;
  }
}
