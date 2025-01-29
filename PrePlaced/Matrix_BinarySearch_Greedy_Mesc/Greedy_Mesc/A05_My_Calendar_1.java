package Matrix_BinarySearch_Greedy_Mesc.Greedy_Mesc;

import java.util.ArrayList;
import java.util.List;

/*
 * Link: https://leetcode.com/problems/my-calendar-i/description/
 */
public class A05_My_Calendar_1 {

  /*
   * Solution 1: Comparing new event against all the existing event
   * 
   * time: O(n^2)
   */
  List<int[]> calendar;

  public A05_My_Calendar_1() {
    calendar = new ArrayList<>();
  }
  
  public boolean book(int start, int end) {
    for(int[] event: calendar){
      //The simplest logic
      if(! (end <= event[0] || start >= event[1])){ //if both condition does not satisfy, return false
        return false;
      }
    }

    calendar.add(new int[]{start, end});
    return true;
  }

  /*
   * Solution 2: Using Binary Search tree to store events
   * - Events which have endTime less than startTime of root node, store it on left sub-tree
   * - Events whcih have startTime greater than endTime of root node, store it on right sub-tree
   * 
   * Time: O( log(n) )
   */

  static class Node{
    int start;
    int end;
    Node left;
    Node right;

    Node(int start, int end){
      this.start = start;
      this.end = end;
    }
  }

  Node root = null;
  
  public boolean book2(int start, int end) {
    if(root == null){
      root = new Node(start, end);
      return true;
    }
    return insertEvent(this.root, start, end);
  }

  private boolean insertEvent(Node root, int start, int end){
    //check if event can be inserted in left subtree
    if(end <= root.start){
      if(root.left == null){
        root.left = new Node(start, end);
        return true;
      }
      return insertEvent(root.left, start, end);
    }
    if(start >= root.end){
      if(root.right == null){
        root.right = new Node(start, end);
        return true;
      }
      return insertEvent(root.right, start, end);
    }

    return false;
  }

}
