package LinkedList;
/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * 
 * https://leetcode.com/problems/add-two-numbers/
 */
public class A02_Add_two_numbers {
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
    int arr1[] = {2, 5, 8, 9};
    int arr2[] = {1, 3, 4, 7};

    Node head1 = createList(arr1);
    Node head2 = createList(arr2);

    Node head = addTwoNumbers(head1, head2);

    printList(head);
  }



  public static Node addTwoNumbers(Node l1, Node l2){
    // Since the given LL is already reversed, no need to reverse again
    if(l1==null)
        return l2;
    if(l2==null)
        return l1;

    int sum, val,carryOver =0;
    Node head =null, curr = null;
    while (l1!=null && l2!=null) {
      sum = l1.data + l2.data + carryOver;
      val = sum%10;
      carryOver = sum/10;
      if(head==null) {
          head = new Node(val);
          curr = head;
      } else {
          curr.next = new Node(val);
          curr = curr.next;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    while(l1!=null) {
      sum = l1.data + carryOver;
      val = sum%10;
      carryOver = sum/10;
      curr.next = new Node(val);
      l1 = l1.next;
      curr = curr.next;
    }

    while(l2!=null) {
        sum = l2.data + carryOver;
        val = sum%10;
        carryOver = sum/10;
        curr.next = new Node(val);
        l2 = l2.next;
        curr = curr.next;
    }
    if(carryOver!=0) {
      curr.next = new Node(carryOver);
    }

    return head;
  }
}
