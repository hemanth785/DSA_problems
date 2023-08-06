package LinkedList;

public class ReverseLL {
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
    int arr[] = {3,7,5,3,2,6,7,4,2,9};

    Node head = createList(arr);
    head = reverseList(head);

    printList(head);
  }

  public static Node reverseList(Node head){
    if(head.next == null){
      return head;
    }
    Node prev = null;
    Node cur = head;
    Node next = head.next;
    while(next != null){
      cur.next = prev;
      
      prev = cur;
      cur = next;
      next = next.next;
    }
    cur.next = prev;
    return cur;
  }
}
