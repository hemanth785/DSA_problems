package PrePlaced.LinkedList;

/*
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class A11_Reverse_K_Group_Nodes {
  public static class ListNode {
    int data;
    ListNode next = null;

    ListNode() { }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
  }
  /* ----------------- */

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode resHead = null;

    ListNode cur = head;
    ListNode prevHead = head;
    ListNode prevTail = null;

    int tempK = 1;
    while(cur != null){
      if(tempK == k){
        ListNode next = cur.next;
        cur.next = null;
        ListNode curHead = reverseList(prevHead);

        //this only executes once
        if(resHead == null){
          resHead = curHead;
        }

        if(prevTail != null){
          prevTail.next = curHead;
        }
        prevTail = prevHead;

        prevHead = next;
        cur = next;
        tempK = 1;

      } else {
        cur = cur.next;
        tempK++;
      }
    }

    if(prevTail != null){
      prevTail.next = prevHead;
    }

    return resHead;
  }

  public static ListNode reverseList(ListNode head){
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
