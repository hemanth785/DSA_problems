package LinkedList;
/*
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
 * If the two linked lists have no intersection at all, return null.
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Intersect_point_in_LL {
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
    int arr1[] = {3, 7, 5, 3, 2};
    int arr2[] = {4, 8};
    int arr3[] = {10, 12, 9};


    Node head1 = createList(arr1);
    Node head2 = createList(arr2);
    Node head3 = createList(arr3);

    Node cur1 = head1;
    Node cur2 = head2;
    while(cur1.next != null){
      cur1 =cur1.next;
    }
    while(cur2.next != null){
      cur2 =cur2.next;
    }
    // cur1.next = head3;
    cur2.next = head3;

    intersectionInLL(head1, head2);
  }

  /*
   * Solution 1: Using hashmap
   * - loop through 1st linkedlist to each node ref in map
   * - loop through 2nd linkedlist, which checking if node is exists in the map
   * - If yes, thats the intersection point
   * 
   * Time: O(n), Space: O(n)
   */

   /*
   * Solution 2: Optimized (Reduce space)
   * - Loop through each LL, to find the length
   * - Find the length diff
   * - whichever the LL has more length, traverse the diff in length 1st
   * - then traverse both the LL together to compare each element
   * - If in any case Node(ll1) == Node(ll2), thats the intersection point
   */

  public static void intersectionInLL(Node head1, Node head2){
    Node cur1 = head1;
    Node cur2 = head2;
    
    int diff = 0;
    while(cur1 != null){
      diff++;
      cur1 = cur1.next;
    }
    while(cur2 != null){
      diff--;
      cur2 = cur2.next;
    }

    while(head1 != null && head2 != null){
      if(diff > 0){
        head1 = head1.next;
        diff--;
      } else if(diff < 0){
        head2 = head2.next;
        diff++;
      } else {
        if(head1 == head2){
          System.out.println("Intersection point is: "+head1.data);
          return;
        }
        head1 = head1.next;
        head2 = head2.next;
      }
    }    
    System.out.println("Not intersection");
  }
}
