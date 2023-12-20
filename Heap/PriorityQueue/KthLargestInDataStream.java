package Heap.PriorityQueue;

import java.util.PriorityQueue;

/*
 * Link: https://workat.tech/problem-solving/practice/kth-largest-from-data-stream
 */
public class KthLargestInDataStream {
  PriorityQueue<Integer> pq;
  int k = 0;

  public KthLargestInDataStream(int k) {
    this.k = k;
    pq = new PriorityQueue<>();
  }

  public int add(int num) {
    pq.add(num);
    if (pq.size() < k) {
      return -1;
    }
    while (pq.size() > k) {
      pq.poll();
    }
    return pq.peek();
  }
}
