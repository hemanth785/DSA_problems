package Backtracking;

import java.util.List;

/*
 * Link: https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 */
public class A_12_Nearest_Knapsack {
  /*
   * Approach: Solution is similar to previous problem (Combination sum using same item)
   */
  public static int unboundedKnapsack(int k, List<Integer> arr) {
    return coinChangeMemo(arr, k, 0, 0, 0);
  }

  static int coinChangeMemo(List<Integer> arr, int target, int sumSoFar, int index, int prevSum) {
    
    // valid combinations
    if (sumSoFar == target) {
      return target;
    }

    // invalid combinations
    if (sumSoFar > target || index >= arr.size()) {
      return prevSum;
    }

    // here we are not decrementing index because of infinite coins available
    int include = coinChangeMemo(arr, target, sumSoFar + arr.get(index), index, sumSoFar);
    if (include == target) {
      return target;
    }

    int exclude = coinChangeMemo(arr, target, sumSoFar, index + 1, prevSum);
    if (exclude == target) {
      return target;
    }

    return include > exclude ? include : exclude;
  }
}
