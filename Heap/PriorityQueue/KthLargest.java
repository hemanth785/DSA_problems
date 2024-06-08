package Heap.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargest {
  public static void main(String[] args) {
    int arr[] = new int[]{6,5,3,2,8,10,9};
    int k = 3;
    int kthLargest = findKthLargest(arr, k);
    System.out.println(k+"th largest element: "+kthLargest);
  }

  /*
   * Solution 1: Using sorting and picking kth element from starting
   * 
   * Time: O(n log(n)), space: O(1)
   */

  /*
   * Solution 2: using Max heap
   * - Store all the element from the array into  max heap
   * - then remove k-1 element from heap
   * - now the top element will be kth largest in array
   * 
   * Time: O(n log(n)), space: O(n)
   * 
   * this approach also takes nlogn because, heapifying element n size heap would take log n
   */

  /*
   * Solution 3: Using Min heap of size k (Efficient)
   * - Iterate over the input array while storing it in minHeap
   * - Whenever heap size crosses k, remove top element
   * - Once we reach end of input array, top element in minHeap is the kth Largest
   */
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < nums.length; i++) {
      pq.add(nums[i]);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    return pq.remove();
  }
}
