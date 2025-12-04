/*
 * Two elements whose sum is closest to zero. 
 * In an array, find the two element's closest sum whose sum is closest to zero.
 * Input: [-2, 9, 6, 1, 2, -5] 
 * 
 * Output = (-2, 2)
 *
 */


import java.util.Arrays;

public class A16_Sum_closest_to_zero {
  public static void main(String[] args) {
    // int arr[] = {-2, 9, 6, 1, 2, -5};
    int arr[] = {-2, 9, 6, 1, 3, -4};
    
    int[] res = Solution2(arr, arr.length);

    System.out.print("Elements with sum closest to zero: "+ Arrays.toString(res));
  }


  /*
   * Solution 1: Brute force
   * Use nested loop to calculate each item against each other elemeent
   * 
   * Time: O(n^2)
   */



   /*
   * Solution 2: By sorting the input array and applying 2 pointer method 
   * (note: Directly comparaing adjacent elments will not work, since we have to find the number which is closest to zero, not the min number)
   * Once we sort the array, it becomes: [-5, -2, 1, 2, 6, 9]
   * 
   * Time: O(n log(n)), space: O(1)
   */

   public static int[] Solution2(int arr[], int n){
      Arrays.sort(arr);

      int elem1 = 0;
      int elem2 = 0;

      int l=0;
      int r=n-1;
      int closest_sum = Integer.MAX_VALUE;
      while(l<r){
        int current_sum = arr[l]+arr[r];
        if(current_sum == 0){
          return new int[]{arr[l], arr[r]};
        }
        if(Math.abs(current_sum) < Math.abs(closest_sum)){
          closest_sum = current_sum;
          elem1 = arr[l];
          elem2 = arr[r];
        }
        if(current_sum > 0){
          r--;
        } else {
          l++;
        }
      }
      return new int[]{elem1, elem2};
    }


    /*
    * Solution 3: Using Hashmap, <TODO>
    * */
}
