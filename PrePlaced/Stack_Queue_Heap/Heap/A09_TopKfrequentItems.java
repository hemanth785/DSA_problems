package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * 
 * link: https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class A09_TopKfrequentItems {
  public static void main(String[] args) {
    int arr[] = new int[]{2,2,2,5,5,7,7,9,4};
    int k = 2;

    int[] res = topKFrequent(arr, k);

    System.out.println("Top k frequent items: "+ Arrays.toString(res));
  }


  /*
   * solution 1: 
   * - Use map to store the frequency of each integer
   * - Then store the each map entry in the List
   * - Sort the List item by fequency of number - use custom comparator: 
   * https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
   * 
   * Time: N* log(n)
   */

  /*
   * Solution 2: using map and MaxHeap
   * - Use map to store the fequence of each integer
   * - Create Max PriorityQueue with custom comparator
   * - store the elements from map to PQ
   * - remove k items from PQ
   */
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
      //if 2 numbers having same frequency, give the priority to number with more value ((descending))
      if (a.getValue() == b.getValue()) {
        return Integer.compare(b.getKey(), a.getKey());
      }
      // else compare it bases on fequency (descending)
      return Integer.compare(b.getValue(), a.getValue());
    });

    for (Map.Entry entry : countMap.entrySet()) {
      pq.add(entry);
    }

    int res[] = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.remove().getKey();
    }
    return res;
  }
}
