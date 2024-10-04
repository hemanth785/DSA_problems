package PrePlaced.LinkedList;

/*
 * Link: https://www.geeksforgeeks.org/problems/find-length-of-loop/1
 */
public class A07_Find_cycle_length {
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

  /* ------------------ */

  public int countNodesinLoop(Node head) {
    if(head == null || head.next == null){
      return 0;
    }
    
    //1. find the first cycle node
    Node firstCycleNode = getFirstCyclicNode(head);
    if(firstCycleNode == null){
        return 0;
    }
    
    //2. complete 1 cycle to find the cycle length
    Node cur = firstCycleNode.next;
    int cycleLength = 0;
    while(cur != firstCycleNode){
        cur = cur.next;
        cycleLength++;
    }
    
    return cycleLength+1;
  }

  public Node getFirstCyclicNode(Node head){
    Node slow = head;
    Node fast = head;

    //check if cycle exists or node
    boolean isCycleExists = false;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        isCycleExists = true;
        break;
      }
    }

    if(!isCycleExists){
      return null;
    }

    //Now: move the fast pointer back to head and move both the pointer one step at a time
    fast = head;
    while(slow != fast){
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  } 
}
