package Stack_Queue;
/*
 * Minimum stack problem: https://leetcode.com/problems/min-stack/description/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */

import java.util.Stack;

public class A07_Min_Stack {

  /*
   * Approach 1: Using 2 stacks
   * - One stack stores the actual element
   * - Another stack for storing the min Values at each stage
   *
   * Time: O(n), Space: O(n) - using extra space here
   */

  class MinStack1 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack1() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }

    public void push(int val) {
      stack1.push(val);
      if (stack2.isEmpty()) {
        stack2.push(val);
      } else {
        stack2.push(Math.min(stack2.peek(), val));
      }
    }

    public void pop() {
      stack1.pop();
      stack2.pop();
    }

    public int top() {
      if (stack1.isEmpty()) {
        return -1;
      }
      return stack1.peek();
    }

    public int getMin() {
      if (stack1.isEmpty()) {
        return -1;
      }
      return stack2.peek();
    }
  }

  /*
   * Approach 2: Without using extra space
   * - While inserting element, if element is lesser than cur min value. itemToPush = (2*cur - min) in stack
   * - while fetching the top element from stack, if top item is lesser than min item. min = (2*min - cur)
   * 
   * -Note: if stack going to contain only positive numbers (excluding 0), we can use formula 'curMin - cur' formula
   */

  class MinStack {

    Stack<Integer> stack = new Stack<>();
    int min = 0;

    void push(int val) {
      if (stack.isEmpty()) {
        stack.push(val);
        min = val;
        return;
      }
      if (val >= min) {
        stack.push(val);
        return;
      }
      // if cur val is lesser than, existing Min,
      // calculate the value to be inserted based of previous min
      stack.push(2 * val - min);
      min = val;
    }

    void pop() {
      if (stack.isEmpty()) {
        return;
      }
      if (stack.peek() >= min) {
        stack.pop();
        return;
      }

      //if top value is lesser than min, calculate next min using the current and min value
      int cur = stack.pop();
      min = (2 * min - cur);
    }

    int top() {
      if (stack.isEmpty()) {
        return -1;
      }
      return stack.peek();
    }

    int getMin() {
      if (stack.isEmpty()) {
        return -1;
      }
      return min;
    }
  }
}
