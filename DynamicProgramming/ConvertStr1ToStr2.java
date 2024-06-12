package DynamicProgramming;

import java.util.Arrays;

/*
 * Edit distance (Levenshtein Distance)
 * 
 * link: https://leetcode.com/problems/edit-distance/description/
 * 
 * Solution link: https://www.youtube.com/watch?v=fJaKO8FbDdo
 */
public class ConvertStr1ToStr2 {
  /*
   * Approach:
   * 
   * while going through each charector, there could be 3 cases
   */
  public int minDistance(String word1, String word2) {
    int n1 = word1.length();
    int n2 = word2.length();

    int dp[][] = new int[n1 + 1][n2 + 1];
    for (int i = 0; i < n1; i++) {
      Arrays.fill(dp[i], -1);
    }
    return minDistanceMemo(word1, word2, n1 - 1, n2 - 1, dp);
  }

  public int minDistanceMemo(String word1, String word2, int i1, int i2, int[][] dp) {
    // if both remaining string is empty, no operations needed
    if (i1 < 0 && i2 < 0) {
      return 0;
    }

    // if 1st string becomes empty, the number of operations needed make it same is
    // size of remaining second string
    if (i1 < 0) {
      return i2 + 1;
    }
    // if 2nd string becomes empty, the number of operations needed make it same is
    // size of remaining first string
    if (i2 < 0) {
      return i1 + 1;
    }

    if (dp[i1][i2] != -1) {
      return dp[i1][i2];
    }

    // if both char is equal, 0 operation required for this, so update both i1 and i2
    if (word1.charAt(i1) == word2.charAt(i2)) {
      dp[i1][i2] = minDistanceMemo(word1, word2, i1 - 1, i2 - 1, dp);
    } else {
      // If not equal not try applying all insert, delete and replace operations
      
      // 1. for delete move only i1 pointer with one operation required
      int deletOp = 1 + minDistanceMemo(word1, word2, i1 - 1, i2, dp);

      // 2. for insert move only i2 pointer with one operation required
      int insertOp = 1 + minDistanceMemo(word1, word2, i1, i2 - 1, dp);

      // 2. for replace move both pointer with one operation required
      int replaceOp = 1 + minDistanceMemo(word1, word2, i1 - 1, i2 - 1, dp);

      dp[i1][i2] = Math.min(deletOp, Math.min(insertOp, replaceOp));
    }
    return dp[i1][i2];
  }
}
