package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://workat.tech/problem-solving/practice/palindromic-partitioning-2/
 */
public class PalindromePartitioning_2 {
  /*
   * Approach:
   */

  int getMinCuts(String str) {
    int n = str.length();
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return minCutsMemo(str, 0, n, dp);
  }

  int minCutsMemo(String str, int l, int n, int dp[]) {
    if (l >= n) {
      return 0;
    }

    if (dp[l] != -1) {
      return dp[l];
    }

    // if complete string is palindrome, no partition required
    if (isPalindrome(str.substring(l, n))) {
      dp[l] = 0;
    } else {
      int minPartition = n - 1; // this is the max partitions we can get, if partitioned at each charector

      // check for each length of the string starting from l,
      // - if it is palindrome, increase partition count and check for palindromes in rest of string
      // - calculate min partitions among all these possibilities
      for (int i = l; i < n; i++) {
        String subStr = str.substring(l, i + 1);
        if (isPalindrome(subStr)) {
          int partitions = 1 + minCutsMemo(str, i + 1, n, dp);
          minPartition = Math.min(minPartition, partitions);
        }
      }

      dp[l] = minPartition;
    }

    return dp[l];
  }

  boolean isPalindrome(String substring) {
    int n = substring.length();
    if (n == 1) {
      return true;
    }
    for (int i = 0; i < n; i++) {
      if (substring.charAt(i) != substring.charAt(n - i - 1)) {
        return false;
      }
    }

    return true;
  }
}
