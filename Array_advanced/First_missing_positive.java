package Array_advanced;

import java.util.Arrays;

/*
 * Given an unsorted array arr[] with both positive and negative elements,
 * the task is to find the smallest positive number missing from the array. u
 * with time: O(n) and without using extra space
 * Note: You can modify the original array.
 *
 *
 *
 * Input:  arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 }
 * Output: 1
 *
 * Input:  arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 }
 * Output: 4
 *
 * Input: arr[] = {1, 1, 0, -1, -2}
 * Output: 2
 *
 * Hackerrank link: https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/first-missing-positive-3/problem
 */

public class First_missing_positive {

  public static void main(String[] args) {
    int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 }; //for numbers range from 1-n - variation 2
    int n = 5;
    int duplicateSmallNumber = solution3(arr, n);

    System.out.print("Smallest duplicate number: " + duplicateSmallNumber);
  }

  /*
   * Solution 1: Sorting the array
   * - After sorting the array, check which is the first smallest positive integer is missing (Compareing current and next value)
   *
   * time: O(n log(n)), because of the sorting
   */

  /*
   * Soluton 2: Using Set
   * - We know that, for array of size n, max value for missing min positive could be n+1
   * - So push all the array elements in Set
   * - Then run a loop from i=1 to n+1 while checking that i is present in set or not
   * - The element which is missing from Set is Min positive integer missing
   *
   * Time: O(n), Space: O(n) - we are using extra space here
   */

  /*
   * Solution 3: Marking in the given input array (for this we need all the numbers in the array as positive)
   * Steps
   * - First loop through array to check if 1 is exists, if not return 1
   * - Convert all negatives and 0's to 1 (0's to 1 because, we can mark 1 it as negative, but not 0), 
   * - Find the maxValue in array which is lesser than or equal to n
   * - now loop through array, to mark exisisting item index values as negative i.e. arr[item-1] = -arr[item-1]
   * - Now loop in array to check for first item in array which is positive, if found ans is 'indexOf(item)+1' is the missing min positive
   * - if everything is positive, then maxValue+1 is the ans
   *
   * Time: O(n), Space: O(1)
   */

  public int firstMissingPositive(int[] arr) {
    int n = arr.length;
    //check if 1 is missing int the array, and also mark all negative numbers and 0 as 1
    boolean is1Found = false;
    int maxAllowedPositiveNumber = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        is1Found = true;
      }
      if (arr[i] <= 0 || arr[i] > n) {
        arr[i] = 1;
      }
      if (arr[i] > maxAllowedPositiveNumber) {
        maxAllowedPositiveNumber = arr[i];
      }
    }

    if (!is1Found) {
      return 1;
    }

    //check for min positive number is missng in the array
    for (int i = 0; i < n; i++) {
      int item = Math.abs(arr[i]);
      if ((item - 1) >= 0) {
        arr[item - 1] = -Math.abs(arr[item - 1]);
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        return i + 1;
      }
    }
    return maxAllowedPositiveNumber + 1;
  }
}
