package PrePlaced.LinkedList;

public class A10_Find_Union_and_Intersection_of_LL {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  /*
   * Approach 1: Using HashMap | HashSet
   * - Store all the node values of 1st LL in Hash set, and also store it in Union List
   * - Then in the next step, while going though 2nd list nodes
   *   - if cur node value is there in Set, then add that value to Intersection List
   *   - If its not there in Set, add it to union List
   * 
   * Time: O(n), Space: O(n)
   * This uses extra space
   */

  /*
   * Approach 2: Using Merge sort and Union find method
   * - First sort both the linked list
   * 
   * Solution link: https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
   * 
   * Time: O(n log n)  Space: O(n)
   */

  
}
