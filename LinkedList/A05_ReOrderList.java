package LinkedList;

/*
 * Link: https://leetcode.com/problems/reorder-list/
 */
public class A05_ReOrderList {

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
  }

  /*
   * Approach: 
   * - First find teh middle of list
   * - Reverse the 2nd half of list
   * - Insert 2nd list nodes between the first List nodes
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    ListNode mid = findMiddleNode(head);

    ListNode secondHead = mid.next;
    mid.next = null;

    ListNode rHead = reverseList(secondHead);

    ListNode cur = head;
    ListNode nxt1 = rHead;  //nxt1 will point to the node, which head will be pointing next
    ListNode nxt2 = head.next; //nxt2 will point to next node of other List
    while (cur != null && nxt1 != null) {
      cur.next = nxt1;
      cur = cur.next;
      nxt1 = nxt2;
      nxt2 = cur.next;
    }

  }

  public static ListNode findMiddleNode(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static ListNode reverseList(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = head.next;
    while (next != null) {
      cur.next = prev;

      prev = cur;
      cur = next;
      next = next.next;
    }
    cur.next = prev;
    return cur;
  }
}
