package PrePlaced.LinkedList;

import java.util.HashMap;

/*
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */

public class A09_CloneRandomPointerLL {
  public static class Node {
    int data;
    Node next = null;
    Node random = null;

    Node() { }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next, Node random) {
        this.data = data;
        this.next = next;
        this.random = random;
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
    int arr[] = {3,7,5,3,2,6,7,4,2,9};

    Node head = createList(arr);
    head = copyRandomList(head);

    printList(head);
  }


  /*
   * Solution 1: using hasmap (extra space) to store originalNode and clonedNode pair
   * 
   * Time: O(n), Space: O(n)
   */
  public static Node copyRandomList(Node head) {
    if(head == null){
        return head;
    }
    
    //create a cloned LL while keeping map of adjacent original LL to cloned LL
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    Node clonedHead = new Node(head.data);
    Node clonedPrev = clonedHead;

    map.put(head, clonedHead);

    Node cur = head.next;
    //1. create the duplicate list using next pointer, while inserting original and cloned node pain in Map
    while(cur != null){
      Node clonedCur = new Node(cur.data);
      clonedPrev.next = clonedCur;

      map.put(cur, clonedCur);

      clonedPrev = clonedCur;
      cur = cur.next;
    }

    //2. Now assign random pointers to cloned list nodes
    cur = head;
    Node clonedCur = clonedHead;
    while(cur != null){
      Node randomNode = map.get(cur.random);
      clonedCur.random = randomNode;

      cur = cur.next;
      clonedCur = clonedCur.next;
    }

    return clonedHead;
  }


  /*
   * Solution 2: Temperarily inserting cloned nodes in between original LL nodes
   * 
   * 1->2->3->4->
   * 
   * 1->1*->2->2*3->3*4->4*    - here* represents cloned node
   */

  public Node copyRandomList2(Node head) {
    if (head == null) {
      return head;
    }

    // Step1: clone a node and insert between original nodes
    Node cur = head;
    while (cur != null) {
      Node clonedCur = new Node(cur.data);

      Node nxt = cur.next;
      cur.next = clonedCur;
      if (nxt != null) {
        clonedCur.next = nxt;
      }

      cur = nxt;
    }

    // Step2: add the random pointer to cloned Nodes
    cur = head;
    while (cur != null) {
      Node clone = cur.next;
      if (cur.random != null) {
        clone.random = cur.random.next;
      }
      cur = clone.next;
    }

    // Step3: seperate the original node and cloned nodes
    Node clonedHead = head.next;
    cur = head;
    while (cur != null) {
      Node clone = cur.next;
      cur.next = clone.next;
      if (cur.next != null) {
        clone.next = cur.next.next;
      }
      cur = cur.next;
    }

    return clonedHead;
  }

  //Note: Step2 and Step3 cannot be combined since, random poiter can point to previous node of current node
}
