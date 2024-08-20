package Heap.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 */

 /*
  * Solution 1: bruteforce
  * - insert new element in array
  * - whenever we need to find median, 
     -  sort the array, and return the middle element (avaerage of 2 items, if array of even length)   
     
     Time: O(n log(n))
  */


  /* 
   * Solution 2: Efficient using priority queue
   * - create 2 Priority queue - left (max PQ) & Right (min PQ)
   * - while inserting
   *  - if both queue are empty, insert into left queue
   *  - if cur_item is less than top item in left PQ, insert it into left pq
   *  - if cur_item is greater than top item in left PQ, insert it into right pq
   *  - then balance the queue, if size diff is greater than 1
   * 
   * - while fetching the median element,
   *  - if right is emtpy, return left top element
   *  - if one queue has more element, requrn top element from that queue
   *  - if both queue is having same items, return average of top item of the both the queue
   */
public class A08_MedianFinder {
  PriorityQueue<Integer> right;
  PriorityQueue<Integer> left;

  public A08_MedianFinder() {
    right = new PriorityQueue<>(); // min pq
    left = new PriorityQueue<>(Comparator.reverseOrder()); // max pq
  }

  public void addNum(int num) {
    if (left.isEmpty() || num < left.peek()) {
      left.add(num);
      
    } else {
      right.add(num);
    }

    // rebalance to pq
    if ((left.size() - right.size()) > 1) {
      right.add(left.remove());
    } else if ((right.size() - left.size()) > 1) {
      left.add(right.remove());
    }
  }

  public double findMedian() {
    if (left.size() == 0 && right.size() == 0) {
      return 0.0;
    }
    if (left.size() > right.size()) {
      return (double) left.peek();
    }
    if (left.size() < right.size()) {
      return (double) right.peek();
    }
    return (double) (left.peek() + right.peek()) / 2;

  }
}
