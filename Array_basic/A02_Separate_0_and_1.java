/*
 * Separate 0 and 1’s in an array
 * Input = [0,1,0,1,1,0] 
 * Output = [0,0,0,1,1,1]
 * 
 */

import java.lang.reflect.Array;
import java.util.*;

public class A02_Separate_0_and_1 {
  public static void main(String[] args) {
    int arr[] = {1,0,1,1,0,1,0};
    
    int[] res = Solution2(arr, arr.length);

    System.out.print("Seperated array: "+ Arrays.toString(res));
  }

  /*
   * Solution 1: Simple solution
   * Loop through array once to get the number of 0's and 1's
   * Loop the same array 2nd time to override the current array by inserting 0's for count, 
   * and followed by one for the count identified
   * 
   * Time: O(n), space: O(1)
   */



   /*
    * Solution 2: Two pointer approach
    * Time: O(n), space: O(1)
    */
    public static int[] Solution2(int arr[], int n){
      int l=0, r=n-1;
      while(l<r){
        if(arr[l] == 1 && arr[r] == 0){
          swap(arr, l, r);
          l++;
          r--;
        } 
        else if(arr[l] == 1){
          r--;
        } else if(arr[r] == 0){
          l++;
        } else {
          //if both l and r values are in correct order, increment both
          l++;
          r--;
        }
      }

      return arr;
    }

    public static void swap(int arr[], int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
}
