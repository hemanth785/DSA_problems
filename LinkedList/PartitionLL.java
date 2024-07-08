package LinkedList;

public class PartitionLL {
  public static class ListNode {
    int data;
    ListNode next = null;

    ListNode() {
    }

    ListNode(int data) {
      this.data = data;
      this.next = null;
    }

    ListNode(int data, ListNode next) {
      this.data = data;
      this.next = next;
    }
  }

  public ListNode partition(ListNode head, int key) {
    if (head == null) {
      return head;
    }
    ListNode head1 = null;
    ListNode head2 = null;

    ListNode tail1 = null;
    ListNode tail2 = null;

    ListNode cur = head;

    while (cur != null) {
      if (cur.data < key) {
        if (head1 == null) {
          head1 = cur;
          tail1 = cur;
        } else {
          tail1.next = cur;
          tail1 = tail1.next;
        }
      } else {
        if (head2 == null) {
          head2 = cur;
          tail2 = cur;
        } else {
          tail2.next = cur;
          tail2 = tail2.next;
        }
      }
      cur = cur.next;
    }

    if (tail1 != null) {
      tail1.next = head2;
    }
    if (tail2 != null) {
      tail2.next = null;
    }

    return head1 != null ? head1 : head2;
  }
}
