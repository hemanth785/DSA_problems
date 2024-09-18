package LinkedList;
/*
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class A11_Check_for_palindrome {
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

  public static Node findMiddleNode(Node head){
    Node fast = head, slow = head;
    while(fast!= null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
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
  //-----------
  public static void main(String args[]){
    int arr[] = {3, 7, 5, 5, 7, 3};

    Node head = createList(arr);
    boolean isPalindrome = checkForPalindrome(head);
    if(isPalindrome){
      System.out.print("Linked list is a palindrome");
    } else {
      System.out.print("Linked list is Not a palindrome");
    }
  }
  /*
   * Solution 1: Bruteforce
   * - Reverse the given linkedlist and store it seperately
   * - Iterate both the linkedlist simultaniously, while comparing each element
   * - at each iteration, if value of node1 and node2 is same, then it is a palindrome
   */

  /*
   * Solution 2: using stack
   * - iterate through the list to find out the length of the list (wheter to find its even length or odd length)
   * - traverse till mid of the list, while pushing each node value to the stack
   * - Note: If length of list is odd, dont add middle element, otherwise add it
   * - While traversing from middle of list to end, pop each element and compare it with node value at that iteration
   */

  /*
   * Solution 3: Reversing 1st half and comparing with 2nd half
   * - make firstHalf = head
   *  - get the mid node
   *  - reverese the 2nd half from the mid, assign secondHalf = last_node_of_list (which is reversed)
   *  - traverse both the list simultaniously, until 2nd half of node reaches null 
   * Note: (should not check for 1st half is null, because its still connected to 2nd half of the list)
   */

  public static boolean checkForPalindrome(Node head){
    Node midNode = findMiddleNode(head);
    Node firstHalf = head;
    Node secondHalf = reverseList(midNode);

    while(secondHalf != null){
      if(firstHalf.data != secondHalf.data){
        return false;
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }
    return true;

  }
}
