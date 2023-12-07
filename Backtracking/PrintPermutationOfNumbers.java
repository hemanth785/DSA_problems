package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutationOfNumbers {
  public static void main(String[] args) {
    int arr[] = {1,2,3};
    //printAllPermutations(arr);
    getAllPermutations("abc");
  }

  public static void backtrack(int[] arr, String numberPermutations, List<String> result){
    int n = arr.length;
    if(numberPermutations.length() == n){
      result.add(numberPermutations);
      return;
    }
    

    for(int i=0; i<n; i++){
      char item = (char)(arr[i]+'0');
      //checking if number is already added to the number string
      if(numberPermutations.indexOf(item) == -1){
        backtrack(arr, numberPermutations + item, result);
      }
    }
  }

  public static void printAllPermutations(int[] arr){
    List<String> result = new ArrayList<>();
    String numberPermutations = "";

    backtrack(arr, numberPermutations, result);

    System.out.println(result.toString());
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

  
