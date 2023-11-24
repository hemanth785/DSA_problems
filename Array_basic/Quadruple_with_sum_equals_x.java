import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * link: https://leetcode.com/problems/4sum/
 */
public class Quadruple_with_sum_equals_x {
  /*
   * Approach: Use 2 sum with 2 pointers along with the 2 outer loops
   * 
   * Time: O(n^3) 
   */
  List<List<Integer>> fourSum(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();

    int n = arr.length;
    Arrays.sort(arr);

    if (target < 0 && arr[0] > 0) {
      return result;
    }

    for (int i = 0; i < n; i++) {
      //this is to skip duplicate elements to improve performance
      if (i != 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      
      for (int j = i + 1; j < n; j++) {
        //this is to skip duplicate elements to improve performance
        if (j != i + 1 && arr[j] == arr[j - 1]) {
          continue;
        }
        int l = j + 1;
        int r = n - 1;
        while (l < r) {
          long sum = (long) arr[i] + arr[j] + arr[l] + arr[r];
          if (sum == target) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[j]);
            list.add(arr[l]);
            list.add(arr[r]);
            result.add(list);

            //this is to skip duplicate elements to improve performance
            while (l < r && arr[l] == arr[l + 1]) {
              l++;
            }
            while (l < r && arr[r] == arr[r - 1]) {
              r--;
            }
          }
          if (sum < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }
    return result;
  }
}

