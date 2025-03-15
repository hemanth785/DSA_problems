package DP;

import java.util.Arrays;

/*
 * link: https://leetcode.com/problems/longest-common-subsequence/
 */

public class A17_LongestCommenSubsequence {
  public static void main(String[] args) {
    // int longest = longestCommonSubsequence("398397970", "3399917206");
    int longest = longestCommonSubsequenceTabulation("398397970", "3399917206");
    System.out.println(longest);
  }
  public static int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    int dp[][] = new int[n][m];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return lcsMemo(text1, n-1, text2, m-1, dp); // passing last indexes
  }

  public static int lcsMemo(String t1, int n, String t2, int m, int[][] dp) {
    if (n < 0 || m < 0) {
      return 0;
    }
    if (dp[n][m] == -1) {
      if (t1.charAt(n) == t2.charAt(m)) {
        dp[n][m] = 1 + lcsMemo(t1, n-1, t2, m-1, dp);
      } else {
        dp[n][m] = Math.max( lcsMemo(t1, n-1, t2, m, dp), lcsMemo(t1, n, t2, m-1, dp) );
      } 
    }
    return dp[n][m];
  }


  //Tabulation 
  public int longestCommonSubsequenceTab(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();

    int dp[][] = new int[n+1][m+1];

    for(int i=1; i<=n; i++){
      for(int j=1; j<=m; j++){
        if(text1.charAt(i-1) == text2.charAt(j-1)){
          dp[i][j] = 1+dp[i-1][j-1];  //1+left top diaganal value
        } else {
          dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); //max of left and top value
        }
      }
    }
    return dp[n][m];
  }
}
