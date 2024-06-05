package Array_sorting;

import java.util.Arrays;

/*
 * 
 * Merge sort:
 * - Time: always:  [n * log(n)]
 * - Uses extra space (left and right sub Array)
 * 
 * Quick sort:
 * - Time: Worst case: [n^2], Average case: [n * log(n)] (if we use middle or random element as pivot)
 * - Does not use extra space
 */

public class Quick_sort {
  public static void main(String[] args) {
    int arr[] = {2,4,1,8,7,3,9,6,2,7,4};
    // int arr[] = {4,3,9,2,6,1,5};
    int[] res = quickSort(arr);
    System.out.println("Sorted array: "+ Arrays.toString(res));
  }

  public static void swap(int arr[], int i, int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  public static void partitionAndSort(int arr[], int l, int r){
    if(l<r){
      int pivotIndex = partition(arr, l, r);

      partitionAndSort(arr, l, pivotIndex-1);
      partitionAndSort(arr, pivotIndex+1, r);
    }
  }

  // This is the most simple logic, just need to look at it once, whenever you come accross it
  public static int partition(int arr[], int l, int r){
    int i=l;
    int j=l;
    int pivot = r;

    while(i<r){
      if(arr[i] < arr[pivot]){
        swap(arr, i, j);
        j++;  // move the j only when swapping. its used to mark the greater value. 
      }
      i++;
    }
    swap(arr, i, j); //now i is pointing to pivot element, and j is pointing to pivot index
    return j; //j is the actual pivot position
  }


  public static int[] quickSort(int arr[]){
    
    partitionAndSort(arr, 0, arr.length-1);

    return arr;
  }
}
