package Heap.PriorityQueue;

import java.util.PriorityQueue;

public class A05_MergeKSortedLinkedLists {
  public static class ListNode {
    int data;
    ListNode next = null;

    ListNode() { }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
  }
  
  /*
   * Solution 1: This problem can be solved by merging 2 linked list at a time (already done in LinkedList section)
   * Time: O(n * k)
   */


  /*
   * Solution 2: This problem also can be solved by using Priority Queue of size k
   * 
   * - Push the heads of all the given list into priorty queue (where the headnode with highest value will be at the top)
   * - Remove the top node(Max val) from PQ one at a time, add it to result list and inserting next node of currently removed node (if exists)
   * - do this until we exhaust all the k lists
   * 
   * Time: O(N log k), this is definitely better solution than above
   */
  
   public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
    for (int i = 0; i < n; i++) {
      if (lists[i] != null) {
        pq.add(lists[i]);
      }
    }

    //edge case
    if (pq.size() == 0) {
      return null;
    }

    //populate the result head node
    ListNode resHead = pq.poll();
    if (resHead.next != null) {
      pq.add(resHead.next);
    }

    ListNode cur = resHead;
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      if (node.next != null) {
        pq.add(node.next);
      }

      cur.next = node;
      cur = cur.next;
    }

    return resHead;
  }
}
