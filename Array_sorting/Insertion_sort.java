package Array_sorting;

import java.util.Arrays;

public class Insertion_sort {
  public static void main(String[] args) {
    int arr[] = {2,4,1,8,7,3,9,6,2,7,4};

    int[] res = insertionSort(arr);

    System.out.println("Sorted array: "+ Arrays.toString(res));
  }

  public static void swap(int arr[], int i, int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  /*
   * Insertion sort is works on the principle that. at each iteration moving from left to right make the array on the left as sort
   * 
   * Steps:
   * - start with i+1 th element, assuming 1st element is sorted
   * - place the current(i+1) element in correct position in the left array, starting from right side of left array
   */

  public static int[] insertionSort(int arr[]){
    int n = arr.length;
    for(int i=1; i<n; i++){
      int temp = arr[i];
      int j = i-1;

      while(j>=0 && temp <= arr[j]){
        // System.out.println(Arrays.toString(arr));
        arr[j+1] = arr[j]; 
        j = j-1;
      }
      arr[j+1] = temp;
    }

    return arr;
  }

  /*
   * - Insertion sort is best for Nearly sorted array, since its time complexity will be nearly equals: O(n)
   * - Array elements are required to be sorted in reverse order. 
   *    That means suppose you have to sort the array elements in ascending order, 
   *    but its elements are in descending order. The worst-case time complexity of insertion sort is O(n2).
   */


   /*My solution  */
  void insertionSort2(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int cur = i;
      int j = i - 1;
      while (j >= 0 && arr[cur] < arr[j]) {
        swap(arr, cur, j);
        cur = j;
        j--;
      }
    }
  }

}
