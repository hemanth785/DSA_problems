package LinkedList;
/*
 * Given the head of a singly linked list, return the middle node of the linked list.

 * If there are two middle nodes, return the second middle node.
 * 
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class A05_Find_middle_element {
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
    int arr[] = {3, 7, 5, 9, 2, 8, 7, 11};
    Node head = createList(arr);

    Node middleNode = findMiddleNode(head);

    System.out.println("Middle element in list is: "+middleNode.data);
  }

  /*
   * Solution 1: 
   * - Find the length of the linked list
   * - traverse till length/2 and return the middle eleemnt
   * 
   * Note: requires to traverse the list 2 times
   */

   /*
    * Solution 2: Optimized (Slow and fast pointer)
    * - initially point the both slow and fast pointer to head
    * - slow pointer will move one node at a time, while fast pointer will move 2 nodes at a time
    * - Once the fast pointer reach the last element, slow pointer will point to middle element
    */

    public static Node findMiddleNode(Node head){
      Node fast = head, slow = head;
      while(fast!= null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow;
    }
}
