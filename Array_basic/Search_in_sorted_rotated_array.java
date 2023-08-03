import java.util.Arrays;

public class Search_in_sorted_rotated_array {
  public static void main(String[] args) {
    int arr[] = {4,6,7,8,11,13, 1, 2};

    // int res = solution2(arr, arr.length);

    System.out.println("Rotated arry: "+ Arrays.toString(res));
  }

  /*
   * Solution 1: Linear search
   * 
   * apply lenear search
   * 
   * Time: O(n),
   */

  /*
   * Solution 2: Binary search
   * - Find the pivot ( arr[i-1] < arr[i] > arr[i+1])
   * - check search element is greater than 1st element,
   *      -then search in the left side of pivot
   *   else
   *      - search in the right side of pivot
   * 
   * Time: O(log(n)),
   */
}

