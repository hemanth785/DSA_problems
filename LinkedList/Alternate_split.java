package LinkedList;
/*
 * Given a singly linked list of size N. 
 * Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller list. 
 * The sublists should be made from alternating elements from the original list.
 * 
 * https://practice.geeksforgeeks.org/problems/split-singly-linked-list-alternatingly/1
 */
public class Alternate_split {
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
    System.out.println();
  }


  //-----------
  public static void main(String args[]){
    int arr[] = {3, 7, 5, 9, 2, 6, 7, 2, 4};

    Node head = createList(arr);
    alternateSplit(head);
    // printList(head);
  }

  /*
   * Solution 1: Bruteforce
   * - Loop through the original LL to 2 times, to create 2 new LL
   * 
   * Time: O(n), Space: O(n)
   */

  /*
   * Solution 2: Optimizing for Space
   * - Modity the the existing the LL, by updating the next pointer of each node
   * 
   * Time: O(n), Space: O(n)
   */

  public static void alternateSplit(Node head){
    Node cur = head;
    Node nxt = head.next;

    Node head1 = cur;
    Node head2 = nxt;
    
    while(nxt != null){
      cur.next = nxt.next;

      cur = nxt;
      nxt = nxt.next;
    }

    printList(head1);
    printList(head2);

  }
}
