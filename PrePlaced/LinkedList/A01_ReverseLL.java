package PrePlaced.LinkedList;

/*
 * Link: https://leetcode.com/problems/reverse-linked-list/
 */
public class A01_ReverseLL {
  public static class Node {
    int data;
    Node next = null;

    Node() { }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
  }

  /*------------ */

  /*
   * Iterative
   */
  public static Node reverseList(Node head){
    if(head.next == null){
      return head;
    }
    Node prev = null;
    Node cur = head;
    Node next = head.next;
    
    while(next != null){
      cur.next = prev;
      
      prev = cur;
      cur = next;
      next = next.next;
    }
    cur.next = prev;
    
    return cur;
  }

  /*
   * Recursive
   */
  public Node reverseListRec(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    return reverseRec(head, null);
  }

  public Node reverseRec(Node cur, Node prev) {
    if (cur.next == null) {
      cur.next = prev;
      return cur;
    }

    Node next = cur.next;
    cur.next = prev;

    return reverseRec(next, cur);
  }
}
