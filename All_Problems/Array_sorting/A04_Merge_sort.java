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
    
    merge(arr, low, mid, high);  // merging sorted halves
  }

  public static void merge(int arr[], int low, int mid, int high){
    ArrayList<Integer> temp = new ArrayList<>(); // temporary array
    int left = low;      // starting index of left half of arr
    int right = mid + 1;   // starting index of right half of arr

    //storing elements in the temporary array in a sorted manner//

    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
        right++;
      }
    }

    // if elements on the left half are still left
    while (left <= mid) {
      temp.add(arr[left]);
      left++;
    }

    //  if elements on the right half are still left
    while (right <= high) {
      temp.add(arr[right]);
      right++;
    }

    // transfering all elements from temporary to arr
    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }
  }
  
}
