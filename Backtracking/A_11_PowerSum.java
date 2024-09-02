package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://www.hackerrank.com/challenges/the-power-sum/problem
 */
public class A_11_PowerSum {
  /*
   * Approach: Using backtracking
   * - First find all the power numbers between 1 ang X (target)
   * - Now run backtracking algorithm, to find all the power numbers which add up to the target sum X
   */

  public static int powerSum(int X, int N) {
    List<Integer> powerNumbers = new ArrayList<Integer>();
    int num = 1;
    int powerNum = 0;
    while (powerNum <= X) {
      // System.out.println(num);
      powerNum = (int) Math.pow(num, N);
      if (powerNum <= X) {
        powerNumbers.add(powerNum);
      }
      num++;
    }
    System.out.println(powerNumbers);

    List<List<Integer>> combinationSet = new ArrayList<>();
    List<Integer> tempSet = new ArrayList<Integer>();
    findPowerNumberEqualsTarget(X, powerNumbers, 0, combinationSet, tempSet);

    return combinationSet.size();
  }

  public static void findPowerNumberEqualsTarget(int X, List<Integer> powerNumbers, int currentIndex,
      List<List<Integer>> combinationSet, List<Integer> resultSet) {

    if (X == 0) {
      List<Integer> tempSet = new ArrayList<Integer>(resultSet);
      System.out.println(tempSet);

      combinationSet.add(tempSet);
      return;
    }
    if (X < 0 || currentIndex >= powerNumbers.size()) {
      return;
    }

    int currentNumber = powerNumbers.get(currentIndex);

    resultSet.add(currentNumber);
    findPowerNumberEqualsTarget(X - currentNumber, powerNumbers, currentIndex + 1, combinationSet, resultSet);
    resultSet.remove(resultSet.size() - 1);

    findPowerNumberEqualsTarget(X, powerNumbers, currentIndex + 1, combinationSet, resultSet);
  }
}
