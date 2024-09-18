package LinkedList;
/*
 * Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
 * Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.
 */
public class A15_Merge_sort {
  public static class Node {
    int data;
    Node next = null;

    Node() { }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
  }

  private static Node createList(int arr[]){
    Node head = new Node();
    head = new Node(arr[0]);
    Node prevNode = head;

    for(int i=1; i<arr.length; i++){
      Node node = new Node(arr[i]);
      prevNode.next = node;
      prevNode = node;
    }
    return head;
  }

  private static void printList(Node head){
    Node current = head;
    while(current != null){
      System.out.print(current.data);
      if(current.next != null){
        System.out.print(" -> ");
      }
      current = current.next;
    }
  }

  /*
   * Approach:
   * 1. Find the mid item using fast and slow pointer
   * 2. create 2 lists by disconnectinng nodes at mid (head2 = mid.next, mide.next = null)
   * 3. call mergeSort again on these 2 lists
   * 4. Once list size becomes 1, start merging list (same as merging 2 sorted lists)
   */

  //-----------
  public static void main(String args[]){
    int arr[] = {3, 7, 5, 9, 2, 6, 7, 2, 4};

    Node head = createList(arr);
    head = mergeSort(head);
    printList(head);
  }

  /*Solution */
  public static Node findMiddleRevamp(Node head) {
    Node slow=head, fast=head;
    while(fast.next!=null && fast.next.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
  }

  public static Node mergeSortedLL(Node head1, Node head2){
    if(head1 == null){
      return head2;
    }
    if(head2 == null){
        return head1;
    }

    Node mergedHead = null;  

    if(head1.data < head2.data){
      mergedHead = head1;
      head1 = head1.next;
    } else {
      mergedHead = head2;
      head2 = head2.next;
    }

    Node cur = mergedHead;
    while(head1 != null && head2 != null){
      if(head1.data < head2.data){
        cur.next = head1;
        head1 = head1.next;
      } else {
        cur.next = head2;
        head2 = head2.next;
      }
      cur = cur.next;
    }

    if(head1 != null){
      cur.next = head1;
    }
    if(head2 != null){
      cur.next = head2;
    }

    return mergedHead;
  }

/*
 * Time: O(n*Log(n)), space: O(n), size fo the recursive stack
 */
  public static Node mergeSort(Node head){
    if(head == null || head.next == null){
      return head;
    }
    Node mid = findMiddleRevamp(head);
    Node midNext = mid.next;
    mid.next = null;

    Node firstHalf = mergeSort(head);
    Node secondHalf = mergeSort(midNext);

    head = mergeSortedLL(firstHalf, secondHalf);

    return head;
  }
}
