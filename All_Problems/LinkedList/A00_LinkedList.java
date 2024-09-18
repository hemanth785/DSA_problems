package LinkedList;

public class A00_LinkedList { 
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

  public void createList(Node head, int arr[]){
    if(arr.length <= 0){
      return;
    }
    Node cur = head;
    for(int i=0; i<arr.length; i++){
      cur.data = arr[i];
      cur = cur.next;
    }
  }

  public void printList(Node head){
    while(head != null){
      System.out.print(head.data);
      System.out.print("->");
      head = head.next;
    }
  }
}

