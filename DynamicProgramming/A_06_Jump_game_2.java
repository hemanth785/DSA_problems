package DynamicProgramming;

import java.util.Arrays;

/*
 * Link: https://leetcode.com/problems/jump-game-ii/
 * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/jump-game-ii-1
 */
public class A_06_Jump_game_2 {
  /*
   * Approach: Its actually a DP problem
   * - Starting form first index(0), check for all the jumps possible
   * - then get the min jump count we get from recursive calls, from a particular position
   */
  public int jump(int[] arr) {
    int n = arr.length;
    if (n == 1) {
      return 0;
    }

    if (arr[0] == 0) {
      return -1;
    }

    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);

    int minJumps = jump_rec(arr, n, 0, dp);

    return minJumps == Integer.MAX_VALUE ? -1 : minJumps;

  }

  public static int jump_rec(int[] arr, int n, int index, int dp[]) {
    if (index >= n - 1) {
      return 0;
    }

    if (dp[index] != -1) {
      return dp[index];
    }

    int maxJumpLengthFromThisStep = arr[index];
    int minJumps = Integer.MAX_VALUE;

    for (int i = 1; i <= maxJumpLengthFromThisStep; i++) {
      int jumpCount = jump_rec(arr, n, index + i, dp);
      minJumps = Math.min(minJumps, jumpCount);
    }

    dp[index] = (minJumps == Integer.MAX_VALUE ? minJumps : minJumps + 1);
    return dp[index];
  }
}
