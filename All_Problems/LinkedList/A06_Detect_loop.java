package LinkedList;
/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class A06_Detect_loop {
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
    boolean isCycleDetective = detectLoop(head);
    if(isCycleDetective){
      System.out.println("Linked list has cycle");
    } else {
      System.out.println("Linked list has no cycle");
    }
    printList(head);
  }

  /*
   * Solution 1: Using hashmap to store reference of node
   * - While looping through each node of list, store the each node reference in the hashmap
   * - and at each step, keep checking if the current node is aleady there in the map,
   * - If any node is in the map, then the list has a cycle
   */

   /*
   * Solution 2: Using the 2 pointers (fast and slow)
   * - if fast and slow pointer nodes becomes same at some point, that means list has cycle/loop
   */

  public static boolean detectLoop(Node head){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;

      if(fast == slow){
        return true;
      }
    }
    return false;
  }
}
