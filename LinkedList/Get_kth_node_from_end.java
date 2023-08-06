package LinkedList;
/*
 * Given a linked list consisting of L nodes and given a number N. 
 * The task is to find the Nth node from the end of the linked list.
 * 
 * Input:
 * N = 2
 * LinkedList: 1->2->3->4->5->6->7->8->9
 * Output: 8
 * 
 * https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
 */

public class Get_kth_node_from_end {
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
    int arr[] = {3, 7, 5, 3, 2, 56, 7, 4, 2, 4};
    Node head = createList(arr);

    getKthNodeFromEnd(head, 4);

    // printList(head);
  }

  /*
   * Solution 1: 
   * 
   * - traverse the complete linked list to get the size(n) of the linked list
   * - then again traverse (n-k) times to reach kth position from the last
   * - Print the kth nodes
   * 
   * note: This requires to traverse the list 2 times
   */


   /*
    * Solution 2: Optimized (Two pointer)
    * - move 1st pointer to the kth position from start
    * - move 1st and 2nd pointer, until 1st pointer reaches the end of list
    * - Now whatever the position 2nd pointer is, i.e. the kth position from the end of list
    */
  public static void getKthNodeFromEnd(Node head, int k){
    Node pointer1 = head;
    Node pointer2 = head;

    int position = 1;
    while(position < k){
      pointer1 = pointer1.next;
      position++;
    }
    while(pointer1.next != null){
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    System.out.println(k +" th element from last is: "+ pointer2.data);
  } 
}
