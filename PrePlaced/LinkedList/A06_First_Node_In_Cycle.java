package PrePlaced.LinkedList;

/*
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class A06_First_Node_In_Cycle {
  public static class ListNode {
    int data;
    ListNode next = null;

    ListNode() { }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
  }

  /* ------------- */

  /*
   * Solution 1: Using hashmap to store reference of node
   * - While looping through each node of list, store the each node reference in the hashmap
   * - and at each step, keep checking if the current node is aleady there in the map,
   * - If any node is in the map, then the list has a cycle
   */

  /*
   * Solution 2: Using slow and fast pointer
   * - First detect whether cycle exists or not, using the slow and fast pointer
   * - If Loop is detected, move only 'fast pointer' back to the head node
   * - Then starting move slow and fast pointer, one step at a time, until meet at some point
   * - That meeting point will be 'First node in cycle'
   */

   public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null){
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

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

  /*
   *  ----WHY ABOVE SOLUTION WORKS-------
   * solution Link: https://www.youtube.com/watch?v=2Kd0KKmmHFc
   * Refere image in: PrePlaced/LinkedList/Images/First_node_in_cycle_explanation.png
   * 
   * Explanation:-----
   * - There are 2 lengths we have to consider
   *   L1 - Length of Non-cyclic part of LinkedList
   *   L2 - Length of cyclic part of linked list
   * 
   * - Now when, 'Slow pointer' at the first node of cycle, by covering L1 distance from head
   * - At this time, 'Fast pointer' at a distance of 'L1' ahead of 'slow pointer' (Considering cyclic movement)
   * - Considering the direction in which fast pointer has to travel to reach slow pointer, 
   *    - Now the distance between 'fast pointer' and 'slow pointer', can be defined as 'd'
   * 
   * - Now from above observations we can conclude that, L2 = L1 + d  ----- eq-1
   *                                                     L2 - d = L1  ----- eq-2
   * 
   * - Considering the fact that, when fast pointer moves, 2 steps and slow pointer moves 1 step,
   *   i.e. The speed of Fast pointer with respect to slow pointer is actally, one node at unit time.
   * 
   * - Since 'slow pointer' is 'd' distance ahead from 'fast pointer', when slow pointer and fast pointer meets at some point,
   *    - Slow pointer and fast pointer and is at a distance of 'd' from the 'first cyclic node', in clockwise direction
   * 
   * - so we know that total cycle length is L2 and pointers at disance of 'd' ahead of first cyclic node
   *    - So according to "equation 2", we can conclude that, pointers need to cover distance L1 from this meeting point to reach 'first cyclic node'
   * 
   * 
   */
}
