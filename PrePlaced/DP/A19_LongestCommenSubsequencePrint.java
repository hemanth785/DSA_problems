package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link: https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
 */

public class A19_LongestCommenSubsequencePrint {
  /*
   * Approach: Same as A_19, but we need to track of subsequence in string format inside the DP, 
   *  instead of its length
   */
  public static void main(String[] args) {
    Integer arr1[] = new Integer[]{3, 9, 8, 3, 9, 7, 9, 7, 0};
    Integer arr2[] = new Integer[]{3, 3, 9, 9, 9, 1, 7, 2, 0, 6};

    List<Integer> list1 = Arrays.asList(arr1);
    List<Integer> list2 = Arrays.asList(arr2);

    List<Integer> resList = longestCommonSubsequence(list1, list2);

    System.out.println(resList);
  }

  public static String dp[][];
  public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    String dp[][] = new String[a.size() + 1][b.size() + 1];
    for (int i = 0; i < a.size() + 1; i++) {
      Arrays.fill(dp[i], null);
    }
    String resString = lcsMemo(a, b, 0, 0, dp);
    List<Integer> lcsList = new ArrayList<>();

    for (String str : resString.split(",")) {
      lcsList.add(Integer.parseInt(str));
    }

    return lcsList;
  }

  public static String lcsMemo(List<Integer> a, List<Integer> b, int i1, int i2, String dp[][]) {
    if (i1 >= a.size() || i2 >= b.size()) {
      return "";
    }

    if (dp[i1][i2] != null) {
      return dp[i1][i2];
    }

    String lcsStr;
    if (a.get(i1).equals(b.get(i2))) {
      lcsStr = a.get(i1) + "," + lcsMemo(a, b, i1+1, i2+1, dp); 
    } else {
      String lcsStr1 = lcsMemo(a, b, i1+1, i2, dp);
      String lcsStr2 = lcsMemo(a, b, i1, i2+1, dp);

      lcsStr = lcsStr1.length() > lcsStr2.length() ? lcsStr1 : lcsStr2;
    }

    dp[i1][i2] = lcsStr;

    return lcsStr;
  }
}

/*
 * Note: we are using ',' to separate each number is string because, when input contains number having more than one digit, we get wrong output
 *  
 * Expected output:  27 76 88 
 * actual output retured: 2 7 7 6 8 8  (when comma is not used)
 */

 /*
  * Note: Whenever we have to convert the Recursion into DP solution, 
  * make sure the temporary result is not passed in the function parameter like this: (Because memoization will not work properly for this)
  *
  *  if(exitCondition){
  *     return resSoFar; 
  *  }
  *  resString = RecFunctinCall(resSoFar + curItem)
  *
  * Instead use like this:-----
  *  if(exitCondition){
  *     return ""; 
  *  }
  *  resString  = curItem + RecFunctinCall(resSoFar + curItem);
  *
  *  Here in 2nd solution, result is not actually stored in the variable, 
  *  therefore when the nested function calls exiting, 
  *  Function at different levels recursion, the result will be diff, and thats what will be expecting
  */
