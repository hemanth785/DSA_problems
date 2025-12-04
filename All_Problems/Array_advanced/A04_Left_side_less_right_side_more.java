package Array_advanced;

import java.util.Arrays;

/*
 * Given an unsorted array of size N. 
 * Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
 * 
 * Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
 *
 * Input: [4 3 2 1 5 9 8 7]
 * Output: 5
 * 
 * Note: This is similar to Rainwater tapping problem
 */
public class A04_Left_side_less_right_side_more {
  public static void main(String[] args) {
    int arr[] = {4, 3, 2, 1, 5, 9, 8, 7};
    int res = solution2(arr);

    System.out.println("Result: "+res);
    
  }

  /*
   * Solution 1: Brute force
   * loop through each item in array, to find if all the elemnts to left are lesser and all the elements to right are greater
   * 
   * Time: O(n^2)
   * 
   */

   /*
    * Solutoin 2: Using leftMax and rightMin array
    *
    * Time: O(n), Space: O(n)
    */

    private static int solution2(int arr[]){
      int n = arr.length;
      int maxLeftArr[] = new int[n];
      int minRightArr[] = new int[n];
      
      maxLeftArr[0] = arr[0];
      minRightArr[n-1] = arr[n-1];
      for(int i=1; i<n; i++){
          maxLeftArr[i] = maxLeftArr[i-1];
          minRightArr[n-i-1] = minRightArr[n-i];
          
          if(arr[i] > maxLeftArr[i]){
              maxLeftArr[i] = arr[i];
          }
          if(arr[n-i-1] < minRightArr[n-i-1]){
              minRightArr[n-i-1] = arr[n-i-1];
          }
      }
      System.out.println(Arrays.toString(maxLeftArr));
      System.out.println(Arrays.toString(minRightArr));
      
      int res = -1;
      for(int i=1; i<n-1; i++){
          if(maxLeftArr[i] == minRightArr[i]){
              res = maxLeftArr[i];
              break;
          }
      }

      return res;
    }
}
