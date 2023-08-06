package LinkedList;

/*
 * Given a singly linked list of N nodes. Find the first node of the loop if the linked list has a loop. 
 * If a loop is present return the node data of the first node of the loop else return -1.
 */
public class First_node_in_Circular_LL {
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
  //-----------
  public static void main(String args[]){
    int arr[] = {3, 7, 5, 3, 2, 56, 7, 4, 2, 4};

    Node head = createList(arr);
    printList(head);
  }

  /*
   * Solution 1: Using hashmap
   * - Store reference of node in Hashmap, 
   * - Check in map for each iteration, if node exisits in map
   * - If yes, thats the first node in CLL
   */

  /*
   * Solution 2: Mark next pointer of each node as null
   * - First verify if the given linked list is CLL or not, if yes
   * - While looping through each node, mark next pointer of each node as null,
   * - if you find any node with next pointer alrady null, that the first node in CLL
   */

  public static Node findFirstNodeInCLL(Node head){
    Node firstCycle = null;
    
    boolean isCycleExists = detectLoop(head);
    if(isCycleExists){
      Node cur = head;
      while(cur != null){
        cur = cur.next;
      } 
      firstCycle = cur;
    } 
    return firstCycle;
  }
}
