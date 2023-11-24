package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/game-of-two-stacks/problem
 */
public class GameOfTwoStacks {

  public static void main(String[] args) {
    Integer arr1[] = {1, 2, 3, 4, 5};
    Integer arr2[] = {6, 7,8, 9};

    List<Integer> list1 = Arrays.asList(arr1);
    List<Integer> list2 = Arrays.asList(arr2);

    int maxScore = twoStacks(7, list1, list2);
    System.out.println("Two stacks max score: "+ maxScore);
  }

  public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    int sum = 0;
    int score1 = 0;
    int score2 = 0;

    //find score for 1st stack
    for (int i = 0; i < a.size(); i++) {
      int item = a.get(i);
      if ((sum + item) > maxSum) {
        break;
      }
      sum += item;
      score1++;
    }
    int maxScore = score1;

    //find score while including the 2nd stack
    for (int i = 0; i < b.size(); i++) {
      int item = b.get(i);
      sum += item;
      score2++;

      while (sum > maxSum && score1 > 0) {
        sum = sum - a.get(score1 - 1);
        score1--;
      }
      if (sum <= maxSum) {
        maxScore = Math.max(score1 + score2, maxScore);
      }
    }

    return maxScore;
  }
}
