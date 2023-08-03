import java.util.Arrays;


public class Triplet_with_sum_equuals_x {
   public static void main(String[] args) {
    int arr[] = {3, 1, 4, 10, 2};
    int target = 6;

    // int[] res = solution2(arr, arr.length, target);
    int[] res = solution3(arr, arr.length, target);

    System.out.println("Couple with array: "+ Arrays.toString(res));
  }


  /*
  * Solution 1: Brute force
  * 
  * using 3 loops and checking, if arr[i] + arr[j] + a[k] == target
  * 
  * Time O(n^3)
  * 
  */



  /*
  * Solution 2: Using Hash maps (like the problem - pair with sum equals zero)
  * 
  * Use 1 loop from i=0 to n-2
  * For each element arr[i], 
  *  check next pair of elements with sum = target - arr[i], using map (Pair_with_sum_equals_x.solution2)
  * 
  *
  * Time: O(n^2), Space O(n^2)
  * 
  */



  /*
  * Solution 3: Sort and apply 2 pointer (like the problem - pair with sum equals zero)
  * 
  * Use 1 loop from i=0 to n-2
  * For each element arr[i], c
  *  check next pair of elements with sum = target - arr[i], using map (Pair_with_sum_equals_x.solution3)
  * 
  *
  * Time: O(n^2 * log(n)), Space: O(1)
  * 
  */

}
