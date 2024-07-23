package Array_sorting;

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

  public static void devide(int arr[], int l, int r){
    if(l >= r){
      return;
    } 
    int mid = (l+r)/2;

    // System.out.println(l +", "+mid+", "+r);
    devide(arr, l, mid);
    devide(arr, mid+1, r);

    // after deviding the list until each partition contains one element, then start merging while sorting
    merge(arr, l, mid, r);
  }

  public static void merge(int arr[], int l, int mid, int r){
    int n1 = mid-l+1; //we are adding 1 here because, for 1st array we considering mid element
    int n2 = r-mid; // here we are not adding 1 becuase, we are considering elements from mid+1

    int leftArr[] = new int[n1];
    int rightArr[] = new int[n2];

    //Store left and right array elements in temporary array
    for(int i=0; i<n1; i++){
      leftArr[i] = arr[i+l];
    }

    for(int i=0; i<n2; i++){
      rightArr[i] = arr[i+mid+1];
    }

    int i=0;
    int j=0;
    int k=l;

    //compare and add elements
    while(i<n1 && j<n2){
      if(leftArr[i] < rightArr[j]){
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }

    //add leftover elements into original array
    while(i<leftArr.length){
      arr[k++] = leftArr[i++];
    }
    while(j<rightArr.length){
      arr[k++] = rightArr[j++];
    }
  }

  
  
  
}