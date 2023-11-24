/*
 * find subarray in a given array which sums equal to value x
 * input: [2,4,1,8,7,3,9], targetSum = 16
 * 
 * output: [1,8,7]
 * 
 * Subarray: we have to find the sum for the elements in order and together
 * i.e: [2,7,3] is not a subarray
 */

import java.util.Arrays;

public class Find_subarray_sum_equuals_x {
  public static void main(String[] args) {
    int arr[] = {2,4,1,8,7,3,9};
    int targetSum = 11;

    // int[] res = solution2(arr, arr.length, targetSum);
    int[] res = solution2(arr, arr.length, targetSum);

    System.out.println("Subarray array with sum equals x: "+ Arrays.toString(res));
  }

  /*
   * Solution 1: Brute force
   * 
   * - iterate over the array with two loop
   * - for each element in array, find the sum including every other element
   * - if(summation of(arr[i] to arr[j]) == targetSume)
   *      return [arr[i],arr[i+1]....arr[j]]
   * 
   * Time: O(n^2)
   */

  /*
   * Solution 2: Use sliding window aproach
   * 
   * Time: O(n)
   */

  public static int[] solution2(int arr[], int n, int target){
    int l=0, r=0;
    int sum = arr[l];

    if(sum == target){
      return new int[]{arr[l]};
    }

    Boolean isExists = false;
    while(l < n-1){
      if(sum == target){
        isExists = true;
        break;
      } else if(sum < target){
        r+=1;
        sum += arr[r];
      } else {
        sum -= arr[l];
        l++;
      }
    }

    if(isExists){
      int resArr[] = new int[r-(l-1)];
      int index = 0;
      for(int i=l; i<=r; i++){
        resArr[index] = arr[i];
        index++; 
      }
      return resArr;
    } else {
      return new int[]{};
    }
   }
}
