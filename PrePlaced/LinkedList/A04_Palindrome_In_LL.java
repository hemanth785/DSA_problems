package PrePlaced.LinkedList;

/*
 * Link: https://leetcode.com/problems/palindrome-linked-list/
 */
public class A04_Palindrome_In_LL {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  /* ---------------- */


  public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null){
      return true;
    }
    if(head.next.next == null){
      return head.val == head.next.val;
    }

    ListNode mid = findMidNode(head);

    ListNode head2 = mid.next;
    mid.next = null;

    head2 = revereseLL(head2);

    while(head != null && head2 != null){
      if(head.val != head2.val){
        return false;
      }
      head = head.next;
      head2 = head2.next;
    }

    return true;
  }

  public ListNode findMidNode(ListNode head){
    ListNode slow = head;
    ListNode fast = head;

    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public ListNode revereseLL(ListNode head){
    if(head.next == null){
      return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = head.next;
    while(next != null){
      cur.next = prev;
      
      prev = cur;
      cur = next;
      next = next.next;
    }
    cur.next = prev;
    
    return cur;
  }
}
