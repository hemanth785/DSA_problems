package Heap.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedArray {
  public static void main(String[] args) {
    int arr[] = new int[]{6,5,3,2,8,10,9};
    int n = 7;
    int k = 3;
    int[] sorted = sortNearlySorted(arr, n, k);
    System.out.println("Sorted array: "+ Arrays.toString(sorted));
  }

  /*
   * Solution 1: We can use any optimum sorting algorithm to sort this
   * 
   * Time: O(n log(n))
   */


  /*
   * Solution 2: Using the heap of size k+1 (Optimum solution)
   * 
   * Approach: 
   * - In k sorted array, we know that all the elements will be max k distance away from original distance
   * - So first element in sorted list can be found in first k+1 elements
   * - Hence push k+1 elements into heap
   * - then keep removing top element and adding it to result, and simultaniously adding next element to heap.
   * 
   */
  static int[] sortNearlySorted(int arr[], int num, int k)
  {
    int[] result = new int[num];
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    // first insert k+1 elements
    for (int i = 0; i < k + 1; i++) {
      pq.add(arr[i]);
    }
    int index = k + 1;
    int i = 0;
    while (!pq.isEmpty()) {
      result[i] = pq.remove();
      if (index < num) {
        pq.add(arr[index]);
        index++;
      }
      i++;
    }
    return result;
  }
}
