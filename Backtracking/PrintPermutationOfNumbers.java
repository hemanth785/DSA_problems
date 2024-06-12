package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutationOfNumbers {
  /*
   * Link: https://leetcode.com/problems/permutations/description/
   */
  public static void main(String[] args) {
    int arr[] = {1,2,3};
    printAllPermutations(arr);
  }

  public static void printAllPermutations(int[] arr){
    List<String> result = new ArrayList<>();
    String numberPermutations = "";
    int n = arr.length;

    backtrack(arr, n, numberPermutations, result);

    System.out.println(result.toString());
  }

  public static void backtrack(int[] arr, int n, String numberPermutations, List<String> result){
    
    if(numberPermutations.length() == n){
      result.add(numberPermutations);
      return;
    }

    for(int i=0; i<n; i++){
      char item = (char)(arr[i]+'0');
      //checking if number is already added to the number string
      if(numberPermutations.indexOf(item) == -1){
        backtrack(arr, n, numberPermutations + item, result);
      }
    }
  }
}


/* Hackar rank */
// public static List<List<Integer>> permutations(int n, List<Integer> arr) {
//   List<List<Integer>> result = new ArrayList<List<Integer>>();
  
//   List<Integer> numberPermutations = new ArrayList<Integer>();
//   backtrack(arr, n, numberPermutations, result);

//   return result;
// }

// public static void backtrack(List<Integer> arr, int n, List<Integer> numberPermutations, List<List<Integer>> result){
//   if(numberPermutations.size() == n){
//     result.add(numberPermutations);
//     return;
//   }

//   for(int i=0; i<n; i++){
//     int item = arr.get(i);
//     if(!numberPermutations.contains(item)){
//         List<Integer> newList = new ArrayList<Integer>(numberPermutations);
//         newList.add(item);
//       backtrack(arr, n, newList, result);
//     }
//   }
// }

  
