package Graph;

import java.util.ArrayList;
import java.util.List;

public class A_15_SteppingNumbers {
  /*
   * Link: https://workat.tech/problem-solving/practice/stepping-numbers
   */

  /*
   * Solution: 
   */

  List<Integer> getSteppingNumbers(int begin, int end) {
    List<Integer> result = new ArrayList<>();

    // start with single digit number(cur) and then keep on adding cur+1 and cur-1 as digit to existing number
    for (int i = 1; i <= 9; i++) {
      findPossibilities(result, begin, end, i);
    }

    return result;
  }

  void findPossibilities(List<Integer> result, int begin, int end, int cur) {
    //if number is within boundary, we add it to our list
    if (cur >= begin && cur <= end) {
      result.add(cur);

    // if number is negative or greater than max, return
    } else if (cur > end || cur < 0) {
      return;
    }

    // Note: Here we are not checking for cur<begin,
    // because, if number is less than begin, there is a possibility after adding another digit to it, it can become valid number
    // Therefore, if number is lesser than given range, we don't add it to list, but we continue exploring further numbers formed with it.

    if (cur % 10 != 9) {
      findPossibilities(result, begin, end, (cur * 10) + (cur % 10 + 1));
    }
    if (cur % 10 != 0) {
      findPossibilities(result, begin, end, (cur * 10) + (cur % 10 - 1));
    }
  }
}
