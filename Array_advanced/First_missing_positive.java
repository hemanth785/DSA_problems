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
    int arr[] = {2, 3, -7, 6, 8, 1, -10, 15}; //for numbers range from 1-n - variation 2
    int n = 5;
    int duplicateSmallNumber = solution1(arr, n);

    System.out.print("Smallest duplicate number: "+ duplicateSmallNumber);
  }

  public static int solution1(int[] arr, int n){
    //check if 1 is missing int the array, and also mark all negative numbers and numbers > n as 1
    boolean is1Found = false;
    for(int i=0; i<n; i++){
        if(arr[i] == 1){
            is1Found = true;
            continue;
        }
        if(arr[i] < 0 || arr[i] > n){
            arr[i] = 1; 
        }
    }

    if(!is1Found){
        return 1;
    }


    //check if any other number is missng in the array using index marking mathod
    int minMissingNumber = Integer.MAX_VALUE;
    for(int i=0; i<n; i++){
        int item = Math.abs(arr[i]);
        if((item-1) >= 0){
            arr[item-1] = -Math.abs(arr[item-1]);
        }
        
    }

    for(int i=0; i<n; i++){
        if(arr[i] > 0){
            if((i+1) < minMissingNumber){
                minMissingNumber = i+1;
            }
        }
    }

    return minMissingNumber;
  }
}
