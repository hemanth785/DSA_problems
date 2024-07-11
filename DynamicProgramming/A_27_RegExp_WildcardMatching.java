package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/wildcard-matching/
 */
public class A_27_RegExp_WildcardMatching {
  /*
   * Approach: 
   * - If we come across charector other than asterics, we match one charector in both string
   * - If we come across asteric(*) in pattern, 
   *    -> we need to make 2 recursive call to check both the possibility of 
   *        - matching one char at a time 
   *        - matching empty char for that asteric
   *    -> Then we need to return true, if any one case returns true
   */
  public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();

    int dp[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return isMatchMemo(s, p, s.length() - 1, p.length() - 1, dp);
  }

  public boolean isMatchMemo(String s, String p, int i, int j, int[][] dp) {
    // base case
    if (i < 0 && j < 0) {
      return true;
    }

    //if only pattern got exhausted, we can conclude its a mismatch
    if (j < 0) {
      return false;
    }

    // if only string got exhausted,
    // -> return true - if remaining pattern contains all the asterics(*) (only asteric can match empty char or string)
    // -> return false - if remaining pattern contain any other charector
    if (i < 0) {
      for (int index = j; index >= 0; index--) {
        if (p.charAt(index) != '*') {
          return false;
        }
      }
      return true;
    }

    if (dp[i][j] != -1) {
      return dp[i][j] == 1;
    }

    char sChar = s.charAt(i);
    char pChar = p.charAt(j);

    if (sChar == pChar || pChar == '?') {
      //if both char matches or pattern include ?, we can consider both charectors mathed and decrement both pointers
      boolean result = isMatchMemo(s, p, i - 1, j - 1, dp);
      dp[i][j] = result ? 1 : 0;

    } else if (pChar == '*') {
      //if pattern char is a '*', then check for 2 possibilites.
      boolean ignoreAstericCase = isMatchMemo(s, p, i, j - 1, dp);  //1. matching asteric for empty char, so decrement pattern index only
      boolean considerAstericCase = isMatchMemo(s, p, i - 1, j, dp); //2. matching asteric for current char in string, here decrement string index only, because the same asteric we need to check for preceding charector also in the next recursive call

      boolean result = ignoreAstericCase || considerAstericCase;
      dp[i][j] = result ? 1 : 0;
    }
    return dp[i][j] == 1;
  }
}
