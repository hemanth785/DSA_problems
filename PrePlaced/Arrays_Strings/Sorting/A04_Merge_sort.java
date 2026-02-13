package Array_sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class A04_Merge_sort {
  public static void main(String[] args) {
    int arr[] = {2,4,1,8,7,3,9,6,2,7,4};
    int[] res = mergeSort(arr);
    System.out.println("Sorted array: "+ Arrays.toString(res));

    // int arr[] = {100,20,90};
    // merge(arr, 0,0,2);
  }

  public static int[] mergeSort(int arr[]){
    int n = arr.length;
    int l=0;
    int r=n-1;

    devide(arr, l, r);

    return arr;
  }

  public static void devide(int arr[], int low, int high){
    if (low >= high){
      return;
    } 

    int mid = (low + high) / 2 ;
    devide(arr, low, mid);  // left half
    devide(arr, mid + 1, high); // right half
    
    sortAndMerge(arr, low, mid, high);  // merging sorted halves
  }

  public static void sortAndMerge(int arr[], int low, int mid, int high){
    ArrayList<Integer> temp = new ArrayList<>(); // temporary array
    int i = low;      // starting index of left half of arr
    int j = mid + 1;   // starting index of right half of arr

    //storing elements in the temporary array in a sorted manner//
    while (i <= mid && j <= high) {
      if (arr[i] <= arr[j]) {
        temp.add(arr[i]);
        i++;
      } else {
        temp.add(arr[j]);
        j++;
      }
    }

    // if elements on the left half are still left
    while (i <= mid) {
      temp.add(arr[i]);
      i++;
    }

    //  if elements on the right half are still left
    while (j <= high) {
      temp.add(arr[j]);
      j++;
    }

    // transfering all elements from temporary to arr
    for (int k = low; k <= high; k++) {
      arr[k] = temp.get(k - low);
    }
  }
  
}
