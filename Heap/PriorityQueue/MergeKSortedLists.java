package Heap.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;



public class MergeKSortedLists {
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
    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.data));

    for (ListNode head : lists) {
      if (head != null) {
        pq.add(head);
      }

    }

    ListNode root = null;
    ListNode cur = null;
    while (!pq.isEmpty()) {
      ListNode top = pq.remove();
      if (root == null) {
        root = top;
        cur = top;
      } else {
        cur.next = top;
        cur = cur.next;
      }
      if (top.next != null) {
        pq.add(top.next);
      }
    }

    return root;
  }
}
