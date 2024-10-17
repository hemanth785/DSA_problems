/*
 * Link: https://www.geeksforgeeks.org/problems/aggressive-cows/0
 */

import java.util.Arrays;

public class A10_Aggressive_cows {
  /*
   * Approach: Binary search
   * - We know that in worst case min distance we can keep between 2 cows is '1', so this is the value for 'low' pointer
   * - In best case, min distance we can keep between cows is, distance b/w 1st and last stall, so this value for 'high' value
   * - So using these 2 values, find a mid value and check for the feasibility of placing all the cows,
   * - If its feasible, save teh current result and check by increasign the minDistance value
   * - If its not feasible, check again by decreasing the minDistance value for each cow.
   * 
   * Time: O(n * log(n))
   */
  public static int solve(int n, int k, int[] stalls) {
    Arrays.sort(stalls);

    int l = 1;
    int r = stalls[n-1] - stalls[0];

    int minDistance = 0;
    while (l <= r) {
      int mid = (l+r)/2; // mid is the min distance expected

      boolean isPossible = checkPossibilityToPlaceCows(k, stalls, mid);

      if (isPossible) {
        minDistance = mid;
        l = mid+1;
      } else {
        r = mid-1;
      }
    }

    return minDistance;
  }

  public static boolean checkPossibilityToPlaceCows(int k, int[] stalls, int minDist) {
    int lastPos = -1;
    int cowsPlaced = 0;
    for (int i=0; i<stalls.length; i++) {
      int stallPos = stalls[i];

      if (lastPos == -1 || (stallPos-lastPos) >= minDist) {
        cowsPlaced++;
        lastPos = stallPos;
      }

      if (cowsPlaced == k) {
        return true;
      }
    }

    return false;
  }
}
