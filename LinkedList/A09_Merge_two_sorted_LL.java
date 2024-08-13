package LinkedList;
/*
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. 
 * The list should be made by splicing together the nodes of the first two lists.
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions/
 */
public class A09_Merge_two_sorted_LL {
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


  //-----------
  public static void main(String args[]){
    int arr1[] = {2, 5, 8, 9};
    int arr2[] = {1, 3, 4, 7};

    Node head1 = createList(arr1);
    Node head2 = createList(arr2);

    Node head = mergeSortedLL(head1, head2);

    printList(head);
  }

  /*
   * Solution 1: Extra space required
   * - iterate over both the lists simultaniously, 
   * - While comparing the each node, insert the node in ascending order new LL
   * 
   * Time: O(n), Space: O(n)
   */


  /*
   * Solution 2: Update the links in the same given LL
   * 
   * Time: O(n), Space: O(1)
   */

  public static Node mergeSortedLL(Node head1, Node head2){
    if(head1 == null){
      return head2;
    }
    if(head2 == null){
        return head1;
    }

    Node mergedHead = null;  

    //identify the head node of merged list
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
}
