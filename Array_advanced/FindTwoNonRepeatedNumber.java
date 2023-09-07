package Array_advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTwoNonRepeatedNumber {
  public static void main(String args[]){
    int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int res = findTwoNonRepeated(arr);
    System.out.println("Target found at index: "+res);
  }

  /*
   * Solution 1: Using sort (THis works only when other numbers repeating exactly twice)
   * 
   * Time: n log(n), Space: O(1)
   */

  public static List<Integer> twoNonRepeatingNumber1(int n, List<Integer> arr) {
    Collections.sort(arr);
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < n - 1; i = i + 2) {
      if (arr.get(i) != arr.get(i + 1)) {
        ans.add(arr.get(i));
        i = i - 1;
      }
    }
    if (ans.size() == 1) {
      ans.add(arr.get(n - 1));
    }
    return ans;
  }

  /*
   * Solution 2: Using hashmap to store the count
   * 
   * Time: O(n), Space: O(n)
   */

  public static List<Integer> twoNonRepeatingNumber2(int n, List<Integer> arr) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int item = arr.get(i);
      if (map.get(item) != null) {
        map.put(item, map.get(item) + 1);
      } else {
        map.put(item, 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        ans.add(entry.getKey());
      }
    }
    return ans;
  }
}
