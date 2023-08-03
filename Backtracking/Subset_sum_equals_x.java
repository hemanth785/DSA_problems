package Backtracking;
import java.util.*;
/*
 * given a input array of size n and target sum x 
 * find all the subsets of array whose sum of elements equals to x
 * 
 * input: [2,3,5,7], sum=7
 * 
 * output: {2,5}, {7}
 */

public class Subset_sum_equals_x {
  public static void main(String[] args) {
    int arr[] = {2, 3, 8, 6, 5};
    int target = 8;

    getSubSetSumEqualToTarget(arr, target);
  } 

  /*
   * Approach
   * - write a backtrack recursive function, which calls in form of tree branches
   * - Left branch will keep ignoring each element for calculating sum
   * - right branch will keep including each element for calculating sum
   * 
   * Condition for terminating would be when input array becomes empty
   */
  public static void getSubSetSumEqualToTarget(int[] arr, int target){
    List<Integer> subSet = new ArrayList<Integer>();

    backTrackArrayForSubSetSum(arr, target, 0, subSet);
  }

  private static void backTrackArrayForSubSetSum(int[] arr, int target, int currentIndex, List<Integer> subSet){
    if(target == 0){
      System.out.println(subSet);
      return;
    }

    if(currentIndex >= arr.length){
      return;
    }

    //reject current element for target sum
    backTrackArrayForSubSetSum(arr, target, currentIndex+1, subSet); 

    //select current element for target sum
    subSet.add(arr[currentIndex]);
    backTrackArrayForSubSetSum(arr, target-arr[currentIndex], currentIndex+1, subSet);
    
    subSet.remove(subSet.size()-1);
  }
}
