package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
  /*
   * Solution 1: Making pop costlier
   * Solution 1: Making push costlier
   * 
   * In both the cases above, we need to swap the queues
   */
  public static class Stack {
    int top = -1;
    int size = 0;
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    
    void push(int item){
      
    }

    int pop(){
      
    }

    int peek(){
      
    }
  }
}

