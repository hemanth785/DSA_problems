package LinkedList;

public class A18_Flatten_Sorted_LL {
  public static class Node {
    int data;
    Node next = null;
    Node bottom = null;

    Node() { }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }

    Node(int data, Node next, Node bottom) {
        this.data = data;
        this.next = next;
        this.bottom = bottom;
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
    head = flatten(head);

    printList(head);
  }



  public static Node flatten(Node root)
  {
    Node cur = root;
    Node flattenedList = null;
    while(cur != null){
      flattenedList = mergeSortedLL(flattenedList, cur);
      cur = cur.next;
    }
    
    return flattenedList;
  }
  
  public static Node mergeSortedLL(Node head1, Node head2){
    if(head1 == null){
      return head2;
    }
    if(head2 == null){
        return head1;
    }

    Node mergedHead = null;  

    if(head1.data < head2.data){
      mergedHead = head1;
      head1 = head1.bottom;
    } else {
      mergedHead = head2;
      head2 = head2.bottom;
    }

    Node cur = mergedHead;
    while(head1 != null && head2 != null){
      if(head1.data < head2.data){
        cur.bottom = head1;
        head1 = head1.bottom;
      } else {
        cur.bottom = head2;
        head2 = head2.bottom;
      }
      cur = cur.bottom;
    }

    if(head1 != null){
      cur.bottom = head1;
    }
    if(head2 != null){
      cur.bottom = head2;
    }

    return mergedHead;
  }
}
