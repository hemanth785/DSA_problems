package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_20_LongestCommenSubsequencePrint {
  public static void main(String[] args) {
    Integer arr1[] = new Integer[]{3, 9, 8, 3, 9, 7, 9, 7, 0};
    Integer arr2[] = new Integer[]{3, 3, 9, 9, 9, 1, 7, 2, 0, 6};

    List<Integer> list1 = Arrays.asList(arr1);
    List<Integer> list2 = Arrays.asList(arr2);

    List<Integer> resList = longestCommonSubsequence(list1, list2);

    System.out.println(resList);
  }

  public static int maxLength = 0;
  public static String dp[][];
  
  public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    dp = new String[a.size() + 1][b.size() + 1];
    
    for (String[] row : dp) {
      Arrays.fill(row, null);
    }
    String finalMaxString = lcsMemo(a, b, 0, 0);

    List<Integer> resList = new ArrayList<>();
    for (int i = 0; i < finalMaxString.length(); i++) {
      resList.add(finalMaxString.charAt(i) - '0');
    }
    return resList;
  }

  public static String lcsMemo(List<Integer> a, List<Integer> b, int i, int j) {
    if (i >= a.size() || j >= b.size()) {
      return "";
    }
    if (dp[i][j] == null) {
      if (a.get(i) == b.get(j)) {
        dp[i][j] = a.get(i) + lcsMemo(a, b, i + 1, j + 1);

      } else {
        String leftMaxStr = lcsMemo(a, b, i + 1, j);
        String rightMaxStr = lcsMemo(a, b, i, j + 1);
        if (leftMaxStr.length() > rightMaxStr.length()) {
          dp[i][j] = leftMaxStr;
        } else {
          dp[i][j] = rightMaxStr;
        }
      }
    }
    return dp[i][j];
  } 
}
