package Stack_Queue_Heap.Stack_Queue;

import java.util.Stack;

/*
 * Link: https://www.geeksforgeeks.org/problems/sort-a-stack/1
 */
public class A04_Sort_stack {
  /*
   * Approach: 
   *  1. Create a temporary stack say tmpStack.
      2. While input stack is NOT empty do this: 
          a. Pop an element from input stack call it temp
          b. While temporary stack is NOT empty and top of temporary stack is less than temp, 
          c.pop from temporary stack and push it to the input stack
          d. Push temp in temporary stack
      3. The sorted numbers are in tmpStack

   */
  public Stack<Integer> sort(Stack<Integer> input) {
    Stack<Integer> tempStack = new Stack<>();
    
    while(!input.isEmpty()){
      int temp = input.pop();
      
      while(!tempStack.isEmpty() && tempStack.peek() > temp){
        input.push(tempStack.pop());
      }
      
      tempStack.push(temp);
    }
    
    return tempStack;
  }
}
