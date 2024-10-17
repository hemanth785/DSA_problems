/*
 * Link: https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
 */
public class A11_Painters_partition_problem {
  /*
   * Approach: Usuing binary search
   *  - Approach is same as Allocate_min_pages problem
   */
  static long minTime(int[] arr, int n, int k) {
    int maxLengthBoard = 0;
    int sumLengthOfAllBoard = 0;

    for (int i=0; i<n; i++) {
      maxLengthBoard = Math.max(maxLengthBoard, arr[i]);
      sumLengthOfAllBoard += arr[i];
    }

    int l = maxLengthBoard;
    int r = sumLengthOfAllBoard;

    int minTimeRequired = 0;
    while (l <= r) {
      int mid = (l+r) / 2; // here mid represents the maxTime can be taken by each painter

      boolean isFeasible = isPossibleToComplete(arr, k, mid);

      if (isFeasible) {
        minTimeRequired = mid;
        r = mid-1;
      } else {
        l = mid+1;
      }
    }

    return minTimeRequired;
  }

  static boolean isPossibleToComplete(int[] arr, int k, int maxTimeAllowed) {
    int painter = 1;
    int timeConsumed = 0;
    for (int i = 0; i < arr.length; i++) {
      int curBoardLenTime = arr[i];

      if ((timeConsumed + curBoardLenTime) <= maxTimeAllowed) {
        timeConsumed += curBoardLenTime;
      } else {
        timeConsumed = curBoardLenTime;
        painter++;
      }

      if (painter > k) {
        return false;
      }
    }
    return true;
  }
}
