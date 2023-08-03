/*
 * Rotate the array of size n by 'd' elements to the left
 * input: [4,7,2,1,9,10,12], d=2
 * 
 * output: [2,1,9,10,12,4,7]
 */

import java.util.Arrays;

public class Rotation_of_array {
  public static void main(String[] args) {
    int arr[] = {4,7,2,1,9,10,12};
    int d = 3;

    // int[] res = solution2(arr, arr.length, d);
    int[] res = solution3(arr, arr.length, d);

    System.out.println("Rotated arry: "+ Arrays.toString(res));
  }


  /*
   * Solution 1: Brute force
   * 
   * For(int i=0 to d)
   *    for(int j=0 to n)
   *        <shift each element on every iteration using temp variable>
   * 
   * Time: O(d * n), space: O(1)
   */


  /*
   * Solution 2: Use extra space
   * 
   * - declare new array, res_arr
   * - iterate on input array from i=d to n-1, on each iterarion push each element to res_arr
   * - iterate on input array from i=0 to d-1 
   * 
   * Time: O(n), space: O(n)
   */

  public static int[] solution2(int arr[], int n, int d){
    int rotatedArr[] = new int[n];
    int index = 0;
    for(int i=d; i<n; i++){
      rotatedArr[index] = arr[i];
      index++;
    }

    for(int i=0; i<d; i++){
      rotatedArr[index] = arr[i];
      index++;
    }

    return rotatedArr;
  }

  /*
   * Solution 3: Use reverse array technique (redcue space complexity)
   * 
   * - reverse input array from i=0 to d-1,
   * - reverse input array from i=d to n-1
   * - reverse the whole input array
   * 
   * Time: O(n), space: O(1)
   */

  public static int[] reverseArray(int arr[], int l, int r){
    while(l<r){
      int temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;

      l++;
      r--;
    }
    return arr;
  }

  public static int[] solution3(int arr[], int n, int d){
    reverseArray(arr, 0, d-1);
    reverseArray(arr, d, n-1);
    
    reverseArray(arr, 0, n-1);

    return arr;
  }


}
