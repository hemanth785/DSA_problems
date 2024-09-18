package Heap.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A06_SortKSortedArray {
  public static void main(String[] args) {
    int arr[] = new int[] { 6, 5, 3, 2, 8, 10, 9 };
    int n = 7;
    int k = 3;
    // int[] sorted = sortNearlySorted(arr, n, k);
    int[] sorted = sortAlmostSorted(arr, n, k);
    System.out.println("Sorted array: " + Arrays.toString(sorted));
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
   * - In k sorted array, we know that all the elements will be max k distance
   * away from original distance
   * - So first element in sorted list can be found in first k+1 elements
   * - Hence push k+1 elements into heap
   * - then keep removing top element and adding it to result, and simultaniously
   * adding next element to heap.
   * 
   */
  
  /*
   * Simple solution
   */
  static int[] sortAlmostSorted(int[] arr, int n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int[] sorted = new int[n];

    int index = 0;
    for (int i = 0; i < n; i++) {
      pq.add(arr[i]);

      if (pq.size() > k) {
        sorted[index++] = pq.poll();
      }
    }

    while (!pq.isEmpty()) {
      sorted[index++] = pq.poll();
    }

    return sorted;
  }
}
