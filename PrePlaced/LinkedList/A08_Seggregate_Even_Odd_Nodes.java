package PrePlaced.LinkedList;

/*
 * Link: 
 */
public class A08_Seggregate_Even_Odd_Nodes {
  class Node
  { 
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
  }

  /* ---------------- */

  public static Node segregateEvenOdd(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node evenHead = null;
    Node oddHead = null;
    Node evenTail = null;
    Node oddTail = null;

    Node cur = head;
    while (cur != null) {
      if (cur.data % 2 == 0) {
        // even
        if (evenHead == null) {
          evenHead = cur;
          evenTail = cur;
        } else {
          evenTail.next = cur;
          evenTail = cur;
        }

      } else {
        if (oddHead == null) {
          oddHead = cur;
          oddTail = cur;
        } else {
          oddTail.next = cur;
          oddTail = cur;
        }
      }
      cur = cur.next;
    }

    if (evenHead == null) {
      return oddHead;
    }
    evenTail.next = oddHead;
    if (oddTail != null) {
      oddTail.next = null;
    }

    return evenHead;
  }
}
