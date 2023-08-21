package LinkedList;

public class ReverseKGroupNodes {
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

  public static Node reverseInKGroupsRecursive(Node head, int k){
        
    if(head == null || head.next ==null){
        return head;
    } 
    
    int index = 1;
    Node prev = null;
    Node cur = head;
    Node nxt = head.next;
    
    //reverse k grouped nodes
    while(index <= k && cur != null && cur.next != null){
        cur.next = prev;
            
        prev = cur;
        cur = nxt;
        nxt = nxt.next;

        index++;
    }
    
    //if pointer reached last node of list, return it
    if(index <= k){
        cur.next = prev;
        return cur;
    }
    
    
    
    Node reversedHead = reverseInKGroupsRecursive(cur, k);
    
    //point the tail of current reversed group to head of next reversed group
    head.next = reversedHead;
    
    //prev will act has head for the current reversed group
    return prev;
  }
}


