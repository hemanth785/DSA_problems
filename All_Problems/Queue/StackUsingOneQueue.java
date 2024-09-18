package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {

  public static void main(String args[]){
    System.out.println("hello");
    Stack stack = new Stack();
    System.out.println("hello2");
    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println("hello3");
    System.out.println("peek: "+stack.peek());
    System.out.println("pop: "+stack.pop());
    System.out.println("peek: "+stack.peek());
  }
  
  /*
   * Solution: making push costlier, dequeue all the existing elements and enque it after adding the current element
   * 
   */
  public static class Stack {
    int top = -1;
    int size = 0;
    Queue<Integer> queue = new LinkedList<>();
    
    void push(int item){
      int prevSize = size;
      queue.add(item);
      size++;
      while(prevSize > 0){
        queue.add(queue.remove());
        prevSize--;
      }
    }

    int pop(){
      if(size <= 0){
        System.out.println("Stack is empty");
        return -1;
      }
      size--;
      return queue.remove();
    }

    int peek(){
      if(size <= 0){
        System.out.println("Stack is empty");
        return -1;
      }
      return queue.peek();
    }
  }
}
