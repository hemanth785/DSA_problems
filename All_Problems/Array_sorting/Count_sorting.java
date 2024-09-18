package Array_sorting;

import java.util.Arrays;

public class Count_sorting {
  public static void main(String[] args) {
    int arr[] = {4, 2, 5, 3, 1};
    countingSort(arr);
    System.out.println("Array after sorting: "+ Arrays.toString(arr));
  }
  static void countingSort(int[] arr) {
    int n = arr.length;
    //1. Find the max number in given array
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, arr[i]);
    }

    //2. Create count array of size max+1
    int[] countArr = new int[max + 1];

    //3. Find the count of each number and store it in count array
    for (int i = 0; i < n; i++) {
      countArr[arr[i]] = countArr[arr[i]] + 1;
    }

    //4. Find the cumulative sum in the count array
    for (int i = 1; i < countArr.length; i++) {
      countArr[i] = countArr[i] + countArr[i - 1];
    }

    //5. Loop over the input array and filling sort array based on count-1 as starting position
    int sorted[] = new int[n];
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      int index = countArr[num] - 1;
      countArr[num] = index;
      sorted[index] = num;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = sorted[i];
    }
  }
}
