package DP;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/shortest-common-supersequence/
 */

public class A28_Shortest_common_supersequence {
  /*
   * Approach: Using LCS and DP
   * - First find the longest commen subsequence
   * - then loop through str1, str2 and lcs by following below conditions
   * - here l points to str1 chars, r points to str2 chars and k points to commen chars between then
   * - initially make l, r, k as '0'
   * - move l until char at l matches with 1st char of lcs, while adding these chars to result string
   * - move r until char at l matches with 1st char of lcs, while adding these chars to result string
   * - once both l and r matches to char in lcs, append that char to result string and update all the pointers
   * - If at any point, k exausts. add teh remaining chars from str1 and str2 to result list and return it
   * 
   * Time: O(n+m), Space: O(n*m)
   */
  public String shortestCommonSupersequence(String str1, String str2) {
    String lcs = longestCommonSubsequence(str1, str2);

    int l = 0;
    int r = 0;
    int k = 0;

    String scs = "";
    while(l < str1.length() || r < str2.length()){
      if(k >= lcs.length()){

        if(l<str1.length()){
          scs += str1.substring(l);
        }
        if(r < str2.length()){
          scs += str2.substring(r);
        }
        break;
      }

      while(l < str1.length() && (k>=lcs.length() || str1.charAt(l) != lcs.charAt(k))){
        scs += str1.charAt(l);
        l++;
      }
      while(r < str2.length() && (k>=lcs.length() || str2.charAt(r) != lcs.charAt(k))){
        scs += str2.charAt(r);
        r++;
      }
      scs += lcs.charAt(k);
      l++;
      r++;
      k++;
    }

    return scs;
  }

  public static String longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    String dp[][] = new String[n+1][m+1];

    for (String row[] : dp) {
      Arrays.fill(row, null);
    }
    return lcsMemo(text1, 0, text2, 0, dp); // passing last indexes
  }

  public static String lcsMemo(String t1, int n, String t2, int m, String[][] dp) {
    if (n >= t1.length() || m >= t2.length()) {
      return "";
    }

    if(dp[n][m] != null){
      return dp[n][m];
    }

    String lcsStr;
    if (t1.charAt(n) == t2.charAt(m)) {
      lcsStr = t1.charAt(n) + lcsMemo(t1, n+1, t2, m+1, dp);
    } else {
      String lcsStr1 = lcsMemo(t1, n+1, t2, m, dp);
      String lcsStr2 = lcsMemo(t1, n, t2, m+1, dp);

      lcsStr = lcsStr1.length() > lcsStr2.length() ? lcsStr1 : lcsStr2;
    } 

    dp[n][m] = lcsStr;
    return dp[n][m];
  }  
}
