package Array_sorting;

import java.util.Arrays;

public class Selection_sort {
  public static void main(String[] args) {
    int arr[] = {2,4,1,8,7,3,9,6,2,7,4};

    int[] res = selectionSort(arr);

    System.out.println("Sorted array: "+ Arrays.toString(res));
  }

  /*
   * Selection sort finds minimum value at each iteraration and fills it from left side
   * 
   * Selection sort is about selecting the minimum element at each iteration, and placing it at correct position
   * 
   * iteration 1: i=0, find min value in array[i=1 to n], if we find min element, swap it with ith element
   * iteration 1: i=1, find min value in array[i=2 to n], if we find min element, swap it with ith element
   * ..
   * ...
   */

  public static int[] selectionSort(int arr[]){
    int n = arr.length;

    for(int i=0; i<n-1; i++){
      int min = arr[i];
      int minIndex = i;

      for(int j=i+1; j<n; j++){
        if(arr[j] < min){
          min = arr[j];
          minIndex = j;
        }
      }

      if(min != arr[i]){
        arr[minIndex] = arr[i];
        arr[i] = min;
      }
      
    }
    
    return arr;
  }
}
