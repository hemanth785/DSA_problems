package LinkedList;

/*
 * Link: https://leetcode.com/problems/partition-list/description/
 */
public class A13_PartitionLL {
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

  /*
   * Approach: Using 2 linked lists
   * - Create head of 2 linked list (and also 2 tail pointers) -initially all of then is null
   * - For each node of original list, check its value against key
   *      - if it is less than the key, then assign it to head1 and tail1(if its empty) or add it as the next pointer of tail1 and move tail pointer
   *      - else assign it to head2 and tail2 (if its empty) or add it as the next pointer of tail2 and move tail pointer
   * - At the end, if tail1 is not empty, then point thhis tail1 to head2 node
   * - If tail2.next is not empty, make next pointer of tail2 is null
   */
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
