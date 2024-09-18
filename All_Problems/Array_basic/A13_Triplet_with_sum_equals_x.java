import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class A13_Triplet_with_sum_equals_x {
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
  * For each element arr[i], 
  *  check next pair of elements with sum = target - arr[i], using map (Pair_with_sum_equals_x.solution3)
  * 
  *
  * Time: O(n^2 * log(n)), Space: O(1)
  * 
  */

  public static boolean checkIfTripletExistsEqualsTarget(List<Integer> arr, int target){
    int n = arr.size();
    Collections.sort(arr);
    System.out.println(arr);

    for(int i=0; i<n; i++){
      int num1 = arr.get(i);
      int expectedTarget = target - num1;
      
      int l=i+1;
      int r = n-1;
      while(l<r){
          int sum = arr.get(l) + arr.get(r);
          if(sum == expectedTarget){
              return true;
          }
          if(sum < expectedTarget){
              l++;
          } else {
              r--;
          }
      }
      
    }
    return false;
  }






  /*
  * VARIATION: Triplet with closest sum
  * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/3-sum-closest-1/problem
  */
  
  public static int three_sum_close(List<Integer> arr, int target) {
    int n = arr.size();
    Collections.sort(arr);
    System.out.println(arr);
    
    
    int closestSum = 0;
    int minDiff = Integer.MAX_VALUE;
    
    for(int i=0; i<n; i++){
        int num1 = arr.get(i);
        
        int l=i+1;
        int r = n-1;
        while(l<r){
            int sum = num1 + arr.get(l) + arr.get(r);
            int diff = Math.abs(target - sum);
            if(diff < minDiff){
                closestSum = sum;
                minDiff = diff;
            }
            if(sum < target){
                l++;
            } else {
                r--;
            }
        }
        
    }
    return closestSum;
  }

}
