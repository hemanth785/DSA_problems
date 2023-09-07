package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
 */
public class Celebrity {
  
  /* Approach1: Bruteforce: 
   * Run a loop where ‘i’ ranges from 0 to ‘N’ - 1, and check whether the person having id ‘i’ is a celebrity or not. This can be done as follow -:
      - Initialise two boolean variables, ‘KNOWANY’ and ‘KNOWNTOALL’.
      - Run a loop where ‘j’ ranges from 0 to ‘N’ - 1. If ‘knows(i, j)’ returns false for all ‘j’,  then set ‘KNOWANY’:= false
      - Run a loop where ‘j’ ranges from 0 to ‘N’ - 1 and if  ‘knows(j, i)’ return true for all ‘j’ except when ‘j’ = ‘i’, then set  ‘KNOWNTOALL’:= true
      If ‘KNOWANY’ is ‘false’ and ‘KNOWNTOALL’ is ‘true’, then assign ‘CELEBRITY’:= ‘i’ and break the loop.
 
      Return ‘CELEBRITY’.
   * Time: O(n^2), Space: O(1)
  */

  int findCelebrityBruteforce(int M[][], int n) {
    int celebrity = -1;
    for (int p = 0; p < n; p++) {
      boolean knowAny = false;
      boolean knownToAll = true;

      for (int j = 0; j < n; j++) {
        if (p != j) {
          if (M[p][j] == 1) {
            knowAny = true;
            break;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        if (p != i) {
          if (M[i][p] == 0) {
            knownToAll = false;
            break;
          }
        }
      }

      if (knowAny == false && knownToAll == true) {
        celebrity = p;
        break;
      }
    }
    return celebrity;
  }


  /*
   * Approach 2: Using hashmap
   * 
   * Steps-
   * 1. Store the count of how many people know each person
   * 2. Then loop over map to check if any persion has known to n-1 people
   *    - If yes, then verify if this persion dont know any other persion than himself (Complete row for that persion should be zero)
   *      - If yes, Return the celebirty
   * else 
   *   No celebrity found
   * 
   * Time: O(n^2)
   * 
   */

  int findCelebrityUsingMap(int M[][], int n) {
    int celebrity = -1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (i != j && M[i][j] == 1) {
          if (map.get(j) == null) {
            map.put(j, 1);
          } else {
            map.put(j, map.get(j) + 1);
          }
        }

      }
    }

    // System.out.println(map);

    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
      int p = pair.getKey();
      int count = pair.getValue();

      if (count == n - 1) {
        boolean knowAny = false;
        for (int j = 0; j < n; j++) {
          if (j != p && M[p][j] == 1) {
            knowAny = true;
            break;
          }
        }
        if (!knowAny) {
          celebrity = p;
          break;
        }
      }

    }

    return celebrity;
  }

  /*
   * Approach 3: Optimized approach
   * 
   * - Store all persions in the stack
   * - Pop 2 people from stack at a time and check, until 1 or 0 element left in stack
   *  - if a knows b and b dont know a, then b could be celebrity
   *  - if b knows a and a dont know b, then a could be celebrity
   * 
   * -If any element left in stack, verify that is the celebrity by
   *  - check if he knows to everyone
   *  - check if he dont know anybody else
   */
  int findCelebrityStack(int M[][], int n)
  {
    Stack<Integer> stack = new Stack<Integer>();

    // push everyone to stack
    for (int i = 0; i < n; i++) {
      stack.push(i);
    }

    // pop every 2 persion and compare until, one or zero elements left
    while (stack.size() >= 2) {
      int first = stack.pop();
      int second = stack.pop();

      // if first knows second and second dosn't know first, second could be celebrity
      if (M[first][second] == 1 && M[second][first] == 0) {
        stack.push(second);
        continue;
      }

      // if second knows first and first dosn't know second, first could be celebrity
      if (M[second][first] == 1 && M[first][second] == 0) {
        stack.push(first);
      }
    }

    if (stack.size() == 1) {
      // verify left person in the stack is celebrity
      int person = stack.pop();

      // check if person known to everyone
      for (int row = 0; row < n; row++) {
        if (person != row && M[row][person] == 0) {
          return -1;
        }
      }

      // check if person dont know anybody
      for (int col = 0; col < n; col++) {
        if (person != col && M[person][col] == 1) {
          return -1;
        }
      }
      return person;
    }
    return -1;

  }
}
