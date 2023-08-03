package Array_sorting;

import java.util.Arrays;
public class Bubble_sort {
   public static void main(String[] args) {
    int arr[] = {2,4,1,8,7,3,9,6,2,7,4};

    int[] res = bubbleSort(arr, arr.length);

    System.out.println("Sorted array: "+ Arrays.toString(res));
  }

  public static void swap(int arr[], int i, int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  /*
   * Bubble sort works by comparing each element againt each other
   * 
   * In the 1st iteration, it puts max element to the correct postition (if we iterate from left to right)
   * 
   * Time: O(n^2),
   */
  public static int[] bubbleSort(int arr[], int n){
    for(int i=0; i<n; i++){
      Boolean swapped = false;

      for(int j=0; j<n-i-1; j++){
        if(arr[j] > arr[j+1]){
          swap(arr, j, j+1);
          swapped = true;
        }
      }

      if(swapped == false){
        return arr; //this is to check if array is already sorted
      }
    }
    return arr;
  }
}
