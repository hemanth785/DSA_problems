package Stack;
/*
 * https://www.hackerrank.com/contests/logicmojo-assignment-june-batch/challenges/queue-using-two-stacks
 * 
 * Implement the Queue using 2 stacks
 */
public class QueueUsingStack {
  /*
   * Solution 1: By making enQueue operation costly
   * 
   * < This method makes sure that oldest entered element is always at the top of stack 1, 
   * so that deQueue operation just pops from stack1. 
   * To put the element at top of stack1, stack2 is used.>
   * 
   * Time Complexity: 
      - Push operation: O(N). 
          In the worst case we have empty whole of stack 1 into stack 2.
      - Pop operation: O(1). 
          Same as pop operation in stack.
      - Auxiliary Space: O(N). 
          Use of stack for storing values.  
   * 
   * 
   *  enQueue(q, x): 

      - While stack1 is not empty, push everything from stack1 to stack2.
      - Push x to stack1 (assuming size of stacks is unlimited).
      - Push everything back to stack1.
      - Here time complexity will be O(n)

      deQueue(q): 

      - If stack1 is empty then error
      - Pop an item from stack1 and return it
      - Here time complexity will be O(1)
   */

  //  public static void enqueue(Stack stack1, Stack stack2, int item){
  //     if(stack1.empty()){
  //         stack1.push(item);
  //         return;
  //     } 
  //     while(!stack1.empty()){
  //         stack2.push(stack1.pop());
  //     }
  //     stack1.push(item);
  //     while(!stack2.empty()){
  //         stack1.push(stack2.pop());
  //     }
  // }

  /*
   * Solution 2:
   * enQueue(q,  x)
      1) Push x to stack1 (assuming size of stacks is unlimited).
        Here time complexity will be O(1)

      deQueue(q)
        1) If both stacks are empty then error.
        2) If stack2 is empty
            While stack1 is not empty, push everything from stack1 to stack2.
        3) Pop the element from stack2 and return it.
      Here time complexity will be O(n)

      NOTE: 
      Method 2 is definitely better than method 1. 
      Method 1 moves all the elements twice in enQueue operation, 
      while method 2 (in deQueue operation) moves the elements once and moves elements only if stack2 empty. 
      So, the amortized complexity of the dequeue operation becomes  O(1)
   * 
   * 
   * 
   */
  
  public static int deQueue(Stack<Integer> stack1, Stack<Integer> stack2){
    if(stack1.empty() && stack2.empty()){
        return -1;
    }
    //if stack2 is not empty, then return the top element from it
    if(!stack2.empty()){
        return stack2.pop();
    }
    //if stack2 is empty, move all the element from the stack1 to stack2 and then return top element from stack2
    while(!stack1.empty()){
        stack2.push(stack1.pop());
    }
    return stack2.pop();
  }
}
