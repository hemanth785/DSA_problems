package LinkedList;
import java.util.Stack;
import java.util.Arrays;
/*
 * You are given the head of a linked list with n nodes.
 * For each node in the list, find the value of the next greater node. 
 * That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
 * 
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * 
 * Input: 3 -> 6 -> 2-> 9
 * Output: [6, 9, 9, 0]
 */
public class A10_Next_greater_node_on_right {
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

  public static int findSize(Node head) {
    int count =0;
    while (head!=null) {
        count++;
        head=head.next;
    }
    return count;
  }

  //-----------
  public static void main(String args[]){
    int arr[] = {3, 7, 5, 9, 2, 6, 7, 2, 4};

    Node head = createList(arr);
    int[] nextMaxArr = nextGreaterElementOnRight(head);
    System.out.println("Next max array: "+ Arrays.toString(nextMaxArr));
  }

  /*
   * Solution 1: Bruteforce
   * - Traverse LL for each node,
   * - For each node in LL, traverse all the next nodes to find the item which is just greater than current element
   * - If no greater element found, insert '0' in the output array
   * 
   * Time: O(n^2), Space: O(1)
   */


   
  /*
   * Solution 2: Using stack
   * - Traverse each Node in LL
   * - For each element, 
   *   -> if Stack is empty, insert current element and its index
   *   -> If stack is not empty, compare top element with current node value
   *      -> if stackElement < curNodeValue, then store the curNodeValue in Stored position of the element stored in stack and pop that element
   *      -> if stackElement >= curNodeValue, push the curNodeValue and its index to stack
   * 
   *   -> Once we reach the end of list, for all the elements still in stack, update 0 for that
   */

  private static int[] convertToArray(Node head, int n) {
    int[] arr = new int[n];
    int i=0;
    while(head!=null) {
        arr[i++] = head.data;
        head = head.next;
    }
    return arr;
  }

  public static int[] nextGreaterElementOnRight(Node head){
    int n = findSize(head);
    int[] arr = convertToArray(head, n);
    int[] nextMaxArr = new int[n];
    Stack<Integer> stack = new Stack<Integer>();

    for(int i=0; i<n; i++){
      while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
        nextMaxArr[stack.peek()] = arr[i];
        stack.pop();
      }
      stack.push(i);
    }

    return nextMaxArr;
  }
}
