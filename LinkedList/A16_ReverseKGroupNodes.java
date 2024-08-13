package LinkedList;

import Heap.PriorityQueue.MergeKSortedLists.ListNode;

public class A16_ReverseKGroupNodes {
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
    int arr[] = {1,2,3,4,5,6,7,};

    Node head = createList(arr);
    int k = 3;
    head = reverseInKGroupsRecursive(head, k);

    printList(head);
  }


  public static Node reverseList(Node head){
    if(head == null || head.next == null){
      return head;
    }
    Node prev = null;
    Node cur = head;
    Node next = head.next;

    while(cur != null){
      cur.next = prev;
      prev = cur;
      cur = next;
      if(next != null){
          next = next.next;
      }
    }

    return prev;
  }

  public static Node reverseInKGroupsRecursive(Node head, int k) {
    if (head == null || head.next == null || k == 1) {
      return head;
    }
    Node cur = head;
    Node finalHead = null;

    int index = 1;
    Node curHead = head;
    Node prevTail = null;
    Node nextHead = null;

    while (cur != null && cur.next != null) {
      cur = cur.next;
      index++;

      if (index == k) {
        nextHead = cur.next; // to keep track of next k group head
        cur.next = null; // to help reverse the k nodes
        Node reversedHead = reverseList(curHead);

        if (finalHead == null) {
          finalHead = reversedHead;
        }

        if (prevTail != null) {
          prevTail.next = reversedHead;
        }
        
        prevTail = curHead;
        curHead = nextHead;
        cur = nextHead;
        index = 1;
      }
    }
    if (prevTail != null) {
      prevTail.next = curHead;
    }

    return finalHead;
  }
}


