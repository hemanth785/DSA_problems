/*
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

class A10_DeleteAllDuplicateItemsInList{
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
   * Approach: 
   * - Define the Dummy node which points to head node of list
   * - Make this dummy also as the prev node
   * - iterate through list while checking for condition (head.val === head.next.val)
   * -    If any moment this condition satisfies, run a inner loop to traverse all the current duplicate item.
   * -    Once we found the next different item, break the loop, and point the prev pointer to next diff element
   * -    and move head pointer
   * 
   * - in the outer loop, if dup element not found at each step, just increment prev and head pointer
   * 
   * - at the end, just return the Dummy->next as result head 
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while(head != null){
      //if duplicate item found
      if(head.next != null && head.val == head.next.val){
        while(head.next != null && head.val == head.next.val){
          head = head.next;
        }
        prev.next = head.next;
        head = head.next;
      } else {
        prev = prev.next;
        head = head.next;
      }
    }
    return dummy.next;
  }
}